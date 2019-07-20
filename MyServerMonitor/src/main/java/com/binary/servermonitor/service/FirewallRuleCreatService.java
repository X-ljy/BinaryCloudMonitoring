package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.firewall.FirewallRuleCreatApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONObject;

public class FirewallRuleCreatService {
    public String ruleCreat(UserInfo userInfo,String firewallId,String name,String direction,String portStart,String portEnd,
                            String portocol,String priority){
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("CreateFirewallRule");
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        requestparameters.setRegion(region[0]);
        FirewallRuleCreatApi firewallRuleCreatApi = new FirewallRuleCreatApi();
        String json = firewallRuleCreatApi.url(requestparameters,firewallId,name,direction,portStart,portEnd,portocol,priority);
        JSONObject jsonObject = new JSONObject(json);
        System.out.println(json);
        try {
            String taskId = jsonObject.getString("TaskId");
            String action = jsonObject.getString("Action");
            String firewallRuleId = jsonObject.getString("FirewallRuleId");
            return "创建成功，规则Id为" + firewallRuleId;
        }catch (Exception e){
            return "创建失败";
        }
    }
}
