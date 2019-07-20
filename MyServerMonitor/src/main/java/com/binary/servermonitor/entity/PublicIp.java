package com.binary.servermonitor.entity;

/**
 * @author Wei Peng
 */
public class PublicIp {
    private String id;
    private String eip;
    private String name;
    private String bandwidth;
    private String deviceId;
    private String deviceType;
    private String deviceName;
    /**
     * remark 备注
     */
    private String remark;
    private String productStatus;
    private String payType;
    private String creatTime;
    private String dueTime;
    private String closeTime;
    private Integer eipUsed;
    private String status;
    private String networkId;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEip() {
        return eip;
    }

    public void setEip(String eip) {
        this.eip = eip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getDueTime() {
        return dueTime;
    }

    public void setDueTime(String dueTime) {
        this.dueTime = dueTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Integer getEipUsed() {
        return eipUsed;
    }

    public void setEipUsed(Integer eipUsed) {
        this.eipUsed = eipUsed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNetworkId() {
        return networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    @Override
    public String toString() {
        return "PublicIp{" +
                "id='" + id + '\'' +
                ", eip='" + eip + '\'' +
                ", name='" + name + '\'' +
                ", bandwidth='" + bandwidth + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", remark='" + remark + '\'' +
                ", productStatus='" + productStatus + '\'' +
                ", payType='" + payType + '\'' +
                ", creatTime='" + creatTime + '\'' +
                ", dueTime='" + dueTime + '\'' +
                ", closeTime='" + closeTime + '\'' +
                ", eipUsed=" + eipUsed +
                ", status='" + status + '\'' +
                ", networkId='" + networkId + '\'' +
                '}';
    }
}
