package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.firewall.FireWallCreatApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONObject;

/**
 * @author Wei Peng
 */
public class FirewallCreatService {

    public String firewallCreat(UserInfo userInfo, String name, String description,String region){
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("CreateFirewall");
        requestparameters.setRegion(region);
        FireWallCreatApi fireWallCreatApi = new FireWallCreatApi();
        String json = fireWallCreatApi.url(requestparameters,name,description);
        System.out.println(json);
        JSONObject jsonObject = new JSONObject(json);
        try {
            String taskId = jsonObject.getString("TaskId");
            String action = jsonObject.getString("Action");
            String firewallId = jsonObject.getString("FirewallId");
            return "创建成功，防火墙Id为"+ firewallId + "。";
        }catch (Exception e){
            return "创建失败";
        }
    }
}
