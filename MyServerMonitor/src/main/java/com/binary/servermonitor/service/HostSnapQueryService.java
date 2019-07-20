package com.binary.servermonitor.service;

import com.binary.servermonitor.data_api.host.HostSnapQueryApi;
import com.binary.servermonitor.data_api.parameters.Requestparameters;
import com.binary.servermonitor.entity.HostSnap;
import com.binary.servermonitor.entity.UserInfo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class HostSnapQueryService {
    public ArrayList<HostSnap> hostSnapQueryService(UserInfo userInfo){
        Requestparameters requestparameters = new Requestparameters();
        ArrayList<HostSnap> list = new ArrayList<HostSnap>();
        String region[] = userInfo.getCompuretroom().replaceAll("[\\[\\]]", "").split(",");
        requestparameters.setAccessKeyId(userInfo.getAccess_key_id());
        requestparameters.setAccessKeySecret(userInfo.getAccess_key_secret());
        requestparameters.setAction("DescribeInstanceSnapshots");
        requestparameters.setRegion(region[0]);
        HostSnapQueryApi hostSnapQueryApi = new HostSnapQueryApi();
        String json = hostSnapQueryApi.url(requestparameters);
        JSONObject jsonObject = new JSONObject(json);
        try {
            String taskId = jsonObject.getString("TaskId");
            String action = jsonObject.getString("Action");
            Integer totalCount = jsonObject.getInt("TotalCount");
            JSONArray array = jsonObject.getJSONArray("InstanceSnapshotSet");
            for (int i = 0;i < totalCount;i++){
                JSONObject jsonObject1 = array.getJSONObject(i);
                HostSnap hostSnap = new HostSnap();
                hostSnap.setId(jsonObject1.getString("Id"));
                hostSnap.setName(jsonObject1.getString("Name"));
                try {
                    hostSnap.setDescription(jsonObject1.getString("Description"));
                }catch (Exception e){
                    hostSnap.setDescription("null");
                }
                hostSnap.setStartTime(jsonObject1.getString("StartTime"));
                try {
                    if ("AVAILABLE".equals(jsonObject1.getString("Status"))){
                        hostSnap.setStatus("可用");
                    }
                    else if ("CREATING".equals(jsonObject1.getString("Status"))){
                        hostSnap.setStatus("创建中");
                    }
                    else if ("DELETING".equals(jsonObject1.getString("Status"))){
                        hostSnap.setStatus("删除");
                    }
                    else if ("ERROR".equals(jsonObject1.getString("Status"))){
                        hostSnap.setStatus("错误");
                    }
                    else if ("ERROR_DELETING".equals(jsonObject1.getString("Status"))){
                        hostSnap.setStatus("删除错误");
                    }
                    else if ("ROLLING_BACK".equals(jsonObject1.getString("Status"))){
                        hostSnap.setStatus("回滚");
                    }
                    else {
                        hostSnap.setStatus(jsonObject1.getString("Status"));
                    }
                }catch (Exception e){
                    hostSnap.setStatus("null");
                }
                hostSnap.setVolumeId(jsonObject1.getString("VolumeId"));
                try {
                    hostSnap.setVolumeSnapshotId(jsonObject1.getString("VolumeSnapshotId"));
                }catch (Exception e){
                    hostSnap.setVolumeSnapshotId("null");
                }
                hostSnap.setSize(jsonObject1.getInt("Size"));
                hostSnap.setInstanceId(jsonObject1.getString("InstanceId"));
                hostSnap.setLocked(jsonObject1.getBoolean("Locked"));
                hostSnap.setUserId(jsonObject1.getString("UserId"));
                hostSnap.setFileLock(jsonObject1.getBoolean("IsFileLock"));
                list.add(hostSnap);
            }
        }catch (Exception e){
            HostSnap hostSnap = new HostSnap();
            list.add(hostSnap);
        }
        return list;
    }
}
