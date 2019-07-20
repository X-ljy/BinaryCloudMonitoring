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
public class GetAverageLoadService {
    private String getData(InfoBean cpuUseInfoBean){
        String res = null;
        try {
            res = EsUtils.queryDataFromES(cpuUseInfoBean.getQueryUrl(),cpuUseInfoBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList[] getAverageLoad(InfoBean infoBean){
        ArrayList[] lists = new ArrayList[4];
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Float> list1 = new ArrayList<>();
        ArrayList<Float> list2 = new ArrayList<>();
        ArrayList<Float> list3 = new ArrayList<>();
        String res = getData(infoBean);
        JSONObject jsonObject = new JSONObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray array = jsonObject1.getJSONArray("hits");
        for (int i = 0;i <array.length();i ++){
            JSONObject jsonObject2 = array.getJSONObject(i);
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
            try {
                list.add(jsonObject3.getString("date"));
            }catch (Exception e){
                list.add(String.valueOf(0));
            }
            try {
                list1.add(Float.valueOf(jsonObject3.getString("oneLoadAverage")));
            } catch (Exception e) {
                list1.add((float) 0);
            }
            try {
                list2.add(Float.valueOf(jsonObject3.getString("fiveLoadAverage")));
            } catch (Exception e) {
                list2.add((float) 0);
            }
            try {
                list3.add(Float.valueOf(jsonObject3.getString("fifteenLoadAverage")));
            } catch (Exception e) {
                list3.add((float) 0);
            }
        }
        lists[0] = list;
        lists[1] = list1;
        lists[2] = list2;
        lists[3] = list3;
        return lists;
    }

}
