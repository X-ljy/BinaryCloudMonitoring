package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.util.EsUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class GetMysqlInnodbBufferService {
    private String getData(InfoBean infoBean){
        String res = null;
        try {
            res = EsUtils.queryDataFromES(infoBean.getQueryUrl(),infoBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList[] getMyqlInnodbBuffer(InfoBean infoBean){
        ArrayList[] lists = new ArrayList[2];
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Float> list1 = new ArrayList<>();
        String res = getData(infoBean);
        JSONObject jsonObject = new JSONObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray array = jsonObject1.getJSONArray("hits");
        for (int i = 0;i <array.length();i ++) {
            JSONObject jsonObject2 = array.getJSONObject(i);
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
            try {
                list.add(jsonObject3.getString("date"));
            }catch (Exception e){
                list.add(" ");
            }
            try {
                list1.add(Float.valueOf(jsonObject3.getString("innodb_buffer_read_hits"))*100);
            }catch (Exception e){
                list1.add((float) 0);
            }
        }
        lists[0] = list;
        lists[1] = list1;
        return lists;
    }
}
