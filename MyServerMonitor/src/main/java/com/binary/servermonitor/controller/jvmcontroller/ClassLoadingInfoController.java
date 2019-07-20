package com.binary.servermonitor.controller.jvmcontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.jvm.ClassLoadingInfoSeverice;
import com.binary.servermonitor.util.DateTool;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
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
public class ClassLoadingInfoController {
    @Autowired
    ClassLoadingInfoSeverice classLoadingInfoSeverice;

    @PostMapping("/getHourClassLoadingInfo")
    public String getClassLoadingInfo(String id){
        String res = classLoadingInfoSeverice.getClassLoadingInfo(id+":1024",
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

    @PostMapping("/getDayClassLoadingInfo")
    public String getDayClassLoadingInfo(String id){
        String res = classLoadingInfoSeverice.getClassLoadingInfo(id+":1024",
                DateTool.getOneDayStartTime(),DateTool.getNowTime(),250);

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

    @PostMapping("/getWeekClassLoadingInfo")
    public String getWeekClassLoadingInfo(String id){
        String res = classLoadingInfoSeverice.getClassLoadingInfo(id+":1024",
                DateTool.getOneWeekStartTime(),DateTool.getNowTime(),250);

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
