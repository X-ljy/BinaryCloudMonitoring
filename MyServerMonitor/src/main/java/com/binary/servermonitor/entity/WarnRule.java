package com.binary.servermonitor.entity;

import javax.persistence.*;

/**
 * @author Wei Peng
 */
@Entity
@Table(name = "user_warnRules")
public class WarnRule {
    @Id     //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;
    @Column(length = 25)
    private String username;
    @Column(length = 90)
    private String ruleName;
    @Column(length = 1000)
    private String strategy;
    @Column(length = 25)
    private String term;
    @Column(length = 25)
    private String cycle;
    @Column(length = 25)
    private String alarmTimes;
    @Column(length = 25)
    private String level;
    @Column(length = 25)
    private String noticeType;
    @Column(length = 25)
    private String hitCounts;
    @Column(length = 100)
    private String hostId;
    @Column(length = 25)
    private String creatTime;

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
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

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getAlarmTimes() {
        return alarmTimes;
    }

    public void setAlarmTimes(String alarmTimes) {
        this.alarmTimes = alarmTimes;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public String getHitCounts() {
        return hitCounts;
    }

    public void setHitCounts(String hitCounts) {
        this.hitCounts = hitCounts;
    }


    public WarnRule(String username, String ruleName, String strategy, String term, String cycle, String alarmTimes, String level, String noticeType, String hitCounts, String hostId, String creatTime) {
        this.username = username;
        this.ruleName = ruleName;
        this.strategy = strategy;
        this.term = term;
        this.cycle = cycle;
        this.alarmTimes = alarmTimes;
        this.level = level;
        this.noticeType = noticeType;
        this.hitCounts = hitCounts;
        this.hostId = hostId;
        this.creatTime = creatTime;
    }

    public WarnRule(){

    }


    @Override
    public String toString() {
        return "WarnRule{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", strategy='" + strategy + '\'' +
                ", term='" + term + '\'' +
                ", cycle='" + cycle + '\'' +
                ", alarmTimes='" + alarmTimes + '\'' +
                ", level='" + level + '\'' +
                ", noticeType='" + noticeType + '\'' +
                ", hitCounts='" + hitCounts + '\'' +
                ", hostId='" + hostId + '\'' +
                ", creatTime='" + creatTime + '\'' +
                '}';
    }
}
