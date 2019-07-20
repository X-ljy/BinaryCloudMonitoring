package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.image.ImageDeleteApi;
import com.binary.servermonitor.data_api.image.ImageEditApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONObject;

/**
 * @author Wei Peng
 */
public class ImageEditService {
    public String imageEditService(UserInfo userInfo,String imageId,String name,String description){
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("ModifyImageAttributes");
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        requestparameters.setRegion(region[0]);
        ImageEditApi imageEditApi = new ImageEditApi();
        String json = imageEditApi.url(requestparameters,imageId,name,description);
        JSONObject jsonObject = new JSONObject(json);
        System.out.println(json);
        try {
            String taskId = jsonObject.getString("TaskId");
            String action = jsonObject.getString("Action");
            Integer errorCode = jsonObject.getInt("ErrorCode");
            if (errorCode == 1100) {
                return "名称的长度必须介于1-50之间";
            }
            else {
                return "镜像信息修改失败";
            }

        }catch (Exception e){
            System.out.println(jsonObject.toString());
            return "镜像信息修改成功";
        }
    }
}
