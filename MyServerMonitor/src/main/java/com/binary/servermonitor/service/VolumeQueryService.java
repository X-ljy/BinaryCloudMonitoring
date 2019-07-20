package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.disk.VolumekApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.AttachmentSet;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.entity.Volume;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class VolumeQueryService {
    public ArrayList<Volume> volumeQuery(UserInfo userInfo){
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        Requestparameters requestparameters = new Requestparameters();
        VolumekApi volumekApi = new VolumekApi();
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("DescribeVolumes");
        ArrayList<Volume> list = new ArrayList<Volume>();
        for (int i = 0;i < region.length;i ++){
            requestparameters.setRegion(region[i]);
            String json = volumekApi.url(requestparameters);
            System.out.println(json);
            JSONObject jsonObject = new JSONObject(json);
            String taskId = jsonObject.getString("TaskId");
            Integer totalCount = jsonObject.getInt("TotalCount");
            JSONArray array = jsonObject.getJSONArray("VolumeSet");
            for (int j = 0;j < totalCount;j ++){
                Volume volume = new Volume();
                JSONObject jsonObject1 = array.getJSONObject(j);
                volume.setId(jsonObject1.getString("Id"));
                volume.setUuid(jsonObject1.getString("Uuid"));
                volume.setName(jsonObject1.getString("Name"));
                try {
                    volume.setDescription(jsonObject1.getString("Description"));
                }catch (Exception e){
                    volume.setDescription("null");
                }
                try {
                    volume.setType(jsonObject1.getString("Type"));
                }
                catch (Exception e){
                    volume.setType("null");
                }
                if ("rbd".equals(jsonObject1.getString("BackType"))){
                    volume.setBackType("普通磁盘");
                }
                else if ("ssd".equals(jsonObject1.getString("BackType"))){
                    volume.setBackType("固态硬盘");
                }
                else if ("sata".equals(jsonObject1.getString("BackType"))){
                    volume.setBackType("sata");
                }
                else {
                    volume.setBackType(jsonObject1.getString("BackType"));
                }
                volume.setSize(jsonObject1.getInt("Size"));
                volume.setStatus(jsonObject1.getString("Status"));
                if ("NORMAL".equals(jsonObject1.getString("ProductStatus"))){
                    volume.setProductStatus("正常");
                }
                else if ("OVERTIMER".equals(jsonObject1.getString("ProductStatus"))){
                    volume.setProductStatus("过期");
                }
                else if ("ARREARAGE".equals(jsonObject1.getString("ProductStatus"))){
                    volume.setProductStatus("欠费");
                }
                else {
                    volume.setProductStatus(jsonObject1.getString("ProductStatus"));
                }
                try {
                    volume.setSnapshotId(jsonObject1.getString("SnapshotId"));
                }catch (Exception e){
                    volume.setSnapshotId("null");
                }
                volume.setClosrTime(jsonObject1.getString("CreateTime"));
                try {
                    volume.setDeuTime(jsonObject1.getString("DueTime"));
                }catch (Exception e){
                    volume.setDeuTime("null");
                }
                volume.setClosrTime(String.valueOf(jsonObject1.get("CloseTime")));
                try {
                    if("ONDEMAND".equals(jsonObject1.getString("PayType"))){
                        volume.setPayType("按量付费");
                    }
                    else if("PREPAID".equals(jsonObject1.getString("PayType"))){
                        volume.setPayType("包年包月");
                    }
                    else if("PROBATION".equals(jsonObject1.getString("PayType"))){
                        volume.setPayType("试用");
                    }
                    else {
                        volume.setPayType(jsonObject1.getString("PayType"));
                    }
                }catch (Exception e){
                    volume.setPayType("null");
                }
                try {
                    volume.setImageId(jsonObject1.getString("ImageId"));
                }catch (Exception e){
                    volume.setImageId("null");
                }
                volume.setSnapshotCount(jsonObject1.getInt("SnapshotCount"));
                try {
                    volume.setImageId(jsonObject1.getString("ImageId"));
                }
                catch (Exception e){
                    volume.setImageId("null");
                }
                try {
                    if ("ADMIN".equals(jsonObject1.getString("DelType"))){
                        volume.setDelType("管理员删除");
                    }
                    else if ("CUSTOMER".equals(jsonObject1.getString("DelType"))){
                        volume.setDelType("用户主动删除");
                    }
                    else if ("INSUFFICIENT".equals(jsonObject1.getString("DelType"))){
                        volume.setDelType("欠费删除（系统触发）");
                    }
                    else if ("EXPIRETIME".equals(jsonObject1.getString("DelType"))){
                        volume.setDelType("过期删除（系统触发）");
                    }
                }catch (Exception e){
                    volume.setDelType("null");
                }
                try {
                    volume.setDelTime(jsonObject1.getString("DeletedTime"));
                }catch (Exception e){
                    volume.setDelTime("null");
                }
                volume.setOwnerId(jsonObject1.getString("UserId"));
                try {
                    volume.setProductModelId(jsonObject1.getString("ProductModelId"));
                }catch (Exception e){
                    volume.setProductModelId("null");
                }
                try {
                    JSONArray array1 = jsonObject1.getJSONArray("AttachmentSet");
                    for (int k = 0;k <array1.length();k ++){
                        JSONObject jsonObject2 = array1.getJSONObject(k);
                        AttachmentSet attachmentSet = new AttachmentSet();
                        attachmentSet.setAttachTime(jsonObject2.getString("AttachTime"));
                        attachmentSet.setDeleteOnTermination(jsonObject2.getBoolean("DeleteOnTermination"));
                        if (0 == jsonObject2.getInt("Index")){
                            attachmentSet.setIndex("系统盘");
                        }
                        else {
                            attachmentSet.setIndex("数据盘");
                        }
                        if ("ATTACHED".equals(jsonObject2.getString("Status"))){
                            attachmentSet.setStatus("已挂载");
                            volume.setStatusNum(0);
                        }
                        else{
                            attachmentSet.setStatus(jsonObject2.getString("Status"));
                            volume.setStatusNum(1);
                        }
                        attachmentSet.setVolumeId(jsonObject2.getString("VolumeId"));
                        attachmentSet.setInstanceId(jsonObject2.getString("InstanceId"));
                        if (jsonObject2.getBoolean("CheckOffLine")){
                            attachmentSet.setCheckOffLine("Windows");
                        }
                        else {
                            attachmentSet.setCheckOffLine("Linux");
                        }
                        volume.setAttachmentSets(attachmentSet);
                    }
                }catch (Exception e){
                    AttachmentSet attachmentSet = new AttachmentSet();
                    volume.setAttachmentSets(attachmentSet);
                }
                list.add(volume);
            }
        }
        return list;
    }
}
