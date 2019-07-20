package com.binary.servermonitor.kafka_to_es.entity.agentbean.mysql;

import com.mchange.v2.cfg.PropertiesConfigSource;
import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/7/2
 */
@Repository
public class BinaryAgentMysqlConnectionNumberBean {
    /**
     *         获取当前连接数
     *         +-----------+-------------+
     *         | host      | count(host) |
     *         +-----------+-------------+
     *         | localhost |           1 |
     *         +-----------+-------------+
     *
     */
    private String hostIp;
    private String date;
    private String count;
    private String host;

    public String toJsonString(){
        return "{" +
                "\"hostIp\":\""   +  hostIp    + "\","  +
                "\"date\":\"" + date  +"\","  +
                "\"count\":\"" + count  +"\","  +
                "\"host\":\"" + host  + "\""  +
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
