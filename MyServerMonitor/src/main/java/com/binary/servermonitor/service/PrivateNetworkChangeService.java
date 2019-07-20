package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.network.PrivateNetworkChangeApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wei Peng
 */
@RestController
public class PrivateNetworkChangeService {

    public String privateNetworkChange(UserInfo userInfo,String hostId,String oldNetworkId,String newNetworkId,String networkIpAddress){
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("ChangeInstanceInterface");
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        requestparameters.setRegion(region[0]);
        PrivateNetworkChangeApi privateNetworkChangeApi = new PrivateNetworkChangeApi();
        String json = privateNetworkChangeApi.url(requestparameters,hostId,oldNetworkId,newNetworkId,networkIpAddress);
        JSONObject jsonObject = new JSONObject(json);
        try {
            String taskId = jsonObject.getString("TaskId");
            String action = jsonObject.getString("Action");
            String instanceInterfaceId = jsonObject.getString("InstanceInterfaceId");
            return "变更成功，新实例网卡标识:" + instanceInterfaceId;
        }catch (Exception e){
            return "变更失败";
        }
    }

}
