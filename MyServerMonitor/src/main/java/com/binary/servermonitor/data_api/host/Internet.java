package com.binary.servermonitor.data_api.host;

public class Internet {
    private String Id;
    private String IpAddress;
    private Integer Bandwidth;
    private String PayType;
    private String DueTime;
    private String CloseTime;
    private String AllocateTime;
    private String ProductStatus;
    private String ProductModelId;
    private String ProductType;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public void setIpAddress(String ipAddress) {
        IpAddress = ipAddress;
    }

    public Integer getBandwidth() {
        return Bandwidth;
    }

    public void setBandwidth(Integer bandwidth) {
        Bandwidth = bandwidth;
    }

    public String getPayType() {
        return PayType;
    }

    public void setPayType(String payType) {
        PayType = payType;
    }

    public String getDueTime() {
        return DueTime;
    }

    public void setDueTime(String dueTime) {
        DueTime = dueTime;
    }

    public String getCloseTime() {
        return CloseTime;
    }

    public void setCloseTime(String closeTime) {
        CloseTime = closeTime;
    }

    public String getAllocateTime() {
        return AllocateTime;
    }

    public void setAllocateTime(String allocateTime) {
        AllocateTime = allocateTime;
    }

    public String getProductStatus() {
        return ProductStatus;
    }

    public void setProductStatus(String productStatus) {
        ProductStatus = productStatus;
    }

    public String getProductModelId() {
        return ProductModelId;
    }

    public void setProductModelId(String productModelId) {
        ProductModelId = productModelId;
    }

    public String getProductType() {
        return ProductType;
    }

    public void setProductType(String productType) {
        ProductType = productType;
    }

    @Override
    public String toString() {
        return "Internet{" +
                "Id='" + Id + '\'' +
                ", IpAddress='" + IpAddress + '\'' +
                ", Bandwidth=" + Bandwidth +
                ", PayType='" + PayType + '\'' +
                ", DueTime='" + DueTime + '\'' +
                ", CloseTime='" + CloseTime + '\'' +
                ", AllocateTime='" + AllocateTime + '\'' +
                ", ProductStatus='" + ProductStatus + '\'' +
                ", ProductModelId='" + ProductModelId + '\'' +
                ", ProductType='" + ProductType + '\'' +
                '}';
    }
}
