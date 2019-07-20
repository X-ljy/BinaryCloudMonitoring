package com.binary.servermonitor.controller.escontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.service.queryseverice.QueryProcessDataSeverice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

/**
 * @author 夕
 * @date 2019/5/19
 */

@RestController
public class ProcessDataController {

    @Autowired
    QueryProcessDataSeverice queryProcessDataSeverice;

    //得到进程列表
    @PostMapping("/getProcessData")
    public String getProcessData(String id){
        JSONArray resJsonArray = new JSONArray();

        String res = queryProcessDataSeverice.getProcessData(id);

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

    //得到某个进程一个小时的数据
    @PostMapping("/getOneProcessData")
    public String getOneProcessData(String id,String pid){
        JSONArray resJsonArray = new JSONArray();

        String res = queryProcessDataSeverice.getOneProcessData(id,pid);

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
