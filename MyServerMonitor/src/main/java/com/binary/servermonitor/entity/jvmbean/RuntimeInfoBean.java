package com.binary.servermonitor.entity.jvmbean;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 夕
 * @date 2019/5/29
 */
@Repository
public class RuntimeInfoBean {

    private String host;
    private String date;
    private String startTime;
    private String endTime;
    private int size;

    public String toQueryString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"term\":{\"host\":\""+getHost()+"\"}}," +
                "{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}]," +
                "\"must_not\":[],\"should\":[]}}," +
                "\"from\":0,\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
