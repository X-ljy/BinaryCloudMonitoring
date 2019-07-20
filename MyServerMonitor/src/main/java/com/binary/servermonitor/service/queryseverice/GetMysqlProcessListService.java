package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.entity.mysql.ProcessInfo;
import com.binary.servermonitor.util.EsUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class GetMysqlProcessListService {
    private String getData(InfoBean infoBean){
        String res = null;
        try {
            res = EsUtils.queryDataFromES(infoBean.getQueryUrl(),infoBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList<ProcessInfo> getProcessList(InfoBean infoBean){
        ArrayList<ProcessInfo> list = new ArrayList<>();
        String res = getData(infoBean);
        JSONObject jsonObject = new JSONObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray array = jsonObject1.getJSONArray("hits");
        for (int i = 0;i <array.length();i ++) {
            ProcessInfo processInfo = new ProcessInfo();
            JSONObject jsonObject2 = array.getJSONObject(i);
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
            try {
                processInfo.setDate(jsonObject3.getString("date"));
            }catch (Exception e){
                processInfo.setDate(" ");
            }
            try {
                processInfo.setInfo(jsonObject3.getString("info"));
            }catch (Exception e){
                processInfo.setInfo(" ");
            }
            try {
                processInfo.setHost(jsonObject3.getString("host"));
            }catch (Exception e){
                processInfo.setHost(" ");
            }
            try {
                processInfo.setState(jsonObject3.getString("state"));
            }catch (Exception e){
                processInfo.setState(" ");
            }
            try {
                processInfo.setId(jsonObject3.getString("id"));
            }catch (Exception e){
                processInfo.setId(" ");
            }
            try {
                processInfo.setCommand(jsonObject3.getString("command"));
            }catch (Exception e){
                processInfo.setCommand(" ");
            }
            try {
                processInfo.setUser(jsonObject3.getString("user"));
            }catch (Exception e){
                processInfo.setUser(" ");
            }
            try {
                processInfo.setTime(jsonObject3.getString("time"));
            }catch (Exception e){
                processInfo.setTime(" ");
            }
            try {
                processInfo.setDb(jsonObject3.getString("db"));
            }catch (Exception e){
                processInfo.setDb(" ");
            }
            list.add(processInfo);
        }
        return list;
    }
}
