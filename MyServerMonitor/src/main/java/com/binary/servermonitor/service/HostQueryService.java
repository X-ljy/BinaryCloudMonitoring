package com.binary.servermonitor.service;

import com.binary.servermonitor.entity.HostInfo;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.data_api.host.HostInformationApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Wei Peng
 */
public class HostQueryService {
    public HostInfo[] hostquery(UserInfo userInfo){
        int n = 0;
        Requestparameters requestparameters = new Requestparameters();
        HostInformationApi hostInformationApi = new HostInformationApi();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("DescribeInstances");
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        HostInfo[] host = new HostInfo[2];
        for (int i = 0;i<region.length;i++){
            String json = "";
            requestparameters.setRegion(region[i]);
            json = hostInformationApi.url(requestparameters);
            JSONArray array = new JSONArray(json);
            for (int j=0;j<array.length();j++) {
                HostInfo hostInfo = new HostInfo();
                JSONObject jsonObject = array.getJSONObject(j);
                hostInfo.setId(jsonObject.getString("Id"));
                hostInfo.setStatus(jsonObject.getString("Status"));
                hostInfo.setHostname(jsonObject.getString("Name"));
                hostInfo.setProducttype(jsonObject.getString("ProductType"));
                hostInfo.setImagename(jsonObject.getString("OsName") + " " + jsonObject.getString("OsBit") + "Bit");
                JSONArray array1 = jsonObject.getJSONArray("VolumeSet");
                StringBuilder disk = new StringBuilder();
                for (int k = 0; k < array1.length(); k++) {
                    JSONObject jsonObject1 = array1.getJSONObject(k);
                    disk.append(String.valueOf(jsonObject1.getInt("Size"))).append("GB  ");

                }
                hostInfo.setDisk(String.valueOf(disk));
                JSONArray array2 = jsonObject.getJSONArray("InternetSet");
                JSONObject jsonObject1 = array2.getJSONObject(0);
                hostInfo.setPublicip(jsonObject1.getString("IpAddress"));
                host[n] = hostInfo;
                n = n + 1;
            }

        }

        return host;
    }
}
