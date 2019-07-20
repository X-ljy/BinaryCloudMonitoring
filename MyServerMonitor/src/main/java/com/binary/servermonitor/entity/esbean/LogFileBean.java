package com.binary.servermonitor.entity.esbean;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/5/22
 */
@Repository
public class LogFileBean {

    private int length = 11;
    private String id;
    private String queryUrl;
    private String startTime;
    private String endTime;
    private int size;


    private String pid;

    //获取当天公有多少进程
    public String toProcIdJsonString(){

        return "{\"query\":{\"bool\":{\"must\":[{\"term\":{\"id\":\""+getId()+"\"}}," +
                "{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":0,\"sort\":[]," +
                "\"aggs\":{\"pid\":{\"terms\":{\"field\":\"pid\"," +
                "\"size\":"+getSize()+"}}}}";

    }

    //获取当天某个进程的所有数据
    public String toProcPidJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"id\":\""+getId()+"\"}},{\"term\":{\"pid\":\""+getPid()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+",\"sort\":[]," +
                "\"aggs\":{}}";
    }

    public String toCpuJsonString(){

        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lt\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toDiskInfoJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toDiskIoInfoJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toMemeryJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toPublicInflowJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"term\":{\"id\":\""+getId()+"\"}}," +
                "{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toPublicOutflowJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"term\":{\"id\":\""+getId()+"\"}}," +
                "{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toReadIoJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"term\":{\"id\":\""+getId()+"\"}}," +
                "{\"range\":{\"data.tag1.date1\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"range\":{\"data.tag2.date2\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"data.tag1.date1\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toReadIopsJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"term\":{\"id\":\""+getId()+"\"}}," +
                "{\"range\":{\"data.tag1.date1\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"range\":{\"data.tag2.date2\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"data.tag1.date1\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toAverageJsonString(){

        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toWriteIoJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"term\":{\"id\":\""+getId()+"\"}}," +
                "{\"range\":{\"data.tag1.date1\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"range\":{\"data.tag2.date2\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"data.tag1.date1\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toWriteIopsJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"term\":{\"id\":\""+getId()+"\"}}," +
                "{\"range\":{\"data.tag1.date1\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"range\":{\"data.tag2.date2\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"data.tag1.date1\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toNetworkCardJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toOnlineUserJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }


    public String toProcJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date.keyword\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp.keyword\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date.keyword\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toMysqlConnectionNumbeJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toMysqlInnodbBufferJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toMysqlKeyBufferJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toMysqlProcessListJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toMysqlQPSJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }
    public String toMysqlQueryCacheJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toMysqlTableCacheJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toMysqlThreadCacheJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }

    public String toMysqlTPSJsonString(){
        return "{\"query\":{\"bool\":{\"must\":[{\"range\":{\"date\":{\"gte\":\""+getStartTime()+"\",\"lte\":\""+getEndTime()+"\"}}}," +
                "{\"term\":{\"hostIp\":\""+getId()+"\"}}]," +
                "\"must_not\":[],\"should\":[]}},\"from\":0," +
                "\"size\":"+getSize()+"," +
                "\"sort\":[{\"date\":{\"order\":\"desc\"}}],\"aggs\":{}}";
    }


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
}
