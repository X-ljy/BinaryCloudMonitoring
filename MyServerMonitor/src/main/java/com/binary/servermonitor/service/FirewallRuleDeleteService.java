package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.firewall.FireWallRuleDeleteApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONObject;

/**
 * @author Wei Peng
 */
public class FirewallRuleDeleteService {
    public String ruleDelete(UserInfo userInfo,String id){
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("DeleteFirewallRules");
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        requestparameters.setRegion(region[0]);
        FireWallRuleDeleteApi fireWallRuleDeleteApi = new FireWallRuleDeleteApi();
        String json = fireWallRuleDeleteApi.url(requestparameters,id);
        JSONObject jsonObject = new JSONObject(json);
        try {
            String taskId = jsonObject.getString("TaskId");
            String action = jsonObject.getString("Action");
            return "删除成功";
        }catch (Exception e){
            return "删除失败";
        }
    }
}
