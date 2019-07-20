package com.binary.servermonitor.data_api.host;

public class Volume {
    private String Id;
    private String Name;
    private String Type;
    private String PayType;
    private Integer Size;
    private Integer Index;
    private String DueTime;
    private String CloseTime;
    private String CreateTime;
    private String Uuid;
    private String ProductStatus;
    private Integer ProductModelId;

    public Integer getProductModelId() {
        return ProductModelId;
    }

    public void setProductModelId(Integer productModelId) {
        ProductModelId = productModelId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPayType() {
        return PayType;
    }

    public void setPayType(String payType) {
        PayType = payType;
    }

    public Integer getSize() {
        return Size;
    }

    public void setSize(Integer size) {
        Size = size;
    }

    public Integer getIndex() {
        return Index;
    }

    public void setIndex(Integer index) {
        Index = index;
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

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getUuid() {
        return Uuid;
    }

    public void setUuid(String uuid) {
        Uuid = uuid;
    }

    public String getProductStatus() {
        return ProductStatus;
    }

    public void setProductStatus(String productStatus) {
        ProductStatus = productStatus;
    }

    @Override
    public String toString() {
        return "Volume{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Type='" + Type + '\'' +
                ", PayType='" + PayType + '\'' +
                ", Size=" + Size +
                ", Index=" + Index +
                ", DueTime='" + DueTime + '\'' +
                ", CloseTime='" + CloseTime + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", Uuid='" + Uuid + '\'' +
                ", ProductStatus='" + ProductStatus + '\'' +
                ", ProductModelId=" + ProductModelId +
                '}';
    }
}
