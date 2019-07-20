package com.binary.servermonitor.service;

import com.binary.servermonitor.entity.ImageInfo;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.data_api.image.Inquire;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Wei Peng
 */
public class ImageQueryService {
    public ImageInfo[] imageQueryService(UserInfo userInfo){
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("DescribeImages");
        JSONArray array = new JSONArray();
        for (int i = 0;i < region.length;i ++){
            requestparameters.setRegion(region[i]);
            Inquire inquire = new Inquire();
            String json = inquire.url(requestparameters);
            JSONObject jsonObject = new JSONObject(json);
            if ("success".equals(jsonObject.getString("Code"))){
                JSONArray array1 = jsonObject.getJSONArray("ImageSet");
                for (int j = 0;j < array1.length();j ++){
                    array.put(array1.getJSONObject(j));
                }
            }
        }
        ImageInfo[] imageInfo = new ImageInfo[array.length()];
        for (int i = 0;i < array.length();i ++){
            JSONObject jsonObject = array.getJSONObject(i);
            ImageInfo info = new ImageInfo();
            info.setId(jsonObject.getString("Id"));
            info.setName(jsonObject.getString("Name"));
            info.setCreattime(jsonObject.getString("CreateTime"));
            info.setDescription(jsonObject.getString("Description"));
            info.setInstancenum(String.valueOf(jsonObject.getInt("InstanceNum"))+"个");
            info.setOwner(jsonObject.getString("Owner"));
            info.setSize(String.valueOf(jsonObject.getInt("Size"))+"GB");
            if ("INSTANCE".equals(jsonObject.getString("Use"))){
                info.setUse("云主机");
            }
            else {
                info.setUse(jsonObject.getString("Use"));
            }
            imageInfo[i] = info;

        }
        return imageInfo;
    }
}
