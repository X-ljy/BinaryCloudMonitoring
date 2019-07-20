package com.binary.servermonitor.service.queryseverice;

import com.binary.servermonitor.entity.ProcessInfo;
import com.binary.servermonitor.entity.esbean.InfoBean;
import com.binary.servermonitor.entity.esbean.ProcessBean;
import com.binary.servermonitor.util.EsUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class GetProcessInfoService {

    private String getData(ProcessBean processBean){
        String res = null;
        try {
            res = EsUtils.queryDataFromES(processBean.getQueryUrl(),processBean.toJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList<ProcessInfo> getProcessInfo(ProcessBean processBean){
        ArrayList<ProcessInfo> list = new ArrayList<>();
        String res = getData(processBean);
        JSONObject jsonObject = new JSONObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray array = jsonObject1.getJSONArray("hits");
        for (int i = 0; i < array.length(); i ++){
            JSONObject jsonObject2 = array.getJSONObject(i);
            JSONObject jsonObject3 = jsonObject2.getJSONObject("_source");
            ProcessInfo processInfo = new ProcessInfo();
            try {
                processInfo.setUser(jsonObject3.getString("user"));
            }catch (Exception e){
                processInfo.setUser("null");
            }
            try {
                processInfo.setTty(jsonObject3.getString("tty"));
            }catch (Exception e){
                processInfo.setTty("null");
            }
            try {
                processInfo.setPid(jsonObject3.getString("pid"));
            }catch (Exception e){
                processInfo.setPid("null");
            }
            try {
                processInfo.setCpu(jsonObject3.getString("cpu"));
            }catch (Exception e){
                processInfo.setCpu("null");
            }
            try {
                processInfo.setMem(jsonObject3.getString("mem"));
            }catch (Exception e){
                processInfo.setMem("null");
            }
            try {
                processInfo.setVsz(jsonObject3.getString("vsz"));
            }catch (Exception e){
                processInfo.setVsz("null");
            }
            try {
                processInfo.setRss(jsonObject3.getString("rss"));
            }catch (Exception e){
                processInfo.setRss("null");
            }
            try {
                processInfo.setStart(jsonObject3.getString("start"));
            }catch (Exception e){
                processInfo.setStart("null");
            }
            try {
                String command = jsonObject3.getString("command");
                if (command.length() > 100){
                    command = command.substring(0,100);
                }
                processInfo.setCommand(command);
            }catch (Exception e){
                processInfo.setCommand("null");
            }
            try {
                processInfo.setStat(jsonObject3.getString("stat"));
            }catch (Exception e){
                processInfo.setStat("null");
            }
            list.add(processInfo);
        }
        return list;
    }

    public Integer getProcessCount(ProcessBean processBean){
        String res = getData(processBean);
        JSONObject jsonObject = new JSONObject(res);
        JSONObject jsonObject1 = jsonObject.getJSONObject("hits");
        JSONArray array = jsonObject1.getJSONArray("hits");
        return array.length();
    }
}
