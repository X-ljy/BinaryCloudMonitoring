package com.binary.servermonitor.entity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Wei Peng
 */
public class PrivateNetwork {
    private String id;
    private String uuid;
    private String name;
    private String description;
    /**
     * cidr IP地址范围
     */
    private String cidr;
    private String type;
    private Boolean dhcp;
    private String gateway;
    private String productStatus;
    private String ipStart;
    private String ipEnd;
    private String[] ips;
    private String idLong;
    /**
     * specialLineId 所属专线
     */
    private String specialLineId;
    private String creatTime;
    /**
     * bindingSets 绑定资源对象
     */
    private ArrayList<BindingSet> bindingSets = new ArrayList<BindingSet>();
    /**
     * userId 所属用户
     */
    private String userId;
    /**
     *  subnetId 私有网络子网标识
     */
    private String subnetId;
    /**
     *  subnetUuid 私有子网uuid
     */
    private String subnetUuid;
    /**
     *  subnetLongId 私有子网LongId
     */
    private String subnetLongId;

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

    public String getCidr() {
        return cidr;
    }

    public void setCidr(String cidr) {
        this.cidr = cidr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getDhcp() {
        return dhcp;
    }

    public void setDhcp(Boolean dhcp) {
        this.dhcp = dhcp;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getIpStart() {
        return ipStart;
    }

    public void setIpStart(String ipStart) {
        this.ipStart = ipStart;
    }

    public String getIpEnd() {
        return ipEnd;
    }

    public void setIpEnd(String ipEnd) {
        this.ipEnd = ipEnd;
    }

    public String getSpecialLineId() {
        return specialLineId;
    }

    public void setSpecialLineId(String specialLineId) {
        this.specialLineId = specialLineId;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public ArrayList<BindingSet> getBindingSets() {
        return bindingSets;
    }

    public void setBindingSets(BindingSet bindingSet) {
        this.bindingSets.add(bindingSet);
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSubnetId() {
        return subnetId;
    }

    public void setSubnetId(String subnetId) {
        this.subnetId = subnetId;
    }

    public String getSubnetUuid() {
        return subnetUuid;
    }

    public void setSubnetUuid(String subnetUuid) {
        this.subnetUuid = subnetUuid;
    }

    public String getSubnetLongId() {
        return subnetLongId;
    }

    public void setSubnetLongId(String subnetLongId) {
        this.subnetLongId = subnetLongId;
    }

    public String[] getIps() {
        return ips;
    }

    public void setIps(String[] ips) {
        this.ips = ips;
    }

    public String getIdLong() {
        return idLong;
    }

    public void setIdLong(String idLong) {
        this.idLong = idLong;
    }

    @Override
    public String toString() {
        return "PrivateNetwork{" +
                "id='" + id + '\'' +
                ", uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cidr='" + cidr + '\'' +
                ", type='" + type + '\'' +
                ", dhcp=" + dhcp +
                ", gateway='" + gateway + '\'' +
                ", productStatus='" + productStatus + '\'' +
                ", ipStart='" + ipStart + '\'' +
                ", ipEnd='" + ipEnd + '\'' +
                ", ips=" + Arrays.toString(ips) +
                ", idLong='" + idLong + '\'' +
                ", specialLineId='" + specialLineId + '\'' +
                ", creatTime='" + creatTime + '\'' +
                ", bindingSets=" + bindingSets +
                ", userId='" + userId + '\'' +
                ", subnetId='" + subnetId + '\'' +
                ", subnetUuid='" + subnetUuid + '\'' +
                ", subnetLongId='" + subnetLongId + '\'' +
                '}';
    }
}
