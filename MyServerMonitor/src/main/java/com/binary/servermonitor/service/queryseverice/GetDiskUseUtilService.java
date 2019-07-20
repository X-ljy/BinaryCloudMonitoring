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
public class GetDiskUseUtilService {

    private String getData(InfoBean infoBean){
        String res = null;
        try {
            res = EsUtils.queryDataFromES(infoBean.getQueryUrl(),infoBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList[] getDiskUsed(InfoBean infoBean){
        ArrayList[] lists = new ArrayList[3];
        String res = getData(infoBean);
        JSONObject jsonObject = new JSONObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray array = jsonObject1.getJSONArray("hits");
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Float> list1 = new ArrayList<>();
        ArrayList<Float> list2 = new ArrayList<>();
        for (int i = array.length()-1;i >=0;i--){
            JSONObject jsonObject2 = array.getJSONObject(i);
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
            if ("/dev/vda1".equals(jsonObject3.getString("fileSystem"))){
                String used = jsonObject3.getString("used");
                list.add(jsonObject3.getString("date"));
                if ("G".equals(used.substring(used.length()-1,used.length()))){
                    try {
                        String use = jsonObject3.getString("used");
                        String size = jsonObject3.getString("size");
                        list1.add(Float.parseFloat(use.substring(0,use.length()-1))/Float.parseFloat(size.substring(0,size.length()-1)));
                    }catch (Exception e){
                        list1.add((float) 0);
                    }
                }
                else if ("m".equals(used.substring(used.length()-1,used.length()))){
                    try {
                        String use = jsonObject3.getString("used");
                        String size = jsonObject3.getString("size");
                        list1.add(Float.parseFloat(use.substring(0,use.length()-1))/1000/Float.parseFloat(size.substring(0,size.length()-1))) ;
                    }catch (Exception e){
                        list1.add((float) 0);
                    }
                }
            }
            else if ("/dev/vdb1".equals(jsonObject3.getString("fileSystem"))){
                list.add(jsonObject3.getString("date"));
                String used = jsonObject3.getString("used");
                if ("G".equals(used.substring(used.length()-1,used.length()))){
                    try {
                        String use = jsonObject3.getString("used");
                        String size = jsonObject3.getString("size");
                        list2.add(Float.parseFloat(use.substring(0,use.length()-1))/Float.parseFloat(size.substring(0,size.length()-1)));
                    }catch (Exception e){
                        list2.add((float) 0);
                    }
                }
                else if ("m".equals(used.substring(used.length()-1,used.length()))){
                    try {
                        String use = jsonObject3.getString("used");
                        String size = jsonObject3.getString("size");
                        list2.add(Float.parseFloat(use.substring(0,use.length()-1))/1000/Float.parseFloat(size.substring(0,size.length()-1)));
                    }catch (Exception e){
                        list2.add((float) 0);
                    }
                }
            }
        }
        lists[0] = list;
        lists[1] = list1;
        lists[2] = list2;
        return lists;
    }
}
