package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.image.ImageDeleteApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Wei Peng
 */
public class ImageDeleteService {
    public String imageDeleteService(UserInfo userInfo,String imageId){
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("DeleteImage");
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        requestparameters.setRegion(region[0]);
        ImageDeleteApi imageDeleteApi = new ImageDeleteApi();
        String json = imageDeleteApi.url(requestparameters,imageId);
        JSONObject jsonObject = new JSONObject(json);
        try {
            String taskId = jsonObject.getString("TaskId");
            Integer totalCount = jsonObject.getInt("TotalCount");
            return "删除成功";
        }catch (Exception e){
            System.out.println(jsonObject.toString());
            return "删除失败";
        }
    }
}
