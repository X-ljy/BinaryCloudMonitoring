package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.entity.esbean.CpuUseInfoBean;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.util.EsUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class GetCpuUseInfoService {

    private String getData(InfoBean cpuUseInfoBean){
        String res = null;
        try {
            res = EsUtils.queryDataFromES(cpuUseInfoBean.getQueryUrl(),cpuUseInfoBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList[] getCpuUseService(InfoBean cpuUseInfoBean){
        String res = getData(cpuUseInfoBean);
        ArrayList[] lists = new ArrayList[9];
        lists[0] = new ArrayList<String>();
        for (int j = 1; j < 9;j ++){
            lists[j] = new ArrayList<Float>();
        }
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Float> list1 = new ArrayList<Float>();
        ArrayList<Float> list2 = new ArrayList<Float>();
        ArrayList<Float> list3 = new ArrayList<Float>();
        ArrayList<Float> list4 = new ArrayList<Float>();
        ArrayList<Float> list5 = new ArrayList<Float>();
        ArrayList<Float> list6 = new ArrayList<Float>();
        ArrayList<Float> list7 = new ArrayList<Float>();
        ArrayList<Float> list8 = new ArrayList<Float>();
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
                list1.add(Float.valueOf(jsonObject3.getString("us")));
            }catch (Exception e){
                list1.add((float) 0);
            }
            try {
                list2.add(Float.valueOf(jsonObject3.getString("sy")));
            }catch (Exception e){
                list2.add((float) 0);
            }
            try {
                list3.add(Float.valueOf(jsonObject3.getString("ni")));
            }catch (Exception e){
                list3.add((float) 0);
            }
            try {
                list4.add(Float.valueOf(jsonObject3.getString("id")));
            }catch (Exception e){
                list4.add((float) 0);
            }
            try {
                list5.add(Float.valueOf(jsonObject3.getString("wa")));
            }catch (Exception e){
                list5.add((float) 0);
            }
            try {
                list6.add(Float.valueOf(jsonObject3.getString("hi")));
            }catch (Exception e){
                list6.add((float) 0);
            }
            try {
                list7.add(Float.valueOf(jsonObject3.getString("st")));
            }catch (Exception e){
                list7.add((float) 0);
            }
            try {
                list8.add(Float.valueOf(jsonObject3.getString("si")));
            }catch (Exception e){
                list8.add((float) 0);
            }
        }
        lists[0] = list;
        lists[1] = list1;
        lists[2] = list2;
        lists[3] = list3;
        lists[4] = list4;
        lists[5] = list5;
        lists[6] = list6;
        lists[7] = list7;
        lists[8] = list8;
        return lists;
    }
}
