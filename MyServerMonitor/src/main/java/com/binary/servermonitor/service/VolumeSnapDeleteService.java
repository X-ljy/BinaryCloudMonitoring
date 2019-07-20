package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.host.HostSnapRestoreApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONObject;

public class VolumeSnapDeleteService {
    public String deleteService(UserInfo userInfo,String snapId){
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        requestparameters.setRegion(region[0]);
        requestparameters.setAction("DeleteSnapshot");
        HostSnapRestoreApi hostSnapRestoreApi = new HostSnapRestoreApi();
        String json = hostSnapRestoreApi.url(requestparameters,snapId);
        System.out.println(json);
        JSONObject jsonObject = new JSONObject(json);
        try {
            String taskId = jsonObject.getString("TaskId");
            String action = jsonObject.getString("Action");
            Integer errorCode = jsonObject.getInt("ErrorCode");
            if (errorCode == 1100){
                return "请先关闭云主机";
            }
            else {
                return jsonObject.getString("ErrorMessage");
            }
        }catch (Exception e){
            try {
                String taskId = jsonObject.getString("TaskId");
                String action = jsonObject.getString("Action");
                return "删除成功";
            }catch (Exception f){
                return "删除失败";
            }
        }
    }
}
