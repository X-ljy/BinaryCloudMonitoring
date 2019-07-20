package com.binary.servermonitor.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.File;

/**
 * @author 夕
 * @date 2019/5/24
 */
public class LogFileDetail {

    public static JSONArray getBaseFileList(String id, String properties){

        String[] filelist = null;

        JSONArray jsonArray = new JSONArray();

        File file = new File("/docker/web/LogFile/"+id+"/"+properties);
        if(file.isDirectory()) {
            filelist = file.list();
        }
        for(String str:filelist){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id",id);
            String time = str.replaceAll(".csv","");
            jsonObject.put("filestarttime",time.replaceAll("23-59-59","00-00-00"));
            jsonObject.put("fileendtime",time);
            jsonObject.put("filename",str);
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }





}
