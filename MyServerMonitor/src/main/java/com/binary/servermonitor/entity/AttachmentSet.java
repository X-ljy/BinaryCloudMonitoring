package com.binary.servermonitor.entity;

/**
 * @author Wei Peng
 * 卷当前挂载信息的数据类型
 */
public class AttachmentSet {
    private String attachTime;
    private Boolean deleteOnTermination;
    private String index;
    private String status;
    private String volumeId;
    private String instanceId;
    /**
     * checkOffLine  挂载的虚拟机的操作系统类型，windows返回true，linux返回false
     */
    private String checkOffLine;

    public String getAttachTime() {
        return attachTime;
    }

    public void setAttachTime(String attachTime) {
        this.attachTime = attachTime;
    }

    public Boolean getDeleteOnTermination() {
        return deleteOnTermination;
    }

    public void setDeleteOnTermination(Boolean deleteOnTermination) {
        this.deleteOnTermination = deleteOnTermination;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
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

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public String getCheckOffLine() {
        return checkOffLine;
    }

    public void setCheckOffLine(String checkOffLine) {
        this.checkOffLine = checkOffLine;
    }

    @Override
    public String toString() {
        return "AttachmentSet{" +
                "attachTime='" + attachTime + '\'' +
                ", deleteOnTermination=" + deleteOnTermination +
                ", index=" + index +
                ", status='" + status + '\'' +
                ", volumeId='" + volumeId + '\'' +
                ", instanceId='" + instanceId + '\'' +
                ", checkOffLine=" + checkOffLine +
                '}';
    }
}
