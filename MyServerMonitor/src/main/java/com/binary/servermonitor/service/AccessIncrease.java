package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.host.HostInformationApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.HostIp;
import com.binary.servermonitor.util.RepositoryUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class AccessIncrease {

    public String getInformation(String accesskeyid, String accesskeysecret, String[] region){
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(accesskeyid);
        requestparameters.setAccessKeySecret(accesskeysecret);
        requestparameters.setAction("DescribeInstances");
        JSONObject jsonObject = new JSONObject();
        for (int i = 0;i<region.length;i++){
            requestparameters.setRegion(region[i]);
            System.out.println("region "+region[i]);
            HostInformationApi hostInformationApi = new HostInformationApi();
            String json = hostInformationApi.url(requestparameters);
            if ("0".equals(json)){
                jsonObject.put(region[i],"0");
            }
            else if ("error".equals(json)){
                return "error";
            }
            else {
                JSONArray array = new JSONArray(json);
                JSONArray array1 = new JSONArray();
                for (int j = 0; j < array.length(); j++) {
                    HostIp hostIp = new HostIp();
                    JSONObject jsonObject1 = array.getJSONObject(j);
                    String id = jsonObject1.getString("Id");
                    System.out.println(id);
                    array1.put(id);
                    hostIp.setHostid(id);
                    JSONArray array2 = jsonObject1.getJSONArray("InternetSet");
                    for (int n = 0;n < array2.length();n ++){
                        try{
                            JSONObject jsonObject2 = array2.getJSONObject(n);
                            hostIp.setHostip(jsonObject2.getString("IpAddress"));
                            RepositoryUtil.saveHostIp(hostIp);
                        }catch (Exception e){
                            hostIp.setHostip(null);
                            RepositoryUtil.saveHostIp(hostIp);
                        }

                    }
                }
                jsonObject.put(region[i], array1);
            }
        }
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }
}
