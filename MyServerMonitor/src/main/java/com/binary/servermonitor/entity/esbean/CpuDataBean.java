package com.binary.servermonitor.entity.esbean;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/5/19
 */
@Repository
public class CpuDataBean {

    private String id;
    private String queryUrl;
    private String startTime;
    private String endTime;
    private int size;

    public String toJsonString(){

        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date.keyword\":{\"gte\":\""+getStartTime()+"\",\"lt\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"id.keyword\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date.keyword\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQueryUrl() {
        return queryUrl;
    }

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
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
