package com.binary.servermonitor.entity;

public class HostSnap {
    private Integer totalCount;
    private String id;
    private String name;
    private String description;
    private String startTime;
    private String status;
    private String volumeId;
    private String volumeSnapshotId;
    private Integer size;
    private String instanceId;
    private Boolean locked;
    private String userId;
    private Boolean isFileLock;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(String volumeId) {
        this.volumeId = volumeId;
    }

    public String getVolumeSnapshotId() {
        return volumeSnapshotId;
    }

    public void setVolumeSnapshotId(String volumeSnapshotId) {
        this.volumeSnapshotId = volumeSnapshotId;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Boolean getFileLock() {
        return isFileLock;
    }

    public void setFileLock(Boolean fileLock) {
        isFileLock = fileLock;
    }

    @Override
    public String toString() {
        return "HostSnap{" +
                "totalCount=" + totalCount +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startTime='" + startTime + '\'' +
                ", status='" + status + '\'' +
                ", volumeId='" + volumeId + '\'' +
                ", volumeSnapshotId='" + volumeSnapshotId + '\'' +
                ", size=" + size +
                ", instanceId='" + instanceId + '\'' +
                ", locked=" + locked +
                ", userId='" + userId + '\'' +
                ", isFileLock=" + isFileLock +
                '}';
    }
}
