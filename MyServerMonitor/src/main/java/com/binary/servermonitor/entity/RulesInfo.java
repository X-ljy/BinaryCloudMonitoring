package com.binary.servermonitor.entity;

/**
 * @author Wei Peng
 */
public class RulesInfo {
    private Integer id;
    private String ruleName;
    private String creatIime;
    private String cycle;
    private String level;
    private String noticeType;
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getCreatIime() {
        return creatIime;
    }

    public void setCreatIime(String creatIime) {
        this.creatIime = creatIime;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
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

    @Override
    public String toString() {
        return "RulesInfo{" +
                "id=" + id +
                ", ruleName='" + ruleName + '\'' +
                ", creatIime='" + creatIime + '\'' +
                ", cycle='" + cycle + '\'' +
                ", level='" + level + '\'' +
                ", noticeType='" + noticeType + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
