package com.binary.servermonitor.kafka_to_es.entity.agentbean.mysql;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/7/2
 */

@Repository
public class BinaryAgentMysqlKeyBufferBean {

    /**
     * 获取mysql Key Buffer 命中率
     * {
     * 	"date": "2019-07-02 13:50:08",
     * 	"key_buffer_write_hits": 0.0,
     * 	"key_buffer_read_hits": 0.996,
     * 	"hostIp": "49.82.41.203"
     * }
     */

    private String hostIp;
    private String date;
    private String key_buffer_write_hits;
    private String key_buffer_read_hits;

    public String toJsonString(){
        return "{" +
                "\"hostIp\":\""   +  hostIp    + "\","  +
                "\"date\":\"" + date  +"\","  +
                "\"key_buffer_read_hits\":\"" + key_buffer_read_hits  +"\","  +
                "\"key_buffer_write_hits\":\"" + key_buffer_write_hits  + "\""  +
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

    public String getKey_buffer_write_hits() {
        return key_buffer_write_hits;
    }

    public void setKey_buffer_write_hits(String key_buffer_write_hits) {
        this.key_buffer_write_hits = key_buffer_write_hits;
    }

    public String getKey_buffer_read_hits() {
        return key_buffer_read_hits;
    }

    public void setKey_buffer_read_hits(String key_buffer_read_hits) {
        this.key_buffer_read_hits = key_buffer_read_hits;
    }
}
