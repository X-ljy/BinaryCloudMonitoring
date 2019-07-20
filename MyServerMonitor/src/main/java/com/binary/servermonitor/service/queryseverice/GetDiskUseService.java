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
public class GetDiskUseService {

    private String getData(InfoBean infoBean){
        String res = null;
        try {
            res = EsUtils.queryDataFromES(infoBean.getQueryUrl(),infoBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList<Float> getDiskUsed(InfoBean infoBean){
        DecimalFormat df = new DecimalFormat(".00");
        ArrayList<Float> list = new ArrayList<>();
        String res = getData(infoBean);
        JSONObject jsonObject = new JSONObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray array = jsonObject1.getJSONArray("hits");
        float vda1 = 0;
        float vdb1 = 0;
        for (int i = array.length()-1;i >=0;i--){
            JSONObject jsonObject2 = array.getJSONObject(i);
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
            if ("/dev/vda1".equals(jsonObject3.getString("fileSystem"))){
                String used = jsonObject3.getString("used");
                if ("G".equals(used.substring(used.length()-1,used.length()))){
                    try {
                        String use = jsonObject3.getString("used");
                        String size = jsonObject3.getString("size");
                        vda1 = Float.valueOf(df.format(Float.parseFloat(use.substring(0,use.length()-1))/Float.parseFloat(size.substring(0,size.length()-1))*100));
                    }catch (Exception e){
                        vda1 = 0;
                    }
                }
                else if ("m".equals(used.substring(used.length()-1,used.length()))){
                    try {
                        String use = jsonObject3.getString("used");
                        String size = jsonObject3.getString("size");
                        vda1 = Float.valueOf(df.format(Float.parseFloat(use.substring(0,use.length()-1))/Float.parseFloat(size.substring(0,size.length()-1))*100));
                    }catch (Exception e){
                        vda1 = 0;
                    }
                }
            }
            else if ("/dev/vdb1".equals(jsonObject3.getString("fileSystem"))){
                String used = jsonObject3.getString("used");
                if ("G".equals(used.substring(used.length()-1,used.length()))){
                    try {
                        String use = jsonObject3.getString("used");
                        String size = jsonObject3.getString("size");
                        vdb1 = Float.valueOf(df.format(Float.parseFloat(use.substring(0,use.length()-1))/Float.parseFloat(size.substring(0,size.length()-1))*100));
                    }catch (Exception e){
                        vdb1 = 0;
                    }
                }
                else if ("m".equals(used.substring(used.length()-1,used.length()))){
                    try {
                        String use = jsonObject3.getString("used");
                        String size = jsonObject3.getString("size");
                        vdb1 = Float.valueOf(df.format(Float.parseFloat(use.substring(0,use.length()-1))/Float.parseFloat(size.substring(0,size.length()-1))*100));
                    }catch (Exception e){
                        vdb1 = 0;
                    }
                }
            }
        }
        list.add(vda1);
        list.add(vdb1*100);
        return list;
    }
}
