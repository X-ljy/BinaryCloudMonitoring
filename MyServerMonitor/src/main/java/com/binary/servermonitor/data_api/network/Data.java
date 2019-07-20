package com.binary.servermonitor.data_api.network;

import java.util.Arrays;

public class Data {
    private String Ip;
    private String[][] data;

    public String getIp() {
        return Ip;
    }

    public void setIp(String ip) {
        Ip = ip;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "Ip='" + Ip + '\'' +
                ", data=" + Arrays.deepToString(data) +
                '}';
    }
}
