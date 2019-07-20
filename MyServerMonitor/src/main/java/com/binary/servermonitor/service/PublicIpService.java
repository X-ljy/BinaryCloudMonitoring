package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.network.PublicIpApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.PublicIp;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class PublicIpService {
    public ArrayList<PublicIp> pubIpQuery(UserInfo userInfo){
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        Requestparameters requestparameters = new Requestparameters();
        PublicIpApi publicIpApi = new PublicIpApi();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("DescribeEips");
        ArrayList<PublicIp> list = new ArrayList<PublicIp>();
        for (int i = 0;i <region.length;i ++){
            requestparameters.setRegion(region[i]);
            String json = publicIpApi.url(requestparameters);
            JSONObject jsonObject = new JSONObject(json);
            String taskId = jsonObject.getString("TaskId");
            Integer totalCount = jsonObject.getInt("TotalCount");
            JSONArray array = jsonObject.getJSONArray("EipSet");
            for (int j = 0;j < totalCount;j ++){
                JSONObject jsonObject1 = array.getJSONObject(j);
                PublicIp publicIp = new PublicIp();
                publicIp.setId(jsonObject1.getString("Id"));
                publicIp.setEip(jsonObject1.getString("Eip"));
                try {
                    publicIp.setName(jsonObject1.getString("Name"));
                }catch (Exception e){
                    publicIp.setName("null");
                }
                publicIp.setBandwidth(jsonObject1.getString("Bandwidth"));
                try {
                    publicIp.setDeviceId(jsonObject1.getString("DeviceId"));
                }catch (Exception e){
                    publicIp.setDeviceId("null");
                }
                try {
                    if ("INSTANCE".equals(jsonObject1.getString("DeviceType"))){
                        publicIp.setDeviceType("云主机");
                    }
                    else if ("ROUTER".equals(jsonObject1.getString("DeviceType"))){
                        publicIp.setDeviceType("路由器");
                    }
                    else if ("LOADBALANCE".equals(jsonObject1.getString("DeviceType"))){
                        publicIp.setDeviceType("负载均衡器");
                    }
                    else if ("IRONIC".equals(jsonObject1.getString("DeviceType"))){
                        publicIp.setDeviceType("裸机");
                    }
                    else {
                        publicIp.setDeviceType("null");
                    }
                }catch (Exception e){
                    publicIp.setDeviceType("null");
                }

                try {
                    publicIp.setDeviceName(jsonObject1.getString("DeviceName"));
                }catch (Exception e){
                    publicIp.setDeviceName("null");
                }

                try {
                    publicIp.setRemark(jsonObject1.getString("Remark"));
                }catch (Exception e){
                    publicIp.setRemark("null");
                }


                if ("NORMAL".equals(jsonObject1.getString("ProductStatus"))){
                    publicIp.setStatus("正常");
                }
                else if ("OVERTIMER".equals(jsonObject1.getString("ProductStatus"))){
                    publicIp.setStatus("过期");
                }
                else if ("ARREARAGE".equals(jsonObject1.getString("ProductStatus"))){
                    publicIp.setStatus("欠费");
                }
                else {
                    publicIp.setProductStatus(jsonObject1.getString("ProductStatus"));
                }

                if ("ONDEMAND".equals(jsonObject1.getString("PayType"))){
                    publicIp.setPayType("按量付费");
                }
                else if ("PREPAID".equals(jsonObject1.getString("PayType"))){
                    publicIp.setPayType("包年包月");
                }
                else if ("PROBATION".equals(jsonObject1.getString("PayType"))){
                    publicIp.setPayType("试用");
                }
                else {
                    publicIp.setPayType(jsonObject1.getString("PayType"));
                }
                publicIp.setCreatTime(jsonObject1.getString("CreateTime"));
                publicIp.setDueTime(jsonObject1.getString("DueTime"));
                publicIp.setCloseTime(jsonObject1.getString("CloseTime"));
                publicIp.setEipUsed(jsonObject.getInt("EipUsed"));
                publicIp.setNetworkId(jsonObject1.getString("NetworkId"));
                if ("ASSIGNED".equals(jsonObject1.getString("Status"))){
                    publicIp.setStatus("已绑定");
                }
                else {
                    publicIp.setStatus(jsonObject1.getString("Status"));
                }
                list.add(publicIp);
            }
        }
        return list;
    }
}
