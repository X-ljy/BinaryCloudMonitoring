package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.image.ImageCreatApi;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Wei Peng
 */
public class ImageCreatService {
    public String imageCreat(UserInfo userInfo,String hostid,String description,String name,String volumeType){
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        String json;
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("CaptureInstance");
        JSONObject jsonObject = new JSONObject(userInfo.getRegion());
        for (int i = 0;i < region.length;i ++){
            JSONArray array = jsonObject.getJSONArray(region[i]);
            for (int j = 0;j < array.length(); j++){
                if (hostid.equals(array.getString(j))){
                    requestparameters.setRegion(region[i]);
                    ImageCreatApi imageCreat = new ImageCreatApi();
                    json = imageCreat.url(requestparameters,hostid,volumeType,name,description);
                    JSONObject jsonObject1 = new JSONObject(json);
                    System.out.println(json);
                    try {
                        String imageId = jsonObject1.getString("ImageId");
                        return "创建成功,镜像Id"+ imageId;
                    }catch (Exception e){
                        Integer errorCode = jsonObject1.getInt("ErrorCode");
                        if (1100 == errorCode){
                            return "请先关闭主机";
                        }
                        else {
                            return jsonObject1.getString("ErrorMessage");
                        }
                    }
                }
            }
        }
        return "";
    }
}
