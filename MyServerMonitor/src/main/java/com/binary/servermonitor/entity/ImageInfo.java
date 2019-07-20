package com.binary.servermonitor.entity;

public class ImageInfo {
    private String id;
    private String name;
    private String description;
    private String owner;
    private String size;
    private String creattime;
    private String use;
    private String instancenum;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getInstancenum() {
        return instancenum;
    }

    public void setInstancenum(String instancenum) {
        this.instancenum = instancenum;
    }

    @Override
    public String toString() {
        return "ImageInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", owner='" + owner + '\'' +
                ", size='" + size + '\'' +
                ", creattime='" + creattime + '\'' +
                ", use='" + use + '\'' +
                ", instancenum='" + instancenum + '\'' +
                '}';
    }
}
