package com.binary.servermonitor.entity;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class Volume {
    private String id;
    private String uuid;
    private String name;
    private String description;
    private String type;
    private String backType;
    private Integer size;
    private String status;
    private String productStatus;
    private String snapshotId;
    private String creatTime;
    private String deuTime;
    private String closrTime;
    private String payType;
    private String imageId;
    private Integer snapshotCount;
    private Boolean deleted;
    private String delType;
    private String delTime;
    private String ownerId;
    private String productModelId;
    private Integer statusNum;
    private ArrayList<AttachmentSet> attachmentSets = new ArrayList<AttachmentSet>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBackType() {
        return backType;
    }

    public void setBackType(String backType) {
        this.backType = backType;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getSnapshotId() {
        return snapshotId;
    }

    public void setSnapshotId(String snapshotId) {
        this.snapshotId = snapshotId;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getDeuTime() {
        return deuTime;
    }

    public void setDeuTime(String deuTime) {
        this.deuTime = deuTime;
    }

    public String getClosrTime() {
        return closrTime;
    }

    public void setClosrTime(String closrTime) {
        this.closrTime = closrTime;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public Integer getSnapshotCount() {
        return snapshotCount;
    }

    public void setSnapshotCount(Integer snapshotCount) {
        this.snapshotCount = snapshotCount;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getDelType() {
        return delType;
    }

    public void setDelType(String delType) {
        this.delType = delType;
    }

    public String getDelTime() {
        return delTime;
    }

    public void setDelTime(String delTime) {
        this.delTime = delTime;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getProductModelId() {
        return productModelId;
    }

    public void setProductModelId(String productModelId) {
        this.productModelId = productModelId;
    }

    public ArrayList<AttachmentSet> getAttachmentSets() {
        return attachmentSets;
    }

    public void setAttachmentSets(AttachmentSet attachmentSets) {
        this.attachmentSets.add(attachmentSets);
    }

    public Integer getStatusNum() {
        return statusNum;
    }

    public void setStatusNum(Integer statusNum) {
        this.statusNum = statusNum;
    }

    @Override
    public String toString() {
        return "Volume{" +
                "id='" + id + '\'' +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", backType='" + backType + '\'' +
                ", size=" + size +
                ", status='" + status + '\'' +
                ", productStatus='" + productStatus + '\'' +
                ", snapshotId='" + snapshotId + '\'' +
                ", creatTime='" + creatTime + '\'' +
                ", deuTime='" + deuTime + '\'' +
                ", closrTime='" + closrTime + '\'' +
                ", payType='" + payType + '\'' +
                ", imageId='" + imageId + '\'' +
                ", snapshotCount=" + snapshotCount +
                ", deleted=" + deleted +
                ", delType='" + delType + '\'' +
                ", delTime='" + delTime + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", productModelId='" + productModelId + '\'' +
                ", statusNum=" + statusNum +
                ", attachmentSets=" + attachmentSets +
                '}';
    }
}
