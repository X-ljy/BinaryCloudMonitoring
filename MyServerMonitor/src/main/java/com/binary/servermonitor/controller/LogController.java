package com.binary.servermonitor.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.entity.HostIp;
import com.binary.servermonitor.util.LogFileDetail;
import com.binary.servermonitor.util.RepositoryUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.io.*;
import java.util.zip.ZipOutputStream;


/**
 * @author 夕
 * @date 2019/5/24
 */

@RestController
public class LogController {


    public static void zipFiles(File[] srcFiles, File zipFile) {
        // 判断压缩后的文件存在不，不存在则创建
        if (!zipFile.exists()) {
            try {
                zipFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 创建 FileOutputStream 对象
        FileOutputStream fileOutputStream = null;
        // 创建 ZipOutputStream
        ZipOutputStream zipOutputStream = null;
        // 创建 FileInputStream 对象
        FileInputStream fileInputStream = null;
        try {
            // 实例化 FileOutputStream 对象
            fileOutputStream = new FileOutputStream(zipFile);
            // 实例化 ZipOutputStream 对象
            zipOutputStream = new ZipOutputStream(fileOutputStream);
            // 创建 ZipEntry 对象
            ZipEntry zipEntry = null;
            // 遍历源文件数组
            for (int i = 0; i < srcFiles.length; i++) {
                // 将源文件数组中的当前文件读入 FileInputStream 流中
                fileInputStream = new FileInputStream(srcFiles[i]);
                // 实例化 ZipEntry 对象，源文件数组中的当前文件
                zipEntry = new ZipEntry(srcFiles[i].getName());
                zipOutputStream.putNextEntry(zipEntry);
                // 该变量记录每次真正读的字节个数
                int len;
                // 定义每次读取的字节数组
                byte[] buffer = new byte[1024];
                while ((len = fileInputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, len);
                }
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/DownloadLogFile")
    public void getDownloadLogFile(HttpServletRequest request, HttpServletResponse response, String filepath , String filename) throws IOException {


        ServletContext context = request.getServletContext();
        String fullPath = "/docker/web/LogFile/"+filepath+"/"+filename ;
        File downloadFile = new File("/docker/web/LogFile/"+filepath+"/"+filename);
        // get MIME type of the file
        String mimeType = context.getMimeType("/docker/web/LogFile/"+filepath+"/"+filename);
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
            System.out.println("context getMimeType is null");
        }
        System.out.println("MIME type: " + mimeType);

        // set content attributes for the response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        // set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        // Copy the stream to the response's output stream.
        try {
            InputStream myStream = new FileInputStream(fullPath);
            IOUtils.copy(myStream, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }

//            File file = new File("/docker/web/LogFile/"+filepath+"/"+filename);
//            byte[] body = null;
//            InputStream is = new FileInputStream(file);
//            body = new byte[is.available()];
//            is.read(body);
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Content-Disposition", "attchement;filename=" + file.getName());
//            HttpStatus statusCode = HttpStatus.OK;
//            ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
//            return entity;

    }

    @GetMapping("/getLogFileList")
    public JSONObject getLogFileList(String id, String properties,int page,int limit ){

        HostIp hostIp = RepositoryUtil.getHostIp(id);

        JSONArray jsonArray = LogFileDetail.getBaseFileList(hostIp.getHostip(),properties);
        int length = jsonArray.size();

        JSONArray resJsonArray = new JSONArray();
        int start = limit*(page-1);
        int end = limit*page-1;
        for(;start<=end;start++){
            if (start<length){
                resJsonArray.add(jsonArray.getJSONObject(start));
            }
        }
        JSONObject jsonObject = new JSONObject();
        if(resJsonArray != null){
            jsonObject.put("status",200);
            jsonObject.put("count",length);
            jsonObject.put("data",resJsonArray);
        }else {
            jsonObject.put("status",500);
        }

        return jsonObject;

    }

    @PostMapping("/getPropertiesList")
    public JSONArray getPropertiesList(){

        JSONArray jsonArray = new JSONArray();

        jsonArray.add("CpuUseLogData");
        jsonArray.add("DiskBaseLogData");
        jsonArray.add("DiskIoLogData");
        jsonArray.add("LoadAverageLogData");
        jsonArray.add("MemeryLogData");
        jsonArray.add("PublicIpInflowLogData");
        jsonArray.add("PublicIpOutflowLogData");
        jsonArray.add("ReadIoLogData");
        jsonArray.add("ReadIopsLogData");
        jsonArray.add("WriteIoLogData");
        jsonArray.add("WriteIopsLogData");
        jsonArray.add("NetWorkCardLogData");
        jsonArray.add("OnlineUserLogData");
        jsonArray.add("MysqlConnectionNumberLogData");
        jsonArray.add("MysqlInnodbBufferLogData");
        jsonArray.add("MysqlKeyBufferLogData");
        jsonArray.add("MysqlProcessListLogData");
        jsonArray.add("MysqlQPSLogData");
        jsonArray.add("MysqlQueryCacheLogData");
        jsonArray.add("MysqlTableCacheLogData");
        jsonArray.add("MysqlThreadCacheLogData");
        jsonArray.add("MysqlTPSLogData");

        return jsonArray;
    }


}
