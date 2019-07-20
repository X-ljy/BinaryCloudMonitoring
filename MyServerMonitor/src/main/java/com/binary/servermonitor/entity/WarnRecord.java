package com.binary.servermonitor.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_warnRecord")
public class WarnRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;
    @Column(length = 20)
    private Integer ruleId;
    @Column(length = 25)
    private String username;
    @Column(length = 100)
    private String ruleName;
    @Column(length = 50)
    private String warnTime;
    @Column(length = 500)
    private String warnReason;

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(String warnTime) {
        this.warnTime = warnTime;
    }

    public String getWarnReason() {
        return warnReason;
    }

    public void setWarnReason(String warnReason) {
        this.warnReason = warnReason;
    }

    public WarnRecord(Integer ruleId, String username, String ruleName, String warnTime, String warnReason) {
        this.ruleId = ruleId;
        this.username = username;
        this.ruleName = ruleName;
        this.warnTime = warnTime;
        this.warnReason = warnReason;
    }

    public WarnRecord() {

    }

    @Override
    public String toString() {
        return "WarnRecord{" +
                "id=" + id +
                ", ruleId=" + ruleId +
                ", username='" + username + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", warnTime='" + warnTime + '\'' +
                ", warnReason='" + warnReason + '\'' +
                '}';
    }


}
