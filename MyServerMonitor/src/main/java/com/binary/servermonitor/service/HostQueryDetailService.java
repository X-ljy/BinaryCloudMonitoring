package com.binary.servermonitor.service;

import com.binary.servermonitor.entity.DataDisk;
import com.binary.servermonitor.entity.HostInfoDetail;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.data_api.api.CpuApi;
import com.binary.servermonitor.data_api.api.VolumeApi;
import com.binary.servermonitor.data_api.host.HostApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author Wei Peng
 */
public class HostQueryDetailService {
    public HostInfoDetail queryDetail(UserInfo userInfo, String hostId){
        HostApi hostApi = new HostApi();
        HostInfoDetail hostInfoDetail = new HostInfoDetail();
        Requestparameters requestparameters = new Requestparameters();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("DescribeInstances");
        String comroom = userInfo.getCompuretroom();
        String publicip;
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        JSONObject jsonObject = new JSONObject(userInfo.getRegion());
        for (int i = 0;i<region.length;i++){
            JSONArray array = jsonObject.getJSONArray(region[i]);
            for (int j = 0;j<array.length();j++){
                if (hostId.equals(array.getString(j))){
                    requestparameters.setRegion(region[i]);
                    String json = hostApi.url(requestparameters,hostId);
                    JSONObject jsonObject1 = new JSONObject(json);
                    JSONArray array1 = jsonObject1.getJSONArray("InstanceSet");
                    JSONObject jsonObject2 = array1.getJSONObject(0);

                    hostInfoDetail.setId(jsonObject2.getString("Id"));
                    hostInfoDetail.setImageName(jsonObject2.getString("OsName") + " " + jsonObject2.getString("OsBit") + "Bit");
                    hostInfoDetail.setFirewallId(jsonObject2.getString("FirewallId"));
                    hostInfoDetail.setName(jsonObject2.getString("Name"));
                    hostInfoDetail.setHost(jsonObject2.getString("Host"));
                    if ("START".equals(jsonObject2.getString("Status"))){
                        hostInfoDetail.setStatus(jsonObject2.getString("Status"));
                        hostInfoDetail.setStatuse("关机");
                        hostInfoDetail.setStatusnum("0");
                    }
                    else {
                        hostInfoDetail.setStatus(jsonObject2.getString("Status"));
                        hostInfoDetail.setStatuse("开机");
                        hostInfoDetail.setStatusnum("1");
                    }
                    hostInfoDetail.setStatus(jsonObject2.getString("Status"));
                    hostInfoDetail.setProductstatus(jsonObject2.getString("ProductStatus"));
                    if ("PREPAID".equals(jsonObject2.getString("PayType"))){
                        hostInfoDetail.setPaytype("包年包月");
                    }
                    else if ("ONDEMAND".equals(jsonObject2.getString("PayType"))){
                        hostInfoDetail.setPaytype("按量付费");
                    }
                    else {
                        hostInfoDetail.setPaytype(jsonObject2.getString("PayType"));
                    }

                    if ("NORMAL".equals(jsonObject2.getString("ProductStatus"))){
                        hostInfoDetail.setProductstatus("正常");
                    }
                    else if ("OVERTIMER".equals(jsonObject2.getString("ProductStatus"))){
                        hostInfoDetail.setProductstatus("过期");
                    }
                    else if ("ARREARAGE".equals(jsonObject2.getString("ProductStatus"))){
                        hostInfoDetail.setProductstatus("欠费");
                    }
                    else {
                        hostInfoDetail.setProductstatus(jsonObject2.getString("ProductStatus"));
                    }
                    hostInfoDetail.setMemory(String.valueOf(jsonObject2.getInt("Memory"))+"GB");
                    hostInfoDetail.setCreattime(jsonObject2.getString("CreateTime"));
                    hostInfoDetail.setDuetime(jsonObject2.getString("DueTime"));
                    JSONArray array2 = jsonObject2.getJSONArray("InterfaceSet");
                    JSONObject jsonObject3 = array2.getJSONObject(0);
                    hostInfoDetail.setPrinetid(jsonObject3.getString("Id"));
                    hostInfoDetail.setPrinetname(jsonObject3.getString("NetworkName"));
                    hostInfoDetail.setPrinetip(jsonObject3.getString("IpAddress"));
                    hostInfoDetail.setPrinetipstatus(jsonObject3.getString("Status"));
                    hostInfoDetail.setPrinetbandwidth(String.valueOf(jsonObject3.getInt("Bandwidth"))+"Mbps");
                    JSONArray array3 = jsonObject2.getJSONArray("Internet");
                    JSONObject jsonObject4 = array3.getJSONObject(0);
                    hostInfoDetail.setPubnetid(jsonObject4.getString("Id"));
                    hostInfoDetail.setPubnetip(jsonObject4.getString("IpAddress"));
                    publicip = hostInfoDetail.getPubnetip();
                    hostInfoDetail.setPubnetbandwidth(String.valueOf(jsonObject4.getInt("Bandwidth"))+"Mbps");
                    hostInfoDetail.setPubnetduetime(jsonObject4.getString("DueTime"));
                    hostInfoDetail.setPubnetfirewallname(jsonObject4.getString("RouterFirewallName"));
                    if ("ONDEMAND".equals(jsonObject4.getString("PayType"))){
                        hostInfoDetail.setPubnetpaytype("按量付费");
                    }
                    else if ("PREPAID".equals(jsonObject4.getString("PayType"))){
                        hostInfoDetail.setPubnetpaytype("包年包月");
                    }
                    else if("PROBATION".equals(jsonObject4.getString("PayType"))){
                        hostInfoDetail.setPubnetpaytype("试用");
                    }
                    else {
                        hostInfoDetail.setPubnetpaytype(jsonObject4.getString("PayType"));
                    }

                    if ("NORMAL".equals(jsonObject4.getString("ProductStatus"))){
                        hostInfoDetail.setPubnetprotype("正常");
                    }
                    else if ("OVERTIMER".equals(jsonObject4.getString("ProductStatus"))){
                        hostInfoDetail.setPubnetprotype("过期");
                    }
                    else if ("ARREARAGE".equals(jsonObject4.getString("ProductStatus"))){
                        hostInfoDetail.setPubnetprotype("欠费");
                    }
                    else {
                        hostInfoDetail.setPubnetprotype(jsonObject4.getString("ProductStatus"));
                    }
                    JSONArray array4 = jsonObject2.getJSONArray("VolumeSet");
                    for (int k=0;k<array4.length();k++){
                        JSONObject jsonObject5 = array4.getJSONObject(k);
                        if (jsonObject5.getInt("Index") == 0){
                            hostInfoDetail.setVolumeid(jsonObject5.getString("Id"));
                            hostInfoDetail.setVolumename(jsonObject5.getString("Name"));
                            hostInfoDetail.setVolumeduetime(jsonObject5.getString("DueTime"));
                            hostInfoDetail.setVolumesize(String.valueOf(jsonObject5.getInt("Size"))+"GB");
                            if ("NORMAL".equals(jsonObject5.getString("ProductStatus"))){
                                hostInfoDetail.setVolumestatus("正常");
                            }
                            else if("OVERTIMER".equals(jsonObject5.getString("ProductStatus"))){
                                hostInfoDetail.setVolumestatus("过期");
                            }
                            else if ("ARREARAGE".equals(jsonObject5.getString("ProductStatus"))){
                                hostInfoDetail.setVolumestatus("欠费");
                            }
                            else {
                                hostInfoDetail.setVolumestatus(jsonObject5.getString("ProductStatus"));
                            }
                            hostInfoDetail.setVolumetype(jsonObject5.getString("Type"));

                        }
                        else {
                            DataDisk dataDisk = new DataDisk();
                            dataDisk.setId(jsonObject5.getString("Id"));
                            dataDisk.setName(jsonObject5.getString("Name"));
                            dataDisk.setType(jsonObject5.getString("Type"));
                            if ("ONDEMAND".equals(jsonObject5.getString("PayType"))){
                                dataDisk.setPaytype("按量付费");
                            }
                            else if ("PREPAID".equals(jsonObject5.getString("PayType"))){
                                dataDisk.setPaytype("包年包月");
                            }
                            else if("PROBATION".equals(jsonObject5.getString("PayType"))){
                                dataDisk.setPaytype("试用");
                            }
                            else {
                                dataDisk.setPaytype(jsonObject5.getString("PayType"));
                            }
                            dataDisk.setSize(jsonObject5.getInt("Size"));
                            dataDisk.setCreattime(jsonObject5.getString("CreateTime"));
                            dataDisk.setDuetime(jsonObject5.getString("DueTime"));
                            dataDisk.setUuid(jsonObject5.getString("Uuid"));
                            if ("NORMAL".equals(jsonObject5.getString("ProductStatus"))){
                                dataDisk.setProductstatus("正常");
                            }
                            else if("OVERTIMER".equals(jsonObject5.getString("ProductStatus"))){
                                dataDisk.setProductstatus("过期");
                            }
                            else if ("ARREARAGE".equals(jsonObject5.getString("ProductStatus"))){
                                dataDisk.setProductstatus("欠费");
                            }
                            else {
                                dataDisk.setProductstatus(jsonObject5.getString("ProductStatus"));
                            }
                            hostInfoDetail.setDiskList(dataDisk);


                        }
                    }
                    CpuApi cpuApi = new CpuApi();
                    try {
                        JSONObject jsonObject5 = new JSONObject(cpuApi.getCpuInfo(publicip));
                        hostInfoDetail.setCpuname(jsonObject5.getString("cpuName"));
                        hostInfoDetail.setCpuversion(jsonObject5.getString("cpuVersion"));
                        hostInfoDetail.setCpucores(jsonObject5.getString("logicCores"));
                        hostInfoDetail.setCpumainfreq(jsonObject5.getString("cpuMHz"));
                        VolumeApi volumeApi = new VolumeApi();
                        JSONObject jsonObject6 = new JSONObject(volumeApi.getdiskInfo(publicip));
                        JSONObject jsonObject7 = jsonObject6.getJSONObject("data");
                        JSONObject jsonObject8 = jsonObject7.getJSONObject("overlay");
                        hostInfoDetail.setVolumeused(jsonObject8.getString("diskUsed"));
                    }catch (Exception e){
                        hostInfoDetail.setCpuname("null");
                        hostInfoDetail.setCpuversion("null");
                        hostInfoDetail.setCpucores("null");
                        hostInfoDetail.setCpumainfreq("null");
                        hostInfoDetail.setVolumeused("null");
                    }

                    return hostInfoDetail;
                }
            }
        }
        return hostInfoDetail;
    }

}
