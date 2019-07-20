package com.binary.servermonitor.kafka_to_es.entity.agentbean.mysql;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/7/2
 */

@Repository
public class BinaryAgentMysqlQpsBean {
    /**
     * 获取mysql qps
     */
    private String hostIp;
    private String date;
    private String qps;

    public String toJsonString(){
        return "{" +
                "\"hostIp\":\""   +  hostIp    + "\","  +
                "\"date\":\"" + date  +"\","  +
                "\"qps\":\"" + qps  + "\""  +
                "}";
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQps() {
        return qps;
    }

    public void setQps(String qps) {
        this.qps = qps;
    }
}
