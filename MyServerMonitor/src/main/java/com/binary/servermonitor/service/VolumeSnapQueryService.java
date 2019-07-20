package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.host.VolumeSnapQueryApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.UserInfo;
import com.binary.servermonitor.entity.VolumeSnap;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class VolumeSnapQueryService {
    public ArrayList<VolumeSnap> queryService(UserInfo userInfo){
        Requestparameters requestparameters = new Requestparameters();
        ArrayList<VolumeSnap> list = new ArrayList<VolumeSnap>();
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("DescribeSnapshots");
        requestparameters.setRegion(region[0]);
        VolumeSnapQueryApi volumeSnapQueryApi = new VolumeSnapQueryApi();
        String json = volumeSnapQueryApi.url(requestparameters);
        JSONObject jsonObject = new JSONObject(json);
        try {
            String taskId = jsonObject.getString("TaskId");
            String action = jsonObject.getString("Action");
            Integer totalCount = jsonObject.getInt("TotalCount");
            JSONArray array = jsonObject.getJSONArray("SnapshotSet");
            for (int i = 0;i < totalCount;i ++){
                VolumeSnap volumeSnap = new VolumeSnap();
                JSONObject jsonObject1 = array.getJSONObject(i);
                volumeSnap.setId(jsonObject1.getString("Id"));
                try {
                    volumeSnap.setName(jsonObject1.getString("Name"));
                }catch (Exception e){
                    volumeSnap.setName("null");
                }
                try {
                    volumeSnap.setDescription(jsonObject1.getString("Description"));
                }catch (Exception e){
                    volumeSnap.setDescription("null");
                }
                volumeSnap.setSize(jsonObject1.getInt("Size"));
                volumeSnap.setStartTime(jsonObject1.getString("StartTime"));
                volumeSnap.setVolumeId(jsonObject1.getString("VolumeId"));
                try {
                    if ("AVAILABLE".equals(jsonObject1.getString("Status"))){
                        volumeSnap.setStatus("可用");
                    }
                    else if ("CREATING".equals(jsonObject1.getString("Status"))){
                        volumeSnap.setStatus("创建中");
                    }
                    else if ("DELETING".equals(jsonObject1.getString("Status"))){
                        volumeSnap.setStatus("删除");
                    }
                    else if ("ERROR".equals(jsonObject1.getString("Status"))){
                        volumeSnap.setStatus("错误");
                    }
                    else if ("ERROR_DELETING".equals(jsonObject1.getString("Status"))){
                        volumeSnap.setStatus("删除错误");
                    }
                    else {
                        volumeSnap.setStatus(jsonObject1.getString("Status"));
                    }
                }catch (Exception e){
                    volumeSnap.setStatus("null");
                }
                list.add(volumeSnap);
            }
        }catch (Exception e){
            VolumeSnap volumeSnap = new VolumeSnap();
            list.add(volumeSnap);
        }
        return list;
    }

}
