package com.binary.servermonitor.data_api.host;

import java.util.Arrays;

public class Instance {
    private String Id;                      //实例标识
    private Integer InterfaceSize;          //
    private Integer VolumeSize;
    private String Name;                    //名称
    private String Status;                  //实例状态
    private String Task;                    //任务号
    private String ProductStatus;           //产品状态。取值范围：NORMAL-正常; OVERTIMER-过期; ARREARAGE-欠费
    private String PayType;                 //支付类型 ONDEMAND：按量付费；PREPAID：包年包月。临时实例忽略此参数
    private String ProductModelId;          //产品型号ID
    private String ProductType;             //产品类型
    private Integer Cpu;                    //CPU 核数
    private Integer Memory;                 //内存大小，单位是 GB
    private String Password;                //密码
    private String KeyPair;                 //密钥对ID
    private String KeyPairName;
    private String CreateTime;              //创建时间
    private String DueTime;                 //到期时间
    private String CloseTime;
    private String ShutdownTime;
    private String BindStatus;
    private Interface[] InterfaceSet;       //私有网络信息
    private Internet[] InternetSet;
    private Integer InternetSize;
    private Volume[] VolumeSet;
    private String Uuid;
    private String OwnerId;
    private String FirewallId;              //防火墙ID
    private String ImageId;                 //镜像ID
    private String ImageName;
    private String OsName;
    private String OsVersion;
    private String OsBit;
    private String InitPassword;            //初始密码
    private String UserId;
    private Boolean Locked;
    private String IdLong;
    private String HostName;
    private String Host;
    private String InstanceSeries;          //主机系列
    private String SeriesName;


    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    public String getHost() {
        return Host;
    }

    public void setHost(String host) {
        Host = host;
    }

    public String getKeyPairName() {
        return KeyPairName;
    }

    public void setKeyPairName(String keyPairName) {
        KeyPairName = keyPairName;
    }

    public String getBindStatus() {
        return BindStatus;
    }

    public void setBindStatus(String bindStatus) {
        BindStatus = bindStatus;
    }

    public String getShutdownTime() {
        return ShutdownTime;
    }

    public void setShutdownTime(String shutdownTime) {
        ShutdownTime = shutdownTime;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Integer getInterfaceSize() {
        return InterfaceSize;
    }

    public void setInterfaceSize(Integer interfaceSize) {
        InterfaceSize = interfaceSize;
        InterfaceSet = new Interface[InterfaceSize];
    }

    public Integer getVolumeSize() {
        return VolumeSize;
    }

    public void setVolumeSize(Integer volumeSize) {
        VolumeSize = volumeSize;
        VolumeSet = new Volume[VolumeSize];
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public String getProductStatus() {
        return ProductStatus;
    }

    public void setProductStatus(String productStatus) {
        ProductStatus = productStatus;
    }

    public String getPayType() {
        return PayType;
    }

    public void setPayType(String payType) {
        PayType = payType;
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

    public Integer getCpu() {
        return Cpu;
    }

    public void setCpu(Integer cpu) {
        Cpu = cpu;
    }

    public Integer getMemory() {
        return Memory;
    }

    public void setMemory(Integer memory) {
        Memory = memory;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getKeyPair() {
        return KeyPair;
    }

    public void setKeyPair(String keyPair) {
        KeyPair = keyPair;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
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

    public Interface[] getInterfaceSet() {
        return InterfaceSet;
    }

    public void setInterfaceSet(Interface[] interfaceSet) {
        InterfaceSet = interfaceSet;
    }

    public Internet[] getInternetSet() {
        return InternetSet;
    }

    public void setInternetSet(Internet[] internetSet) {
        InternetSet = internetSet;
    }

    public Integer getInternetSize() {
        return InternetSize;
    }

    public void setInternetSize(Integer internetSize) {
        InternetSize = internetSize;
        InternetSet = new Internet[InternetSize];
    }

    public Volume[] getVolumeSet() {
        return VolumeSet;
    }

    public void setVolumeSet(Volume[] volumeSet) {
        VolumeSet = volumeSet;
    }

    public String getUuid() {
        return Uuid;
    }

    public void setUuid(String uuid) {
        Uuid = uuid;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }

    public String getFirewallId() {
        return FirewallId;
    }

    public void setFirewallId(String firewallId) {
        FirewallId = firewallId;
    }

    public String getImageId() {
        return ImageId;
    }

    public void setImageId(String imageId) {
        ImageId = imageId;
    }

    public String getOsName() {
        return OsName;
    }

    public void setOsName(String osName) {
        OsName = osName;
    }

    public String getOsVersion() {
        return OsVersion;
    }

    public void setOsVersion(String osVersion) {
        OsVersion = osVersion;
    }

    public String getOsBit() {
        return OsBit;
    }

    public void setOsBit(String osBit) {
        OsBit = osBit;
    }

    public String getInitPassword() {
        return InitPassword;
    }

    public void setInitPassword(String initPassword) {
        InitPassword = initPassword;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public Boolean getLocked() {
        return Locked;
    }

    public void setLocked(Boolean locked) {
        Locked = locked;
    }

    public String getIdLong() {
        return IdLong;
    }

    public void setIdLong(String idLong) {
        IdLong = idLong;
    }

    public String getHostName() {
        return HostName;
    }

    public void setHostName(String hostName) {
        HostName = hostName;
    }

    public String getInstanceSeries() {
        return InstanceSeries;
    }

    public void setInstanceSeries(String instanceSeries) {
        InstanceSeries = instanceSeries;
    }

    public String getSeriesName() {
        return SeriesName;
    }

    public void setSeriesName(String seriesName) {
        SeriesName = seriesName;
    }

    @Override
    public String toString() {
        return "Instance{" +
                "Id='" + Id + '\'' +
                ", InterfaceSize=" + InterfaceSize +
                ", VolumeSize=" + VolumeSize +
                ", Name='" + Name + '\'' +
                ", Status='" + Status + '\'' +
                ", Task='" + Task + '\'' +
                ", ProductStatus='" + ProductStatus + '\'' +
                ", PayType='" + PayType + '\'' +
                ", ProductModelId='" + ProductModelId + '\'' +
                ", ProductType='" + ProductType + '\'' +
                ", Cpu=" + Cpu +
                ", Memory=" + Memory +
                ", Password='" + Password + '\'' +
                ", KeyPair='" + KeyPair + '\'' +
                ", KeyPairName='" + KeyPairName + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", DueTime='" + DueTime + '\'' +
                ", CloseTime='" + CloseTime + '\'' +
                ", ShutdownTime='" + ShutdownTime + '\'' +
                ", BindStatus='" + BindStatus + '\'' +
                ", InterfaceSet=" + Arrays.deepToString(InterfaceSet) +
                ", InternetSet=" + Arrays.deepToString(InternetSet) +
                ", InternetSize=" + InternetSize +
                ", VolumeSet=" + Arrays.deepToString(VolumeSet) +
                ", Uuid='" + Uuid + '\'' +
                ", OwnerId='" + OwnerId + '\'' +
                ", FirewallId='" + FirewallId + '\'' +
                ", ImageId='" + ImageId + '\'' +
                ", ImageName='" + ImageName + '\'' +
                ", OsName='" + OsName + '\'' +
                ", OsVersion='" + OsVersion + '\'' +
                ", OsBit='" + OsBit + '\'' +
                ", InitPassword='" + InitPassword + '\'' +
                ", UserId='" + UserId + '\'' +
                ", Locked=" + Locked +
                ", IdLong='" + IdLong + '\'' +
                ", HostName='" + HostName + '\'' +
                ", Host='" + Host + '\'' +
                ", InstanceSeries='" + InstanceSeries + '\'' +
                ", SeriesName='" + SeriesName + '\'' +
                '}';
    }
}
