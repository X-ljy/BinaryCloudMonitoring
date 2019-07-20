package com.binary.servermonitor.controller;

import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.data_api.host.RebootApi;
import com.binary.servermonitor.data_api.host.Shutdown;
import com.binary.servermonitor.data_api.host.StartingUpApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
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
public class HostContrlController {


    @Autowired
    UserInfoRepository userInfoRepository;

    @PostMapping(value = "/host/shutdown")
    public String hostShutdown(HttpSession session,@RequestParam String hostid){
        System.out.println(0);
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        Shutdown shutdown = new Shutdown();
        String json = null;
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("StopInstance");
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        JSONObject jsonObject = new JSONObject(userInfo.getRegion());
        for (int i = 0;i<region.length;i++){
            JSONArray array = jsonObject.getJSONArray(region[i]);
            for (int j = 0;j<array.length();j++){
                if (hostid.equals(array.getString(j))){
                    requestparameters.setRegion(region[i]);
                    requestparameters.setId(hostid);
                    json = shutdown.url(requestparameters);
                }
            }
        }
        JSONObject jsonObject1 = new JSONObject(json);
        return jsonObject1.getString(hostid);
    }

    @PostMapping(value = "/host/startup")
    public String hostStartUp(HttpSession session,@RequestParam String hostid){
        System.out.println(1);
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        StartingUpApi startingUpApi = new StartingUpApi();
        String json = null;
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("StartInstance");
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        JSONObject jsonObject = new JSONObject(userInfo.getRegion());
        for (int i = 0;i<region.length;i++){
            JSONArray array = jsonObject.getJSONArray(region[i]);
            for (int j = 0;j<array.length();j++){
                if (hostid.equals(array.getString(j))){
                    requestparameters.setRegion(region[i]);
                    requestparameters.setId(hostid);
                    json = startingUpApi.url(requestparameters);

                }
            }
        }
        JSONObject jsonObject1 = new JSONObject(json);
        return jsonObject1.getString(hostid);
    }

    @PostMapping(value = "/host/reboot")
    public String hostReboot(HttpSession session,@RequestParam String hostid){
        UserInfo userInfo = userInfoRepository.findByUsername(String.valueOf(session.getAttribute("username")));
        RebootApi rebootApi = new RebootApi();
        String json = null;
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("RebootInstance");
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        JSONObject jsonObject = new JSONObject(userInfo.getRegion());
        for (int i = 0;i<region.length;i++){
            JSONArray array = jsonObject.getJSONArray(region[i]);
            for (int j = 0;j<array.length();j++){
                if (hostid.equals(array.getString(j))){
                    requestparameters.setRegion(region[i]);
                    requestparameters.setId(hostid);
                    json = rebootApi.url(requestparameters,true);
                }
            }
        }
        JSONObject jsonObject1 = new JSONObject(json);
        return jsonObject1.getString(hostid);
    }



}
