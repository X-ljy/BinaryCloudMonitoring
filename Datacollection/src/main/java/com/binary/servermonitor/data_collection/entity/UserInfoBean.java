package com.binary.servermonitor.data_collection.entity;

import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author 夕
 * @date 2019/5/8
 */

@Repository
public class UserInfoBean {

    private String username;

    private String access_key_id;

    private String access_key_secret;

    private String region;

    private String hostID;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccess_key_id() {
        return access_key_id;
    }

    public void setAccess_key_id(String access_key_id) {
        this.access_key_id = access_key_id;
    }

    public String getAccess_key_secret() {
        return access_key_secret;
    }

    public void setAccess_key_secret(String access_key_secret) {
        this.access_key_secret = access_key_secret;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getHostID() {
        return hostID;
    }

    public void setHostID(String hostID) {
        this.hostID = hostID;
    }

    @Override
    public String toString() {
        return "UserInfoBean{" +
                "username='" + username + '\'' +
                ", access_key_id='" + access_key_id + '\'' +
                ", access_key_secret='" + access_key_secret + '\'' +
                ", region='" + region + '\'' +
                ", hostID='" + hostID + '\'' +
                '}';
    }
}
