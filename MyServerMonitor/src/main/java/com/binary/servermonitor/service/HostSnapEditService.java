package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.host.HostSnapEditApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONObject;

public class HostSnapEditService {
    public String snapEdit(UserInfo userInfo,String snapId,String name,String description){
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        requestparameters.setRegion(region[0]);
        requestparameters.setAction("ModifyInstanceSnapshotAttributes");
        HostSnapEditApi hostSnapEditApi = new HostSnapEditApi();
        String json = hostSnapEditApi.url(requestparameters,snapId,name,description);
        JSONObject jsonObject = new JSONObject(json);
        try {
            String taskId = jsonObject.getString("TaskId");
            String action = jsonObject.getString("Action");
            Integer errorCode = jsonObject.getInt("ErrorCode");
            if (errorCode == 1100) {
                return "名称的长度必须介于1-50之间";
            }
            else {
                return "快照信息修改失败";
            }

        }catch (Exception e){
            try {
                String taskId = jsonObject.getString("TaskId");
                String action = jsonObject.getString("Action");
                System.out.println(jsonObject.toString());
                return "快照信息修改成功";
            }catch (Exception f){
                return "快照信息修改失败";
            }
        }

    }
}
