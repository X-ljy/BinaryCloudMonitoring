package com.binary.servermonitor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userRulesCycle")
public class RuleCycle {
    /**
     * 规则Id
     */
    @Id
    @Column(length = 25)
    private Integer rulesId;

    /**
     * 命中次数
     */
    @Column(length = 10)
    private Integer hits;

    /**
     * 告警次数
     */
    @Column(length = 10)
    private Integer noticeTime;

    public Integer getRulesId() {
        return rulesId;
    }

    public void setRulesId(Integer rulesId) {
        this.rulesId = rulesId;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Integer noticeTime) {
        this.noticeTime = noticeTime;
    }

    public RuleCycle(Integer rulesId, Integer hits, Integer noticeTime) {
        this.rulesId = rulesId;
        this.hits = hits;
        this.noticeTime = noticeTime;
    }

    public RuleCycle() {
    }

    @Override
    public String toString() {
        return "RuleCycle{" +
                "rulesId=" + rulesId +
                ", hits=" + hits +
                ", noticeTime=" + noticeTime +
                '}';
    }
}
