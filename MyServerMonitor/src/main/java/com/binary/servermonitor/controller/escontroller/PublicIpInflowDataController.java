package com.binary.servermonitor.controller.escontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.service.queryseverice.QueryPublicIpInflowDataSeverice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

/**
 * @author 夕
 * @date 2019/5/21
 */

@RestController
public class PublicIpInflowDataController {

    @Autowired
    QueryPublicIpInflowDataSeverice publicIpInflowDataSeverice;

    @PostMapping("/getOneHourPublicIpInflowData")
    public String getOneHourPublicIpInflowData(String id){

        JSONArray resJsonArray = new JSONArray();

        String res = publicIpInflowDataSeverice.getOneHourInflowData(id);

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

    @PostMapping("/getOneDayPublicIpInflowData")
    public String getOneDayPublicIpInflowData(String id){
        JSONArray resJsonArray = new JSONArray();

        String res = publicIpInflowDataSeverice.getOneDayInflowData(id);

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

    @PostMapping("/getOneWeekPublicIpInflowData")
    public String getOneWeekPublicIpInflowData(String id){
        JSONArray resJsonArray = new JSONArray();

        String res = publicIpInflowDataSeverice.getOneWeekInflowData(id);

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
