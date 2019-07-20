package com.binary.servermonitor.data_api.host;

public class Interface {
    private String Id;
    private String InstanceId;
    private String NetworkId;
    private String SubnetId;
    private String MacAddress;
    private String IpAddress;
    private String Status;
    private String Uuid;
    private String Type;
    private String NetworkName;
    private Integer Bandwidth;

    public Integer getBandwidth() {
        return Bandwidth;
    }

    public void setBandwidth(Integer bandwidth) {
        Bandwidth = bandwidth;
    }

    public String getNetworkName() {
        return NetworkName;
    }

    public void setNetworkName(String networkName) {
        NetworkName = networkName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getInstanceId() {
        return InstanceId;
    }

    public void setInstanceId(String instanceId) {
        InstanceId = instanceId;
    }

    public String getNetworkId() {
        return NetworkId;
    }

    public void setNetworkId(String networkId) {
        NetworkId = networkId;
    }

    public String getSubnetId() {
        return SubnetId;
    }

    public void setSubnetId(String subnetId) {
        SubnetId = subnetId;
    }

    public String getMacAddress() {
        return MacAddress;
    }

    public void setMacAddress(String macAddress) {
        MacAddress = macAddress;
    }

    public String getIpAddress() {
        return IpAddress;
    }

    public void setIpAddress(String ipAddress) {
        IpAddress = ipAddress;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getUuid() {
        return Uuid;
    }

    public void setUuid(String uuid) {
        Uuid = uuid;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    @Override
    public String toString() {
        return "Interface{" +
                "Id='" + Id + '\'' +
                ", InstanceId='" + InstanceId + '\'' +
                ", NetworkId='" + NetworkId + '\'' +
                ", SubnetId='" + SubnetId + '\'' +
                ", MacAddress='" + MacAddress + '\'' +
                ", IpAddress='" + IpAddress + '\'' +
                ", Status='" + Status + '\'' +
                ", Uuid='" + Uuid + '\'' +
                ", Type='" + Type + '\'' +
                ", NetworkName='" + NetworkName + '\'' +
                ", Bandwidth=" + Bandwidth +
                '}';
    }
}
