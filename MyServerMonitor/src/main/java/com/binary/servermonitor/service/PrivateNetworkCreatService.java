package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.network.PrivateNetworkCreatkApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONObject;

/**
 * @author Wei Peng
 */
public class PrivateNetworkCreatService {

    public String pprivateNetworkCreat(UserInfo userInfo,String cidr,String dhcp,String name,String description){
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("CreateNetwork");
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        requestparameters.setRegion(region[0]);
        PrivateNetworkCreatkApi privateNetworkCreatkApi = new PrivateNetworkCreatkApi();
        String json = privateNetworkCreatkApi.url(requestparameters,cidr,dhcp,name,description);
        JSONObject jsonObject = new JSONObject(json);
        System.out.println(json);
        try {
            String taskId = jsonObject.getString("TaskId");
            String action = jsonObject.getString("Action");
            String networkUuid = jsonObject.getString("NetworkUuid");
            String networkId = jsonObject.getString("NetworkId");
            return "创建成功，私有网络Id:" + networkId;
        }catch (Exception e){
            return "创建失败";
        }
    }
}
