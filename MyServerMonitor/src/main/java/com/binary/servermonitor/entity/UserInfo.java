package com.binary.servermonitor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Wei Peng
 */
@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    @Column(length = 25,unique = true)
    private String username;
    @Column(length = 50)
    private String access_key_id;
    @Column(length = 50)
    private String access_key_secret;
    @Column(length = 1000)
    private String region;
    @Column(length = 500)
    private String compuretroom;

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

    public String getCompuretroom() {
        return compuretroom;
    }

    public void setCompuretroom(String compuretroom) {
        this.compuretroom = compuretroom;
    }

    public UserInfo(String username, String access_key_id, String access_key_secret, String region, String compuretroom) {
        this.username = username;
        this.access_key_id = access_key_id;
        this.access_key_secret = access_key_secret;
        this.region = region;
        this.compuretroom = compuretroom;
    }

    public UserInfo(){

    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "username='" + username + '\'' +
                ", access_key_id='" + access_key_id + '\'' +
                ", access_key_secret='" + access_key_secret + '\'' +
                ", region='" + region + '\'' +
                ", compuretroom='" + compuretroom + '\'' +
                '}';
    }
}
