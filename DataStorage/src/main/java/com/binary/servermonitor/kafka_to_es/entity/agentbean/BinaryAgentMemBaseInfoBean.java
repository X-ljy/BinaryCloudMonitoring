package com.binary.servermonitor.kafka_to_es.entity.agentbean;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/6/30
 */
@Repository
public class BinaryAgentMemBaseInfoBean {
    /**
     * {"date": "2019-06-29 17:00:08", "data": {"swapTotal": "0", "memFree": "77956", "memTotal": "944212", "swapCache": "76036", "swapUsed": "0", "hostIp": "49.82.41.170", "date": "2019-06-29 17:00:08", "memUsed": "653476", "memCache": "212812", "swapFree": "0"}, "hostIp": "49.82.41.170"}
     *         memTotal — 物理内存总量
     *         memUsed — 使用中的内存总量
     *         memFree — 空闲内存总量
     *         memCache — 缓存的内存量
     *
     *         swapTotal — 交换区总量
     *         swapUsed — 使用的交换区总量
     *         swapFree — 空闲交换区总量
     *         swapCache — 缓冲的交换区总量
     */
    private String hostIp;
    private String date;
    private String memTotal;
    private String memUsed;
    private String memFree;
    private String memCache;
    private String swapTotal;
    private String swapUsed;
    private String swapFree;
    private String swapCache;

    public String toJsonString(){
        return "{" +
                "\"hostIp\":\""   +  hostIp    + "\","  +
                "\"date\":\"" + date  +"\","  +
                "\"memTotal\":\"" + memTotal  + "\"," +
                "\"memUsed\":\"" + memUsed  + "\"," +
                "\"memFree\":\"" + memFree  + "\"," +
                "\"memCache\":\"" + memCache  + "\"," +
                "\"swapTotal\":\"" + swapTotal  + "\"," +
                "\"swapUsed\":\"" + swapUsed  + "\"," +
                "\"swapFree\":\"" + swapFree  + "\"," +
                "\"swapCache\":\"" + swapCache  + "\""  +
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

    public String getMemTotal() {
        return memTotal;
    }

    public void setMemTotal(String memTotal) {
        this.memTotal = memTotal;
    }

    public String getMemUsed() {
        return memUsed;
    }

    public void setMemUsed(String memUsed) {
        this.memUsed = memUsed;
    }

    public String getMemFree() {
        return memFree;
    }

    public void setMemFree(String memFree) {
        this.memFree = memFree;
    }

    public String getMemCache() {
        return memCache;
    }

    public void setMemCache(String memCache) {
        this.memCache = memCache;
    }

    public String getSwapTotal() {
        return swapTotal;
    }

    public void setSwapTotal(String swapTotal) {
        this.swapTotal = swapTotal;
    }

    public String getSwapUsed() {
        return swapUsed;
    }

    public void setSwapUsed(String swapUsed) {
        this.swapUsed = swapUsed;
    }

    public String getSwapFree() {
        return swapFree;
    }

    public void setSwapFree(String swapFree) {
        this.swapFree = swapFree;
    }

    public String getSwapCache() {
        return swapCache;
    }

    public void setSwapCache(String swapCache) {
        this.swapCache = swapCache;
    }
}
