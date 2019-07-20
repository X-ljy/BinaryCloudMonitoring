package com.binary.servermonitor.entity;

/**
 * @author Wei Peng
 */
public class HostInfo {
    private String hostname;
    private String status;
    private String producttype;
    private String id;
    private String publicip;
    private String imagename;
    private String disk;
    private String firewallId;

    public String getFirewallId() {
        return firewallId;
    }

    public void setFirewallId(String firewallId) {
        this.firewallId = firewallId;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPublicip() {
        return publicip;
    }

    public void setPublicip(String publicip) {
        this.publicip = publicip;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    @Override
    public String toString() {
        return "HostInfo{" +
                "hostname='" + hostname + '\'' +
                ", status='" + status + '\'' +
                ", producttype='" + producttype + '\'' +
                ", id='" + id + '\'' +
                ", publicip='" + publicip + '\'' +
                ", imagename='" + imagename + '\'' +
                ", disk='" + disk + '\'' +
                ", firewallId='" + firewallId + '\'' +
                '}';
    }
}
