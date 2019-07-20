package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.firewall.FireWallRuleQueryApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.FireWallRule;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class FireWallRuleQueryService {
    public ArrayList<FireWallRule> fireWallRuleQuery(UserInfo userInfo, String id){
        ArrayList<FireWallRule> list = new ArrayList<FireWallRule>();
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("DescribeFirewallRules");
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        requestparameters.setRegion(region[0]);
        FireWallRuleQueryApi fireWallRuleQueryApi = new FireWallRuleQueryApi();
        String json = fireWallRuleQueryApi.url(requestparameters,id);
        JSONObject jsonObject = new JSONObject(json);
        try {
            Integer totalCount = jsonObject.getInt("TotalCount");
            JSONArray array = jsonObject.getJSONArray("FirewallRuleSet");
            for (int i = 0;i <totalCount;i ++){
                JSONObject jsonObject1 = array.getJSONObject(i);
                FireWallRule fireWallRule = new FireWallRule();
                fireWallRule.setId(jsonObject1.getString("Id"));
                try {
                    fireWallRule.setName(jsonObject1.getString("Name"));
                }catch (Exception e){
                    fireWallRule.setName("null");
                }
                try {
                    String direction = jsonObject1.getString("Direction");
                    if ("ingress".equals(direction)){
                        fireWallRule.setDirection("下行");
                    }
                    else if ("egress".equals(direction)){
                        fireWallRule.setDirection("上行");
                    }
                    else {
                        fireWallRule.setDirection(direction);
                    }
                }catch (Exception e){
                    fireWallRule.setDirection("null");
                }
                try {
                    fireWallRule.setPortStart(String.valueOf(jsonObject1.getInt("PortStart")));
                }catch (Exception e){
                    fireWallRule.setPortStart("--");
                }
                try {
                    fireWallRule.setPortEnd(String.valueOf(jsonObject1.getInt("PortEnd")));
                }catch (Exception e){
                    fireWallRule.setPortEnd("--");
                }
                try {
                    fireWallRule.setPriority(jsonObject1.getInt("Priority"));
                }catch (Exception e){
                    fireWallRule.setPriority(0);
                }
                try {
                    fireWallRule.setProtocol(jsonObject1.getString("Protocol"));
                }catch (Exception e){
                    fireWallRule.setProtocol("null");
                }
                try {
                    fireWallRule.setEnabled(jsonObject1.getBoolean("Enabled"));
                }catch (Exception e){
                    fireWallRule.setEnabled(false);
                }
                list.add(fireWallRule);
            }
        }catch (Exception e){
            System.out.println("查询失败");
        }
        return list;
    }
}
