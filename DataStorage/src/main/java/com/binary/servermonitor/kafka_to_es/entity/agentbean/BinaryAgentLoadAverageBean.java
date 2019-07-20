package com.binary.servermonitor.kafka_to_es.entity.agentbean;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/6/30
 */
@Repository
public class BinaryAgentLoadAverageBean {
    /**
     * {"date": "2019-06-29 17:05:10", "fifteenLoadAverage": "0.05", "oneLoadAverage": "0.00", "fiveLoadAverage": "0.01", "hostIp": "49.82.41.170"}
     * 平均负载
     * 1分钟
     * 5分钟
     * 15分钟
     */
    private String hostIp;
    private String date;
    private String oneLoadAverage;
    private String fiveLoadAverage;
    private String fifteenLoadAverage;

    public String toJsonString(){
        return "{" +
                "\"hostIp\":\""   +  hostIp    + "\","  +
                "\"date\":\"" + date  +"\","  +
                "\"oneLoadAverage\":\"" + oneLoadAverage  + "\"," +
                "\"fiveLoadAverage\":\"" + fiveLoadAverage  + "\"," +
                "\"fifteenLoadAverage\":\"" + fifteenLoadAverage  + "\""  +
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

    public String getOneLoadAverage() {
        return oneLoadAverage;
    }

    public void setOneLoadAverage(String oneLoadAverage) {
        this.oneLoadAverage = oneLoadAverage;
    }

    public String getFiveLoadAverage() {
        return fiveLoadAverage;
    }

    public void setFiveLoadAverage(String fiveLoadAverage) {
        this.fiveLoadAverage = fiveLoadAverage;
    }

    public String getFifteenLoadAverage() {
        return fifteenLoadAverage;
    }

    public void setFifteenLoadAverage(String fifteenLoadAverage) {
        this.fifteenLoadAverage = fifteenLoadAverage;
    }
}
