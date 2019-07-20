package com.binary.servermonitor.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_host_ip")
public class HostIp {

    @Id
    @Column(length = 100)
    private String hostid;
    @Column(length = 100)
    private String hostip;

    public String getHostid() {
        return hostid;
    }

    public void setHostid(String hostid) {
        this.hostid = hostid;
    }

    public String getHostip() {
        return hostip;
    }

    public void setHostip(String hostip) {
        this.hostip = hostip;
    }

    public HostIp(String hostid, String hostip) {
        this.hostid = hostid;
        this.hostip = hostip;
    }
    public HostIp() {

    }

    @Override
    public String toString() {
        return "HostIp{" +
                "hostid='" + hostid + '\'' +
                ", hostip='" + hostip + '\'' +
                '}';
    }
}
