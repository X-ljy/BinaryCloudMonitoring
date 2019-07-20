package com.binary.servermonitor.controller;

import com.binary.servermonitor.data_api.host.CreatSnapApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.repository.UserInfoRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author Wei Peng
 */
@RestController
public class HostSnapController {
    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/host/creatSnap")
    public String hostSnap(HttpSession session,@RequestParam String hostId){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        Requestparameters requestparameters = new Requestparameters();
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("CreateInstanceSnapshot");
        JSONObject jsonObject = new JSONObject(userInfo.getRegion());
        for (int i = 0;i < region.length;i ++){
            JSONArray array = jsonObject.getJSONArray(region[i]);
            for (int j = 0;j < array.length();j ++){
                if (hostId.equals(array.getString(j))){
                    requestparameters.setRegion(region[i]);
                    CreatSnapApi creatSnapApi = new CreatSnapApi();
                    String json = creatSnapApi.url(requestparameters,hostId);
                    System.out.println(json);
                    JSONObject jsonObject1 = new JSONObject(json);
                    try {
                        String snapId = jsonObject1.getString("InstanceSnapshotId");
                        return "主机"+ hostId+"的快照创建成功,快照Id为:"+snapId;
                    }catch (Exception e){
                        String msg = jsonObject1.getString("ErrorMsg");
                        return msg;
                    }
                }
            }
        }
        return "";
    }

}
