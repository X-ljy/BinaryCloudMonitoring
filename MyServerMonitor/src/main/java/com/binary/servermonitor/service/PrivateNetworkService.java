package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.network.PrivateNetworkApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.BindingSet;
import com.binary.servermonitor.entity.PrivateNetwork;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wei Peng
 */
public class PrivateNetworkService {
    public ArrayList<PrivateNetwork> priNetService(UserInfo userInfo){
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        Requestparameters requestparameters = new Requestparameters();
        PrivateNetworkApi privateNetworkApi = new PrivateNetworkApi();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("DescribeNetworks");
        ArrayList<PrivateNetwork> list = new ArrayList<PrivateNetwork>();
        for (int i = 0; i< region.length;i ++){
            requestparameters.setRegion(region[i]);
            String json = privateNetworkApi.url(requestparameters);
            JSONObject jsonObject = new JSONObject(json);
            String taskId = jsonObject.getString("TaskId");
            Integer totalCount =  jsonObject.getInt("TotalCount");
            JSONArray array = jsonObject.getJSONArray("NetworkSet");
            for (int j = 0;j < totalCount;j ++){
                PrivateNetwork privateNetwork = new PrivateNetwork();
                JSONObject jsonObject1 = array.getJSONObject(j);
                privateNetwork.setId(jsonObject1.getString("Id"));
                privateNetwork.setName(jsonObject1.getString("Name"));
                privateNetwork.setDescription(jsonObject1.getString("Description"));
                privateNetwork.setCidr(jsonObject1.getString("Cidr"));
                privateNetwork.setType(jsonObject1.getString("Type"));
                privateNetwork.setDhcp(jsonObject1.getBoolean("Dhcp"));
                privateNetwork.setGateway(jsonObject1.getString("Gateway"));
                if ("NORMAL".equals(jsonObject1.getString("ProductStatus"))){
                    privateNetwork.setProductStatus("正常");
                }
                else if ("OVERTIMER".equals(jsonObject1.getString("ProductStatus"))){
                    privateNetwork.setProductStatus("过期");
                }
                else if ("ARREARAGE".equals(jsonObject1.getString("ProductStatus"))){
                    privateNetwork.setProductStatus("欠费");
                }
                else {
                    privateNetwork.setProductStatus(jsonObject1.getString("ProductStatus"));
                }
                privateNetwork.setProductStatus(jsonObject1.getString("ProductStatus"));
                privateNetwork.setIpStart(jsonObject1.getString("IpStart"));
                privateNetwork.setIpEnd(jsonObject1.getString("IpEnd"));
                privateNetwork.setCreatTime(jsonObject1.getString("CreateTime"));
                try{
                    privateNetwork.setSpecialLineId(jsonObject1.getString("SpecialLineId"));

                }catch (Exception e){
                    privateNetwork.setSpecialLineId("null");
                }
                JSONArray array1 = jsonObject1.getJSONArray("Ips");
                String[] ips = new String[array1.length()];
                for (int k = 0;k < array1.length();k ++){
                    ips[k] = array1.getString(k);
                }
                privateNetwork.setIps(ips);
                privateNetwork.setUuid(jsonObject1.getString("Uuid"));
                privateNetwork.setUserId(jsonObject1.getString("UserId"));
                privateNetwork.setIdLong(jsonObject1.getString("IdLong"));
                privateNetwork.setSubnetId(jsonObject1.getString("SubnetId"));
                privateNetwork.setSubnetUuid(jsonObject1.getString("SubnetUuid"));
                privateNetwork.setSubnetLongId(jsonObject1.getString("SubnetLongId"));
                JSONArray array2 = jsonObject1.getJSONArray("BindingSet");
                for (int k = 0;k <array2.length();k ++){
                    JSONObject jsonObject2 = array2.getJSONObject(k);
                    BindingSet bindingSet = new BindingSet();
                    bindingSet.setResourceId(jsonObject2.getString("ResourceId"));
                    bindingSet.setResourceName(jsonObject2.getString("ResourceName"));
                    if ("INSTANCE".equals(jsonObject2.getString("ResourceType"))){
                        bindingSet.setResourceType("云主机");
                    }
                    else if ("ROUTER".equals(jsonObject2.getString("ResourceType"))){
                        bindingSet.setResourceType("路由器");
                    }
                    else if ("LOADBALANCE".equals(jsonObject2.getString("ResourceType"))){
                        bindingSet.setResourceType("负载均衡器");
                    }
                    else if ("IRONIC".equals(jsonObject2.getString("ResourceType"))){
                        bindingSet.setResourceType("裸机");
                    }
                    else {
                        bindingSet.setResourceType("null");
                    }
                    String eip = String.valueOf(jsonObject2.get("ResourceEips"));
                    if (eip.length() == 4){
                        bindingSet.setResourceEips("null");
                    }
                    else {
                        JSONArray array3 = new JSONArray(eip);
                        for (int l = 0;l < array3.length();l ++){
                            bindingSet.setResourceEips(array3.getString(l));
                        }
                    }
                    privateNetwork.setBindingSets(bindingSet);
                }
                list.add(privateNetwork);
                System.out.println(privateNetwork);
            }
        }
        return list;
    }
}
