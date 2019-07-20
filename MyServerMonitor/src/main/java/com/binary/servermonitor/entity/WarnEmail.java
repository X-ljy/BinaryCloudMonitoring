package com.binary.servermonitor.entity;

import javax.persistence.*;

/**
 * @author Wei Peng
 */
@Entity
@Table(name = "user_warnEmail")
public class WarnEmail {
    @Id     //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;
    @Column(length = 25)
    private String username;
    @Column(length = 25)
    private Integer ruleId;
    @Column(length = 25)
    private String email1;
    @Column(length = 25)
    private String email2;
    @Column(length = 25)
    private String email3;
    @Column(length = 25)
    private String email4;
    @Column(length = 25)
    private String email5;
    @Column(length = 25)
    private String email6;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public String getEmail4() {
        return email4;
    }

    public void setEmail4(String email4) {
        this.email4 = email4;
    }

    public String getEmail5() {
        return email5;
    }

    public void setEmail5(String email5) {
        this.email5 = email5;
    }

    public String getEmail6() {
        return email6;
    }

    public void setEmail6(String email6) {
        this.email6 = email6;
    }

    public WarnEmail(String username, Integer ruleId, String email1, String email2, String email3, String email4, String email5, String email6) {
        this.username = username;
        this.ruleId = ruleId;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.email4 = email4;
        this.email5 = email5;
        this.email6 = email6;
    }

    public WarnEmail() {

    }

    @Override
    public String toString() {
        return "WarnEmail{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", ruleId=" + ruleId +
                ", email1='" + email1 + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", email4='" + email4 + '\'' +
                ", email5='" + email5 + '\'' +
                ", email6='" + email6 + '\'' +
                '}';
    }
}