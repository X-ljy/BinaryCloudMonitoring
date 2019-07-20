package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.disk.VolumeSnapApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONObject;

/**
 * @author Wei Peng
 */
public class VolumeSnapService {
    public String volumeSnapService(UserInfo userInfo,String volumeId,String name,String description){
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("CreateSnapshot");
        requestparameters.setRegion(region[0]);
        VolumeSnapApi volumeSnapApi = new VolumeSnapApi();
        String json = volumeSnapApi.url(requestparameters,volumeId,name,description);
        System.out.println(json);
        JSONObject jsonObject = new JSONObject(json);
        try {
            String snapHostId = jsonObject.getString("SnapshotId");
            return "创建成功，主机快照Id为" + snapHostId;
        }catch (Exception e){
            return "创建失败";
        }

    }
}
