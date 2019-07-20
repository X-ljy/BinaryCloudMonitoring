package com.binary.servermonitor.data_api.parameters;

public class Requestparameters {
    private  String accessKeySecret;
    private  String host = "https://api.chinac.com/";
    private  String action;
    private  String region;
    private  String id;
    private  String startTime;
    private  String endTime;
    private  String date;
    private  String version = "1.0";
    private  String accessKeyId;
    private  String method = "GET";
    private  String contentType = "application/json;charset=UTF-8";

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String toString() {
        return "Requestparameters{" +
                "accessKeySecret='" + accessKeySecret + '\'' +
                ", host='" + host + '\'' +
                ", action='" + action + '\'' +
                ", region='" + region + '\'' +
                ", id='" + id + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", date='" + date + '\'' +
                ", version='" + version + '\'' +
                ", accessKeyId='" + accessKeyId + '\'' +
                ", method='" + method + '\'' +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}
