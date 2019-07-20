package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.disk.InstallDiskApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Wei Peng
 */
public class InstallDiskService {
    public String uninstallDisk(UserInfo userInfo,String volumeId,String hostId){

        InstallDiskApi installDiskApi = new InstallDiskApi();
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAction("AttachVolume");
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        JSONObject jsonObject = new JSONObject(userInfo.getRegion());
        for (int i = 0;i < region.length;i ++){
            JSONArray array = jsonObject.getJSONArray(region[i]);
            for (int j = 0;j < array.length();j ++){
                if (hostId.equals(array.getString(j))){
                    requestparameters.setRegion(region[i]);
                    String json = installDiskApi.url(requestparameters,volumeId,hostId);
                    System.out.println(json);
                    JSONObject jsonObject1 = new JSONObject(json);
                    JSONObject jsonObject2 = new JSONObject();
                    try {
                        String taskId = jsonObject1.getString("TaskId");
                        String action = jsonObject1.getString("Action");
                        jsonObject2.put("Code","Success");
                        return jsonObject2.toString();
                    }catch (Exception e){
                        String code = jsonObject1.getString("ErrorCode");
                        String msg = jsonObject1.getString("ErrorMsg");
                        jsonObject2.put("Code","error");
                        jsonObject2.put("ErrorMsg",msg);
                        return jsonObject2.toString();
                    }

                }
            }
        }
        return "";
    }
}
