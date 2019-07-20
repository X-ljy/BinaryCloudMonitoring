package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.network.PrivateNetworkEditApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONObject;

/**
 * @author Wei Peng
 */
public class PrivateNetworkEditService {
    public String privateNetworkEdit(UserInfo userInfo,String id,String name,String description){
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("ModifyNetworkAttributes");
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        requestparameters.setRegion(region[0]);
        PrivateNetworkEditApi privateNetworkEditApi = new PrivateNetworkEditApi();
        String josn = privateNetworkEditApi.url(requestparameters,id,name,description);
        JSONObject jsonObject = new JSONObject(josn);
        System.out.println(josn);
        try {
            String tastId = jsonObject.getString("TaskId");
            String action = jsonObject.getString("Action");
            return "修改成功";
        }catch (Exception e){
            return "修改失败";
        }
    }
}
