package com.binary.servermonitor.controller.jvmcontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.jvm.MemoryInfoSeverice;
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
public class MemoryInfoController {

    static final long MB = 1024 * 1024;
    @Autowired
    MemoryInfoSeverice memoryInfoSeverice;

    @PostMapping("/getHourMemoryInfo")
    public String getHourMemoryInfo(String id){
        String res = memoryInfoSeverice.getMemoryInfo(id+":1024",
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
            resJsonObject.put("heapMax",jsonObject3.getLong("heapMax"));
            resJsonObject.put("heapUsed",jsonObject3.getLong("heapUsed"));
            resJsonObject.put("heapCommitted",jsonObject3.getLong("heapCommitted"));
            resJsonObject.put("heapUseRate",jsonObject3.getIntValue("heapUseRate"));
            resJsonObject.put("noHeapUsed",jsonObject3.getLong("heapMax"));
            resJsonObject.put("noHeapInit",jsonObject3.getLong("noHeapInit"));
            resJsonObject.put("noHeapCommitted",jsonObject3.getLong("noHeapCommitted"));
            resJsonObject.put("noHeapUseRate",jsonObject3.getIntValue("noHeapUseRate"));
            resJsonObject.put("date",jsonObject3.getString("date"));

            resJsonArray.add(resJsonObject);
        }

        return resJsonArray.toString();
    }



    @PostMapping("/getDayMemoryInfo")
    public String getDayMemoryInfo(String id){
//        id = "49.82.41.203";
        String res = memoryInfoSeverice.getMemoryInfo(id+":1024",
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
            resJsonObject.put("heapMax",jsonObject3.getLong("heapMax"));
            resJsonObject.put("heapUsed",jsonObject3.getLong("heapUsed"));
            resJsonObject.put("heapCommitted",jsonObject3.getLong("heapCommitted"));
            resJsonObject.put("heapUseRate",jsonObject3.getIntValue("heapUseRate"));
            resJsonObject.put("noHeapUsed",jsonObject3.getLong("heapMax"));
            resJsonObject.put("noHeapInit",jsonObject3.getLong("noHeapInit"));
            resJsonObject.put("noHeapCommitted",jsonObject3.getLong("noHeapCommitted"));
            resJsonObject.put("noHeapUseRate",jsonObject3.getIntValue("noHeapUseRate"));
            resJsonObject.put("date",jsonObject3.getString("date"));

            resJsonArray.add(resJsonObject);
        }

        return resJsonArray.toString();
    }

    @PostMapping("/getWeekMemoryInfo")
    public String getWeekMemoryInfo(String id){
//        id = "49.82.41.203";
        String res = memoryInfoSeverice.getMemoryInfo(id+":1024",
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
            resJsonObject.put("heapMax",jsonObject3.getLong("heapMax"));
            resJsonObject.put("heapUsed",jsonObject3.getLong("heapUsed"));
            resJsonObject.put("heapCommitted",jsonObject3.getLong("heapCommitted"));
            resJsonObject.put("heapUseRate",jsonObject3.getIntValue("heapUseRate"));
            resJsonObject.put("noHeapUsed",jsonObject3.getLong("heapMax"));
            resJsonObject.put("noHeapInit",jsonObject3.getLong("noHeapInit"));
            resJsonObject.put("noHeapCommitted",jsonObject3.getLong("noHeapCommitted"));
            resJsonObject.put("noHeapUseRate",jsonObject3.getIntValue("noHeapUseRate"));
            resJsonObject.put("date",jsonObject3.getString("date"));

            resJsonArray.add(resJsonObject);
        }

        return resJsonArray.toString();
    }


    @GetMapping("/getMemoryInfo")
    public String getMemoryInfo(){
        String res = memoryInfoSeverice.getMemoryInfo("49.82.41.170:1024",
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
