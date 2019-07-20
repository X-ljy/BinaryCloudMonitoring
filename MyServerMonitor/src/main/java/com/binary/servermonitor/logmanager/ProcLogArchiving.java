package com.binary.servermonitor.logmanager;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.common.SearchUrlList;
import com.binary.servermonitor.entity.esbean.LogFileBean;
import com.binary.servermonitor.util.DateTool;
import com.binary.servermonitor.util.EsUtils;
import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author 夕
 * @date 2019/5/23
 */
public class ProcLogArchiving implements Job {

    private static LogFileBean logFileBean = new LogFileBean();


    public static String JsonTOCsv(String json){
        JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    public static com.alibaba.fastjson.JSONArray AnalysisJson(String res){

        com.alibaba.fastjson.JSONArray resJsonArray = new com.alibaba.fastjson.JSONArray();

        JSONObject jsonObject = JSON.parseObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("aggregations");
        com.alibaba.fastjson.JSONObject jsonObject2 = jsonObject1.getJSONObject("pid");
        com.alibaba.fastjson.JSONArray jsonArray = jsonObject2.getJSONArray("buckets");
        Iterator<Object> iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            JSONObject jsonObject3 = (JSONObject) iterator.next();
            String value = jsonObject3.getString("key");
            resJsonArray.add(value);
        }
        return resJsonArray;
    }


    public static com.alibaba.fastjson.JSONArray AnalysisPidJson(String res){

        com.alibaba.fastjson.JSONArray resJsonArray = new com.alibaba.fastjson.JSONArray();

        JSONObject jsonObject = JSON.parseObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        com.alibaba.fastjson.JSONArray jsonArray = jsonObject1.getJSONArray("hits");
        Iterator<Object> iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            JSONObject jsonObject2 = (JSONObject) iterator.next();
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
            resJsonArray.add(jsonObject3);
        }

        return resJsonArray;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String res = null;
        com.alibaba.fastjson.JSONArray jsonArray = null;
        String Temp = null;
        String FileName = null;
        //获取host列表
        String[] hostID =  HostList.getHostList();

        for (String str : hostID){
            logFileBean.setId(str);
            logFileBean.setSize(5000);
            logFileBean.setStartTime(DateTool.getLogStartTime());
            logFileBean.setEndTime(DateTool.getLogEndTime());
            logFileBean.setQueryUrl(SearchUrlList.processDataUrl);


            try {

                res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toProcIdJsonString());
                com.alibaba.fastjson.JSONArray pidList = AnalysisJson(res);

                for (int i = 0;i<pidList.size();i++){
                    logFileBean.setId(str);
                    logFileBean.setSize(1000);
                    logFileBean.setStartTime(DateTool.getLogStartTime());
                    logFileBean.setEndTime(DateTool.getLogEndTime());
                    logFileBean.setQueryUrl(SearchUrlList.processDataUrl);
                    logFileBean.setPid(pidList.getString(i));


                    res = EsUtils.queryDataFromES(logFileBean.getQueryUrl(),logFileBean.toProcPidJsonString());
                    com.alibaba.fastjson.JSONArray jsonArray1 = AnalysisPidJson(res);

                    Temp = DateTool.getLogEndTime().replaceAll(":","-");
                    FileName = Temp.replaceAll(" ","_");
                    System.out.println(pidList.getString(i));
                    FileUtils.writeStringToFile(new File("/docker/web/LogFile/"+str+"/ProcLogData/"+pidList.getString(i)+"/"+FileName+".csv"), JsonTOCsv(jsonArray1.toString()));
                }


            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }
}
