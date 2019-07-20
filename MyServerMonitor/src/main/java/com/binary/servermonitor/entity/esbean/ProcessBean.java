package com.binary.servermonitor.entity.esbean;

/**
 * @author Wei Peng
 */
public class ProcessBean {
    private String id;
    private String queryUrl;
    private String startTime;
    private String endTime;
    private int size;
    private String pid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public String toJsonString(){

        return "{\"query\":{\"bool\":{\"must\":[{\"term\":{\"hostIp.keyword\":\""+ getId() +"\"}}," +
                "{\"range\":{\"date.keyword\":{\"gte\":\""+ getStartTime() +"\",\"lte\":\"" + getEndTime() + "\"}}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0,\"size\":"+ getSize() +",\"sort\":[],\"aggs\":{}}";
    }

    public String toOneProcJsonString(){

        return "{\"query\":{\"bool\":{\"must\":[{\"term\":{\"hostIp.keyword\":\""+ getId() +"\"}}," +
                "{\"term\":{\"pid.keyword\":\""+ getPid() +"\"}},{\"range\":{\"date.keyword\":{\"gte\":\""+ getStartTime() +"\",\"lte\":\"" + getEndTime() + "\"}}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0,\"size\":"+ getSize() +",\"sort\":[{\"date.keyword\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }


}
