package com.binary.servermonitor.controller.jvmcontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.jvm.OperatingSystemInfoSeverice;
import com.binary.servermonitor.util.DateTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

/**
 * @author 夕
 * @date 2019/6/1
 */
@RestController
public class OperatingSystemInfoController {
    @Autowired
    OperatingSystemInfoSeverice operatingSystemInfoSeverice;

    @PostMapping("/getHourJavaCpuUseRate")
    public String getHourJavaCpuUseRate(String id){
        String res = operatingSystemInfoSeverice.getOperatingSystemInfo(id+":1024",
                DateTool.getOneHourStartTime(),DateTool.getNowTime(),250);

        JSONArray resJsonArray = new JSONArray();

        JSONObject jsonObject = JSON.parseObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray jsonArray = jsonObject1.getJSONArray("hits");
        Iterator<Object> iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            JSONObject jsonObject2 = (JSONObject) iterator.next();
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");

            JSONObject resJsonObject = new JSONObject();
            String temp = String.format("%.2f",jsonObject3.getDouble("cpuUseRate")*100);
            resJsonObject.put("cpuUseRate",temp);
            resJsonObject.put("date",jsonObject3.getString("date"));

            resJsonArray.add(resJsonObject);
        }
        return resJsonArray.toString();
    }

    @PostMapping("/getDayJavaCpuUseRate")
    public String getDayJavaCpuUseRate(String id){
        String res = operatingSystemInfoSeverice.getOperatingSystemInfo(id+":1024",
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
            String temp = String.format("%.2f",jsonObject3.getDouble("cpuUseRate")*100);
            resJsonObject.put("cpuUseRate",temp);
            resJsonObject.put("date",jsonObject3.getString("date"));

            resJsonArray.add(resJsonObject);
        }
        return resJsonArray.toString();
    }

    @PostMapping("/getWeekJavaCpuUseRate")
    public String getWeekJavaCpuUseRate(String id){
        String res = operatingSystemInfoSeverice.getOperatingSystemInfo(id+":1024",
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
            String temp = String.format("%.2f",jsonObject3.getDouble("cpuUseRate")*100);
            resJsonObject.put("cpuUseRate",temp);
            resJsonObject.put("date",jsonObject3.getString("date"));

            resJsonArray.add(resJsonObject);
        }
        return resJsonArray.toString();
    }

    @GetMapping("/getOperatingSystemInfo")
    public String getOperatingSystemInfo(){
        String res = operatingSystemInfoSeverice.getOperatingSystemInfo("49.82.41.170:1024",
                DateTool.getOneHourStartTime(),DateTool.getNowTime(),250);

        JSONArray resJsonArray = new JSONArray();

        JSONObject jsonObject = JSON.parseObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray jsonArray = jsonObject1.getJSONArray("hits");
        Iterator<Object> iterator = jsonArray.iterator();
        while (iterator.hasNext()){
            JSONObject jsonObject2 = (JSONObject) iterator.next();
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
            resJsonArray.add(jsonObject3);
        }
        return resJsonArray.toString();
    }
}
