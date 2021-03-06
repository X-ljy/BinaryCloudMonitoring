package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.util.EsUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class GetSwapUseInfoService {
    private String getData(InfoBean infoBean){
        String res = null;
        try {
            res = EsUtils.queryDataFromES(infoBean.getQueryUrl(),infoBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList[] getSwapUseService(InfoBean infoBean){
        ArrayList[] lists = new ArrayList[5];
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Float> list1 = new ArrayList<>();
        ArrayList<Float> list2 = new ArrayList<>();
        ArrayList<Float> list3 = new ArrayList<>();
        ArrayList<Float> list4 = new ArrayList<>();
        String res = getData(infoBean);
        JSONObject jsonObject = new JSONObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray array = jsonObject1.getJSONArray("hits");
        for (int i = 0; i <array.length();i ++){
            JSONObject jsonObject2 = array.getJSONObject(i);
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
            DecimalFormat df = new DecimalFormat(".00");
            try {
                list.add(jsonObject3.getString("date"));
            }catch (Exception e){
                list.add(String.valueOf(0));
            }
            try {
                float data = Float.valueOf(jsonObject3.getString("swapTotal"))/1000;
                list1.add(Float.valueOf(df.format(data)));
            }catch (Exception e){
                list1.add((float) 0);
            }
            try {
                float data = Float.valueOf(jsonObject3.getString("swapUsed"))/1000;
                list2.add(Float.valueOf(df.format(data)));
            }catch (Exception e){
                list2.add((float) 0);
            }
            try {
                float data = Float.valueOf(jsonObject3.getString("swapFree"))/1000;
                list3.add(Float.valueOf(df.format(data)));
            }catch (Exception e){
                list3.add((float) 0);
            }
            try {
                float data = Float.valueOf(jsonObject3.getString("swapCache"))/1000;
                list4.add(Float.valueOf(df.format(data)));
            }catch (Exception e){
                list4.add((float) 0);
            }
        }
        lists[0] = list;
        lists[1] = list1;
        lists[2] = list2;
        lists[3] = list3;
        lists[4] = list4;
        return lists;
    }
}
