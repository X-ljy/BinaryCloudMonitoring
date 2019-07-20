package com.binary.servermonitor.kafka_to_es.entity.jvmbean;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/5/29
 */
@Repository
public class CompilationInfoBean {

    private String host;
    private String date;
    private String compilationName;
    private long compilationTotalTime;

    public String toJsonString(){
        return "{" +
                "\"host\":\"" + host  + "\","  +
                "\"date\":\"" + date  + "\","  +
                "\"compilationName\":\"" + compilationName + "\","  +
                "\"compilationTotalTime\":\"" + compilationTotalTime + "\""  +
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

    public String getCompilationName() {
        return compilationName;
    }

    public void setCompilationName(String compilationName) {
        this.compilationName = compilationName;
    }

    public long getCompilationTotalTime() {
        return compilationTotalTime;
    }

    public void setCompilationTotalTime(long compilationTotalTime) {
        this.compilationTotalTime = compilationTotalTime;
    }
}
