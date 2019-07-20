package com.binary.servermonitor.controller.escontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.service.queryseverice.QueryLoadAverageDataSeverice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.FieldResult;
import java.util.Iterator;

/**
 * @author 夕
 * @date 2019/5/21
 */
@RestController
public class RuntimeAverageDataConotroller {
    @Autowired
    QueryLoadAverageDataSeverice queryLoadAverageDataSeverice;

    //返回一个小时的数据
    @PostMapping("/getOneHourAverageData")
    public String getOneHourAverageData(String id){
        JSONArray resJsonArray = new JSONArray();

        String res = queryLoadAverageDataSeverice.getOneHourAverageData(id);

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

    //返回一天的数据
    @PostMapping("/getOneDayAverageData")
    public String getOneDayAverageData(String id){
        JSONArray resJsonArray = new JSONArray();

        String res = queryLoadAverageDataSeverice.getOneDayAverageData(id);

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

    @PostMapping("/getOneWeekAverageData")
    public String getOneWeekAverageData(String id){
        JSONArray resJsonArray = new JSONArray();

        String res = queryLoadAverageDataSeverice.getOneWeekAverageData(id);

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
