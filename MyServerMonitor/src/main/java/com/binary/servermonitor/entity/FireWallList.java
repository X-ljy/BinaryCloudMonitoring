package com.binary.servermonitor.entity;

/**
 * @author Wei Peng
 */
public class FireWallList {
    private String id;
    private String name;
    private String ddescription;
    private String creatTime;
    private String type;
    private String userId;

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

    public String getDdescription() {
        return ddescription;
    }

    public void setDdescription(String ddescription) {
        this.ddescription = ddescription;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "FireWallList{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ddescription='" + ddescription + '\'' +
                ", creatTime='" + creatTime + '\'' +
                ", type='" + type + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
