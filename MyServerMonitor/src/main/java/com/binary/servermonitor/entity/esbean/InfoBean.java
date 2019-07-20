package com.binary.servermonitor.entity.esbean;

/**
 * @author Wei Peng
 */
public class InfoBean {
    private String id;
    private String queryUrl;
    private String startTime;
    private String endTime;
    private int size;

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

    public String toJsonString(){

        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lt\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }
}
