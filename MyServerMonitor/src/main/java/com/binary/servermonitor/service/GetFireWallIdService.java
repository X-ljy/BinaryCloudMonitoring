package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.firewall.FireWallQueryApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class GetFireWallIdService {
    public ArrayList<String> getFirewallId(UserInfo userInfo){
        ArrayList<String> list = new ArrayList<String>();
        Requestparameters requestparameters = new Requestparameters();
        FireWallQueryApi fireWallQueryApi = new FireWallQueryApi();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("DescribeFirewalls");
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
            String json = "";
            requestparameters.setRegion(region[0]);
            json = fireWallQueryApi.url(requestparameters);
            JSONObject jsonObject = new JSONObject(json);
            try {
                Integer totalCount = jsonObject.getInt("TotalCount");
                JSONArray array = jsonObject.getJSONArray("FirewallSet");
                for (int j = 0;j < totalCount;j ++){
                    JSONObject jsonObject1 = array.getJSONObject(j);
                    list.add(jsonObject1.getString("Id"));
                }
                return list;
            }catch (Exception e){
                System.out.println("查询防火墙失败");
            }
            return list;
    }
}
