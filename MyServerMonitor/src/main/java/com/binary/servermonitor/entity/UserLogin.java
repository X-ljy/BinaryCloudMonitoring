package com.binary.servermonitor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author 夕
 * @date 2019/4/28
 */

@Entity(name = "user_login")
public class UserLogin {

    @Id()
    private String username;

    @Column(name = "password",length = 25) //这是和数据表对应的一个列
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
