package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.entity.mysql.ConnNumber;
import com.binary.servermonitor.util.EsUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class GetMysqlConnNumService {
    private String getData(InfoBean infoBean){
        String res = null;
        try {
            res = EsUtils.queryDataFromES(infoBean.getQueryUrl(),infoBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList<ConnNumber> getMyqlConnNum(InfoBean infoBean){
        ArrayList<ConnNumber> list = new ArrayList<>();

        String res = getData(infoBean);
        JSONObject jsonObject = new JSONObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray array = jsonObject1.getJSONArray("hits");
        for (int i = 0;i <array.length();i ++) {
            ConnNumber connNumber = new ConnNumber();
            JSONObject jsonObject2 = array.getJSONObject(i);
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");

            try {
                connNumber.setHost(jsonObject3.getString("hostIp"));
            }catch (Exception e){
                connNumber.setHost(" ");
            }
            try {
                connNumber.setCount(jsonObject3.getString("count"));
            }catch (Exception e){
                connNumber.setCount(" ");
            }
            list.add(connNumber);
        }
        return list;
    }
}
