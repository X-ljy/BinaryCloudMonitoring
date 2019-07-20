package com.binary.servermonitor.kafka_to_es.entity.agentbean.mysql;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/7/2
 */

@Repository
public class BinaryAgentMysqlQueryCacheBean {

    /**
     *mysql Query Cache 命中率
     *{
     * 	"date": "2019-07-02 14:15:10",
     * 	"Query_cache_hits": 1.0,
     * 	"hostIp": "49.82.41.170"
     * }
     */
    private String hostIp;
    private String date;
    private String Query_cache_hits;

    public String toJsonString(){
        return "{" +
                "\"hostIp\":\""   +  hostIp    + "\","  +
                "\"date\":\"" + date  +"\","  +
                "\"Query_cache_hits\":\"" + Query_cache_hits  + "\""  +
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

    public String getQuery_cache_hits() {
        return Query_cache_hits;
    }

    public void setQuery_cache_hits(String query_cache_hits) {
        Query_cache_hits = query_cache_hits;
    }
}
