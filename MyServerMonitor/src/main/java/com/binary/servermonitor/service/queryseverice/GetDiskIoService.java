package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.entity.esbean.*;
import com.binary.servermonitor.util.EsUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class GetDiskIoService {

    private String getReadIoData(ReadIoDataBean infoBean){
        String res = null;
        try {
            res = EsUtils.queryDataFromES(infoBean.getQueryUrl(),infoBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    private String getWtiteIoData(WriteIoDataBean infoBean){
        String res = null;
        try {
            res = EsUtils.queryDataFromES(infoBean.getQueryUrl(),infoBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    private String getReadIopsData(ReadIopsDataBean infoBean){
        String res = null;
        try {
            res = EsUtils.queryDataFromES(infoBean.getQueryUrl(),infoBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    private String getWtiteIopsData(WriteIopsDataBean infoBean){
        String res = null;
        try {
            res = EsUtils.queryDataFromES(infoBean.getQueryUrl(),infoBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList[] getReadIoUsed(ReadIoDataBean infoBean){
        String res = getReadIoData(infoBean);
        ArrayList[] lists = new ArrayList[2];
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Float> list1 = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray array = jsonObject1.getJSONArray("hits");
        for (int i = array.length()-1;i >=0;i--){
            JSONObject jsonObject2 = array.getJSONObject(i);
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
            JSONObject jsonObject4 = jsonObject3.getJSONObject("data");
            JSONObject jsonObject5 = jsonObject4.getJSONObject("tag1");
            try {
                list.add(jsonObject5.getString("date1"));
            }catch (Exception e){
                list.add("");
            }
            try {
                list1.add(Float.parseFloat(jsonObject5.getString("data1")));
            }catch (Exception e){
                list1.add((float) 0);
            }
        }
        lists[0] = list;
        lists[1] = list1;
        return lists;
    }

    public ArrayList[] getWriteIoUsed(WriteIoDataBean infoBean){
        String res = getWtiteIoData(infoBean);
        ArrayList[] lists = new ArrayList[2];
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Float> list1 = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray array = jsonObject1.getJSONArray("hits");
        for (int i = array.length()-1;i >=0;i--){
            JSONObject jsonObject2 = array.getJSONObject(i);
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
            JSONObject jsonObject4 = jsonObject3.getJSONObject("data");
            JSONObject jsonObject5 = jsonObject4.getJSONObject("tag1");
            try {
                list.add(jsonObject5.getString("date1"));
            }catch (Exception e){
                list.add("");
            }
            try {
                list1.add(Float.parseFloat(jsonObject5.getString("data1")));
            }catch (Exception e){
                list1.add((float) 0);
            }
        }
        lists[0] = list;
        lists[1] = list1;
        return lists;
    }

    public ArrayList[] getReadIopsUsed(ReadIopsDataBean infoBean){
        String res = getReadIopsData(infoBean);
        ArrayList[] lists = new ArrayList[2];
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Float> list1 = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray array = jsonObject1.getJSONArray("hits");
        for (int i = array.length()-1;i >=0;i--){
            JSONObject jsonObject2 = array.getJSONObject(i);
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
            JSONObject jsonObject4 = jsonObject3.getJSONObject("data");
            JSONObject jsonObject5 = jsonObject4.getJSONObject("tag1");
            try {
                list.add(jsonObject5.getString("date1"));
            }catch (Exception e){
                list.add("");
            }
            try {
                list1.add(Float.parseFloat(jsonObject5.getString("data1")));
            }catch (Exception e){
                list1.add((float) 0);
            }
        }
        lists[0] = list;
        lists[1] = list1;
        return lists;
    }

    public ArrayList[] getWriteIopsUsed(WriteIopsDataBean infoBean){
        String res = getWtiteIopsData(infoBean);
        ArrayList[] lists = new ArrayList[2];
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Float> list1 = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray array = jsonObject1.getJSONArray("hits");
        for (int i = array.length()-1;i >=0;i--){
            JSONObject jsonObject2 = array.getJSONObject(i);
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
            JSONObject jsonObject4 = jsonObject3.getJSONObject("data");
            JSONObject jsonObject5 = jsonObject4.getJSONObject("tag1");
            try {
                list.add(jsonObject5.getString("date1"));
            }catch (Exception e){
                list.add("");
            }
            try {
                list1.add(Float.parseFloat(jsonObject5.getString("data1")));
            }catch (Exception e){
                list1.add((float) 0);
            }
        }
        lists[0] = list;
        lists[1] = list1;
        return lists;
    }
}
