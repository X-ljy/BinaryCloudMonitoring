package com.binary.servermonitor.kafka_to_es.entity.jvmbean;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/5/29
 */
@Repository
public class ClassLoadingInfoBean {
    private String host;
    private String date;
    private long totalLoadedClassCount;
    private long unloadedClassCount;
    private int loadedClassCount;

    public String toJsonString() {
        return "{" +
                "\"host\":\"" + host  + "\","  +
                "\"date\":\"" + date  + "\","  +
                "\"totalLoadedClassCount\":\"" + totalLoadedClassCount + "\","  +
                "\"unloadedClassCount\":\"" + unloadedClassCount + "\","  +
                "\"loadedClassCount\":\"" + loadedClassCount + "\""  +
                '}';
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getTotalLoadedClassCount() {
        return totalLoadedClassCount;
    }

    public void setTotalLoadedClassCount(long totalLoadedClassCount) {
        this.totalLoadedClassCount = totalLoadedClassCount;
    }

    public long getUnloadedClassCount() {
        return unloadedClassCount;
    }

    public void setUnloadedClassCount(long unloadedClassCount) {
        this.unloadedClassCount = unloadedClassCount;
    }

    public int getLoadedClassCount() {
        return loadedClassCount;
    }

    public void setLoadedClassCount(int loadedClassCount) {
        this.loadedClassCount = loadedClassCount;
    }
}
