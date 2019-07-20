package com.binary.servermonitor.service;

import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class HostIdService {
    public ArrayList<String> hostid(UserInfo userInfo){
        ArrayList<String> list = new ArrayList<>();
        int n = 0;
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        JSONObject jsonObject = new JSONObject(userInfo.getRegion());
        for (int i = 0;i < region.length;i ++){
            JSONArray array = jsonObject.getJSONArray(region[i]);
            for (int j = 0;j <array.length();j ++){
                list.add(array.getString(j));
            }
        }
        return list;
    }
}
