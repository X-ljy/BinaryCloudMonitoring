package com.binary.servermonitor.kafka_to_es.entity.agentbean.mysql;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/7/2
 */
@Repository
public class BinaryAgentMysqlInnodbBufferBean {
    /**
     * mysql Innodb Buffer 命中率
     * {
     * 	"date": "2019-07-02 14:15:10",
     * 	"innodb_buffer_read_hits": 0.867,
     * 	"hostIp": "49.82.41.170"
     * }
     *
     */

    private String hostIp;
    private String date;
    private String innodb_buffer_read_hits;

    public String toJsonString(){
        return "{" +
                "\"hostIp\":\""   +  hostIp    + "\","  +
                "\"date\":\"" + date  +"\","  +
                "\"innodb_buffer_read_hits\":\"" + innodb_buffer_read_hits  + "\""  +
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

    public String getInnodb_buffer_read_hits() {
        return innodb_buffer_read_hits;
    }

    public void setInnodb_buffer_read_hits(String innodb_buffer_read_hits) {
        this.innodb_buffer_read_hits = innodb_buffer_read_hits;
    }
}
