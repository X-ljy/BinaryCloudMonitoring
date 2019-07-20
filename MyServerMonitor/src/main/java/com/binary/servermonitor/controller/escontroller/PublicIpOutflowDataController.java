package com.binary.servermonitor.controller.escontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.service.queryseverice.QueryPublicIpInflowDataSeverice;
import com.binary.servermonitor.service.queryseverice.QueryPublicOutflowDataSeverice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

/**
 * @author 夕
 * @date 2019/5/21
 */
@RestController
public class PublicIpOutflowDataController {
    @Autowired
    QueryPublicOutflowDataSeverice publicOutflowDataSeverice;

    @PostMapping("/getOneHourPublicIpOutflowData")
    public String getOneHourPublicIpInflowData(String id){
        JSONArray resJsonArray = new JSONArray();

        String res = publicOutflowDataSeverice.getOneHourInflowData(id);

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

    @PostMapping("/getOneDayPublicIpOutflowData")
    public String getOneDayPublicIpInflowData(String id){
        JSONArray resJsonArray = new JSONArray();

        String res = publicOutflowDataSeverice.getOneDayInflowData(id);

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

    @PostMapping("/getOneWeekPublicIpOutflowData")
    public String getOneWeekPublicIpInflowData(String id){
        JSONArray resJsonArray = new JSONArray();

        String res = publicOutflowDataSeverice.getOneWeekInflowData(id);

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
