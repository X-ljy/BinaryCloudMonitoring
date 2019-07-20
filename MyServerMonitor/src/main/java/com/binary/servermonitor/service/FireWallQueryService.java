package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.firewall.FireWallQueryApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.FireWallList;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class FireWallQueryService {
    public ArrayList<FireWallList> fireWallQuery(UserInfo userInfo){
        ArrayList<FireWallList> list = new ArrayList<FireWallList>();
        Requestparameters requestparameters = new Requestparameters();
        FireWallQueryApi fireWallQueryApi = new FireWallQueryApi();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("DescribeFirewalls");
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        for (int i = 0;i<region.length;i++){
            String json = "";
            requestparameters.setRegion(region[i]);
            json = fireWallQueryApi.url(requestparameters);
            System.out.println(json);
            JSONObject jsonObject = new JSONObject(json);
            try {
                Integer totalCount = jsonObject.getInt("TotalCount");
                JSONArray array = jsonObject.getJSONArray("FirewallSet");
                for (int j = 0;j < totalCount;j ++){
                    JSONObject jsonObject1 = array.getJSONObject(j);
                    FireWallList fireWallList = new FireWallList();
                    fireWallList.setId(jsonObject1.getString("Id"));
                    try {
                        fireWallList.setName(jsonObject1.getString("Name"));
                    }catch (Exception e){
                        fireWallList.setName("null");
                    }
                    try {
                        fireWallList.setDdescription(jsonObject1.getString("Description"));
                    }catch (Exception e){
                        fireWallList.setDdescription("null");
                    }
                    fireWallList.setCreatTime(jsonObject1.getString("CreateTime"));
                    try {
                        String type = jsonObject1.getString("Type");
                        if ("CUSTOMER".equals(type)){
                            fireWallList.setType("用户创建");
                        }
                        else if ("DEFAULT".equals(type)){
                            fireWallList.setType("默认");
                        }
                        else {
                            fireWallList.setType(type);
                        }
                    }catch (Exception e){
                        fireWallList.setType("null");
                    }
                    try {
                        fireWallList.setUserId(jsonObject1.getString("UserId"));
                    }catch (Exception e){
                        fireWallList.setUserId("null");
                    }
                    list.add(fireWallList);
                }
            }catch (Exception e){
                System.out.println("查询防火墙失败");
            }
        }
        return list;
    }
}
