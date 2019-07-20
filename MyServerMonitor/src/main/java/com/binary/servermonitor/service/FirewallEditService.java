package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.firewall.FireWallEditApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONObject;

/**
 * @author Wei Peng
 */
public class FirewallEditService {
    public String firewallEdit(UserInfo userInfo,String id,String name,String description){
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("ModifyFirewallAttributes");
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        requestparameters.setRegion(region[0]);
        FireWallEditApi fireWallEditApi = new FireWallEditApi();
        String json = fireWallEditApi.url(requestparameters,id,name,description);
        JSONObject jsonObject = new JSONObject(json);
        try {
            String taskId = jsonObject.getString("TaskId");
            String action = jsonObject.getString("Action");
            return "修改成功";
        }catch (Exception e){
            return "修改失败";
        }
    }
}
