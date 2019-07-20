package com.binary.servermonitor.entity;

public class DataDisk {
    private String id;
    private String name;
    private String type;
    private String paytype;
    private Integer size;
    private String duetime;
    private String creattime;
    private String uuid;
    private String productstatus;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getDuetime() {
        return duetime;
    }

    public void setDuetime(String duetime) {
        this.duetime = duetime;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getProductstatus() {
        return productstatus;
    }

    public void setProductstatus(String productstatus) {
        this.productstatus = productstatus;
    }

    @Override
    public String toString() {
        return "DataDisk{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", paytype='" + paytype + '\'' +
                ", size=" + size +
                ", duetime='" + duetime + '\'' +
                ", creattime='" + creattime + '\'' +
                ", uuid='" + uuid + '\'' +
                ", productstatus='" + productstatus + '\'' +
                '}';
    }
}
