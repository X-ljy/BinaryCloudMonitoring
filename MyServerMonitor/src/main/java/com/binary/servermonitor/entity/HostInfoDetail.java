package com.binary.servermonitor.entity;

import java.util.ArrayList;

/**
 * @author Wei Peng
 */
public class HostInfoDetail {
    private String id;
    private String name;
    private String host;
    private String status;
    private String statuse;
    private String statusnum;
    private String productstatus;
    private String paytype;

    private String firewallId;
    private String imageName;

    private String cpuname;
    private String cpuversion;
    private String cpucores;
    private String cpumainfreq;

    private String memory;

    private String creattime;
    private String duetime;

    private String prinetid;
    private String prinetname;
    private String prinetip;
    private String prinetbandwidth;
    private String prinetipstatus;

    private String pubnetid;
    private String pubnetip;
    private String pubnetbandwidth;
    private String pubnetpaytype;
    private String pubnetduetime;
    private String pubnetprotype;
    private String pubnetfirewallname;

    private String volumeid;
    private String volumename;
    private String volumetype;
    private String volumesize;
    private String volumeused;
    private String volumeduetime;
    private String volumestatus;

    public String getFirewallId() {
        return firewallId;
    }

    public void setFirewallId(String firewallId) {
        this.firewallId = firewallId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    private ArrayList<DataDisk> diskList = new ArrayList<>();

    public String getPrinetipstatus() {
        return prinetipstatus;
    }

    public void setPrinetipstatus(String prinetipstatus) {
        this.prinetipstatus = prinetipstatus;
    }

    public String getStatuse() {
        return statuse;
    }

    public void setStatuse(String statuse) {
        this.statuse = statuse;
    }

    public String getStatusnum() {
        return statusnum;
    }

    public void setStatusnum(String statusnum) {
        this.statusnum = statusnum;
    }

    public ArrayList<DataDisk> getDiskList() {
        return diskList;
    }

    public void setDiskList(DataDisk dataDisk) {
        this.diskList.add(dataDisk);
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

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProductstatus() {
        return productstatus;
    }

    public void setProductstatus(String productstatus) {
        this.productstatus = productstatus;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getCpuname() {
        return cpuname;
    }

    public void setCpuname(String cpuname) {
        this.cpuname = cpuname;
    }

    public String getCpuversion() {
        return cpuversion;
    }

    public void setCpuversion(String cpuversion) {
        this.cpuversion = cpuversion;
    }

    public String getCpucores() {
        return cpucores;
    }

    public void setCpucores(String cpucores) {
        this.cpucores = cpucores;
    }

    public String getCpumainfreq() {
        return cpumainfreq;
    }

    public void setCpumainfreq(String cpumainfreq) {
        this.cpumainfreq = cpumainfreq;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getDuetime() {
        return duetime;
    }

    public void setDuetime(String duetime) {
        this.duetime = duetime;
    }

    public String getPrinetid() {
        return prinetid;
    }

    public void setPrinetid(String prinetid) {
        this.prinetid = prinetid;
    }

    public String getPrinetname() {
        return prinetname;
    }

    public void setPrinetname(String prinetname) {
        this.prinetname = prinetname;
    }

    public String getPrinetip() {
        return prinetip;
    }

    public void setPrinetip(String prinetip) {
        this.prinetip = prinetip;
    }

    public String getPrinetbandwidth() {
        return prinetbandwidth;
    }

    public void setPrinetbandwidth(String prinetbandwidth) {
        this.prinetbandwidth = prinetbandwidth;
    }

    public String getPubnetid() {
        return pubnetid;
    }

    public void setPubnetid(String pubnetid) {
        this.pubnetid = pubnetid;
    }

    public String getPubnetip() {
        return pubnetip;
    }

    public void setPubnetip(String pubnetip) {
        this.pubnetip = pubnetip;
    }

    public String getPubnetbandwidth() {
        return pubnetbandwidth;
    }

    public void setPubnetbandwidth(String pubnetbandwidth) {
        this.pubnetbandwidth = pubnetbandwidth;
    }

    public String getPubnetpaytype() {
        return pubnetpaytype;
    }

    public void setPubnetpaytype(String pubnetpaytype) {
        this.pubnetpaytype = pubnetpaytype;
    }

    public String getPubnetduetime() {
        return pubnetduetime;
    }

    public void setPubnetduetime(String pubnetduetime) {
        this.pubnetduetime = pubnetduetime;
    }

    public String getPubnetprotype() {
        return pubnetprotype;
    }

    public void setPubnetprotype(String pubnetprotype) {
        this.pubnetprotype = pubnetprotype;
    }

    public String getPubnetfirewallname() {
        return pubnetfirewallname;
    }

    public void setPubnetfirewallname(String pubnetfirewallname) {
        this.pubnetfirewallname = pubnetfirewallname;
    }

    public String getVolumeid() {
        return volumeid;
    }

    public void setVolumeid(String volumeid) {
        this.volumeid = volumeid;
    }

    public String getVolumename() {
        return volumename;
    }

    public void setVolumename(String volumename) {
        this.volumename = volumename;
    }

    public String getVolumetype() {
        return volumetype;
    }

    public void setVolumetype(String volumetype) {
        this.volumetype = volumetype;
    }

    public String getVolumesize() {
        return volumesize;
    }

    public void setVolumesize(String volumesize) {
        this.volumesize = volumesize;
    }

    public String getVolumeused() {
        return volumeused;
    }

    public void setVolumeused(String volumeused) {
        this.volumeused = volumeused;
    }

    public String getVolumeduetime() {
        return volumeduetime;
    }

    public void setVolumeduetime(String volumeduetime) {
        this.volumeduetime = volumeduetime;
    }

    public String getVolumestatus() {
        return volumestatus;
    }

    public void setVolumestatus(String volumestatus) {
        this.volumestatus = volumestatus;
    }

    @Override
    public String toString() {
        return "HostInfoDetail{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", host='" + host + '\'' +
                ", status='" + status + '\'' +
                ", statuse='" + statuse + '\'' +
                ", statusnum='" + statusnum + '\'' +
                ", productstatus='" + productstatus + '\'' +
                ", paytype='" + paytype + '\'' +
                ", firewallId='" + firewallId + '\'' +
                ", imageName='" + imageName + '\'' +
                ", cpuname='" + cpuname + '\'' +
                ", cpuversion='" + cpuversion + '\'' +
                ", cpucores='" + cpucores + '\'' +
                ", cpumainfreq='" + cpumainfreq + '\'' +
                ", memory='" + memory + '\'' +
                ", creattime='" + creattime + '\'' +
                ", duetime='" + duetime + '\'' +
                ", prinetid='" + prinetid + '\'' +
                ", prinetname='" + prinetname + '\'' +
                ", prinetip='" + prinetip + '\'' +
                ", prinetbandwidth='" + prinetbandwidth + '\'' +
                ", prinetipstatus='" + prinetipstatus + '\'' +
                ", pubnetid='" + pubnetid + '\'' +
                ", pubnetip='" + pubnetip + '\'' +
                ", pubnetbandwidth='" + pubnetbandwidth + '\'' +
                ", pubnetpaytype='" + pubnetpaytype + '\'' +
                ", pubnetduetime='" + pubnetduetime + '\'' +
                ", pubnetprotype='" + pubnetprotype + '\'' +
                ", pubnetfirewallname='" + pubnetfirewallname + '\'' +
                ", volumeid='" + volumeid + '\'' +
                ", volumename='" + volumename + '\'' +
                ", volumetype='" + volumetype + '\'' +
                ", volumesize='" + volumesize + '\'' +
                ", volumeused='" + volumeused + '\'' +
                ", volumeduetime='" + volumeduetime + '\'' +
                ", volumestatus='" + volumestatus + '\'' +
                ", diskList=" + diskList +
                '}';
    }
}