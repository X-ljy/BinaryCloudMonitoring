package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.entity.OneProcessInfo;
import com.binary.servermonitor.entity.ProcessInfo;
import com.binary.servermonitor.entity.esbean.ProcessBean;
import com.binary.servermonitor.util.EsUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class GetOneProcessInfoService {

    private String getData(ProcessBean processBean){
        String res = null;
        try {
            res = EsUtils.queryDataFromES(processBean.getQueryUrl(),processBean.toOneProcJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList<OneProcessInfo> getOneProcessInfo(ProcessBean processBean) {
        ArrayList<OneProcessInfo> list = new ArrayList<>();
        String res = getData(processBean);
        JSONObject jsonObject = new JSONObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray array = jsonObject1.getJSONArray("hits");
        OneProcessInfo oneProcessInfo = new OneProcessInfo();
        for (int i = 0; i < array.length(); i++) {
            JSONObject jsonObject2 = array.getJSONObject(i);
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
            oneProcessInfo = new OneProcessInfo();
            try {
                oneProcessInfo.setDate(jsonObject3.getString("date"));
            }catch (Exception e){
                oneProcessInfo.setDate("0");
            }
            try {
                oneProcessInfo.setCpu(Float.parseFloat(jsonObject3.getString("cpu")));
            }catch (Exception e){
                oneProcessInfo.setCpu(0);
            }
            try {
                oneProcessInfo.setMem(Float.parseFloat(jsonObject3.getString("mem")));
            }catch (Exception e){
                oneProcessInfo.setMem(0);
            }
            list.add(oneProcessInfo);
        }
        return list;
    }
}
