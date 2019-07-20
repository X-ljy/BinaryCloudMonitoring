package com.binary.servermonitor.kafka_to_es.entity.agentbean.mysql;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/7/2
 */

@Repository
public class BinaryAgentMysqlThreadCacheBean {
    /**
     * #mysql Thread Cache 命中率
     * {
     * 	"date": "2019-07-02 13:25:10",
     * 	"Thread_cache_hits": 0.20999999999999996,
     * 	"hostIp": "49.82.41.203"
     * }
     */
    private String hostIp;
    private String date;
    private String Thread_cache_hits;

    public String toJsonString(){
        return "{" +
                "\"hostIp\":\""   +  hostIp    + "\","  +
                "\"date\":\"" + date  +"\","  +
                "\"Thread_cache_hits\":\"" + Thread_cache_hits  + "\""  +
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

    public String getThread_cache_hits() {
        return Thread_cache_hits;
    }

    public void setThread_cache_hits(String thread_cache_hits) {
        Thread_cache_hits = thread_cache_hits;
    }
}
