package com.binary.servermonitor.entity.mysql;

public class ConnNumber {

    private String host;
    private String count;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ConnNumber{" +
                "host='" + host + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
