package com.binary.servermonitor.kafka_to_es.entity.jvmbean;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/5/30
 */
@Repository
public class ThreadInfoBean {

    private String host;
    private String date;
    private int aliveThreadCount;
    private int peakThreadCount;
    private long totalStartedThreadCount;
    private int daemonThreadCount;
    private String allThreadInfo;
    private String deadlockedThreadInfo;

    public String toJsonString(){
        return "{" +
                "\"host\":\"" + host  + "\","  +
                "\"date\":\"" + date  + "\","  +
                "\"aliveThreadCount\":\"" + aliveThreadCount + "\","  +
                "\"peakThreadCount\":\"" + peakThreadCount + "\","  +
                "\"totalStartedThreadCount\":\"" + totalStartedThreadCount + "\","  +
                "\"daemonThreadCount\":\"" + daemonThreadCount + "\","  +
                "\"deadlockedThreadInfo\":\"" +  deadlockedThreadInfo + "\","  +
                "\"allThreadInfo\":" + allThreadInfo   +
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

    public int getAliveThreadCount() {
        return aliveThreadCount;
    }

    public long getTotalStartedThreadCount() {
        return totalStartedThreadCount;
    }

    public void setTotalStartedThreadCount(long totalStartedThreadCount) {
        this.totalStartedThreadCount = totalStartedThreadCount;
    }

    public void setAliveThreadCount(int aliveThreadCount) {
        this.aliveThreadCount = aliveThreadCount;
    }

    public int getPeakThreadCount() {
        return peakThreadCount;
    }

    public void setPeakThreadCount(int peakThreadCount) {
        this.peakThreadCount = peakThreadCount;
    }



    public int getDaemonThreadCount() {
        return daemonThreadCount;
    }

    public void setDaemonThreadCount(int daemonThreadCount) {
        this.daemonThreadCount = daemonThreadCount;
    }

    public String getAllThreadInfo() {
        return allThreadInfo;
    }

    public void setAllThreadInfo(String allThreadInfo) {
        this.allThreadInfo = allThreadInfo;
    }

    public String getDeadlockedThreadInfo() {
        return deadlockedThreadInfo;
    }

    public void setDeadlockedThreadInfo(String deadlockedThreadInfo) {
        this.deadlockedThreadInfo = deadlockedThreadInfo;
    }
}
