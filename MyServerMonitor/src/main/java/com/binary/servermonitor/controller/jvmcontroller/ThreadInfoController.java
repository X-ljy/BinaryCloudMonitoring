package com.binary.servermonitor.controller.jvmcontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.jvm.ThreadInfoSeverice;
import com.binary.servermonitor.util.DateTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

/**
 * @author 夕
 * @date 2019/6/1
 */
@RestController
public class ThreadInfoController {
    @Autowired
    ThreadInfoSeverice threadInfoSeverice;
    @PostMapping("/getHourThreadInfo")
    public String getHourThreadInfo(String id){
        String res = threadInfoSeverice.getThreadInfo(id + ":1024",
                DateTool.getOneHourStartTime(),DateTool.getNowTime(),1000);
        JSONArray resJsonArray = new JSONArray();
        JSONObject jsonObject = JSON.parseObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray jsonArray = jsonObject1.getJSONArray("hits");
        Iterator<Object> iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            JSONObject jsonObject2 = (JSONObject) iterator.next();
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");

            JSONObject resJsonObject = new JSONObject();
            resJsonObject.put("date",jsonObject3.getString("date"));
            resJsonObject.put("aliveThreadCount",jsonObject3.getString("aliveThreadCount"));
            resJsonObject.put("peakThreadCount",jsonObject3.getString("peakThreadCount"));
            resJsonObject.put("totalStartedThreadCount",jsonObject3.getString("totalStartedThreadCount"));
            resJsonObject.put("daemonThreadCount",jsonObject3.getString("daemonThreadCount"));

            resJsonArray.add(resJsonObject);

        }
        return resJsonArray.toString();
    }

    @PostMapping("/getDayThreadInfo")
    public String getThreadInfo(String id){
//        id = "49.82.41.203";
        String res = threadInfoSeverice.getThreadInfo(id + ":1024",
                DateTool.getOneDayStartTime(),DateTool.getNowTime(),5000);
        JSONArray resJsonArray = new JSONArray();
        JSONObject jsonObject = JSON.parseObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray jsonArray = jsonObject1.getJSONArray("hits");
        Iterator<Object> iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            JSONObject jsonObject2 = (JSONObject) iterator.next();
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");

            JSONObject resJsonObject = new JSONObject();
            resJsonObject.put("date",jsonObject3.getString("date"));
            resJsonObject.put("aliveThreadCount",jsonObject3.getString("aliveThreadCount"));
            resJsonObject.put("peakThreadCount",jsonObject3.getString("peakThreadCount"));
            resJsonObject.put("totalStartedThreadCount",jsonObject3.getString("totalStartedThreadCount"));
            resJsonObject.put("daemonThreadCount",jsonObject3.getString("daemonThreadCount"));

            resJsonArray.add(resJsonObject);

        }
        return resJsonArray.toString();
    }

    @PostMapping("/getWeekThreadInfo")
    public String getWeekThreadInfo(String id){
//        id = "49.82.41.203";
        String res = threadInfoSeverice.getThreadInfo(id + ":1024",
                DateTool.getOneWeekStartTime(),DateTool.getNowTime(),5000);
        JSONArray resJsonArray = new JSONArray();
        JSONObject jsonObject = JSON.parseObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray jsonArray = jsonObject1.getJSONArray("hits");
        Iterator<Object> iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            JSONObject jsonObject2 = (JSONObject) iterator.next();
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");

            JSONObject resJsonObject = new JSONObject();
            resJsonObject.put("date",jsonObject3.getString("date"));
            resJsonObject.put("aliveThreadCount",jsonObject3.getString("aliveThreadCount"));
            resJsonObject.put("peakThreadCount",jsonObject3.getString("peakThreadCount"));
            resJsonObject.put("totalStartedThreadCount",jsonObject3.getString("totalStartedThreadCount"));
            resJsonObject.put("daemonThreadCount",jsonObject3.getString("daemonThreadCount"));

            resJsonArray.add(resJsonObject);

        }
        return resJsonArray.toString();
    }


    @PostMapping("/getAllThreadInfo")
    public String getAllThreadInfo(@RequestParam Integer curr){
        String res = threadInfoSeverice.getThreadInfo("49.82.41.170:1024",
                DateTool.getMinuteStartTime(),DateTool.getMinuteEndTime(),1000);
        JSONArray resJsonArray = new JSONArray();
        JSONObject jsonObject = JSON.parseObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray jsonArray = jsonObject1.getJSONArray("hits");
        Iterator<Object> iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            JSONObject jsonObject2 = (JSONObject) iterator.next();
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");

            JSONObject resJsonObject = new JSONObject();
            resJsonArray = jsonObject3.getJSONArray("allThreadInfo");

        }
        Integer pageStart = (curr - 1) *10;
        JSONArray pagelist = new JSONArray();
        for (Integer i = pageStart;i<pageStart+10;i++){
            if (i>=resJsonArray.size()){
                break;
            }
            else {
                pagelist.add(resJsonArray.get(i));
            }
        }
        return pagelist.toString();
    }

    @PostMapping("/getAllThreadInfoCount")
    public int getAllThreadInfoCount(){
        String res = threadInfoSeverice.getThreadInfo("49.82.41.170:1024",
                DateTool.getMinuteStartTime(),DateTool.getMinuteEndTime(),1000);
        JSONArray resJsonArray = new JSONArray();
        JSONObject jsonObject = JSON.parseObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray jsonArray = jsonObject1.getJSONArray("hits");
        Iterator<Object> iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            JSONObject jsonObject2 = (JSONObject) iterator.next();
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");

            JSONObject resJsonObject = new JSONObject();
            resJsonArray = jsonObject3.getJSONArray("allThreadInfo");

        }
        return resJsonArray.size();
    }

}
