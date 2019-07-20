package com.binary.servermonitor.data_api.network;

import java.util.Arrays;

public class Ip {

    private String Unit;
    private Integer Interval;
    private Integer size = 2;
    private Data[] data = new Data[size];

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public Integer getInterval() {
        return Interval;
    }

    public void setInterval(Integer interval) {
        Interval = interval;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Data[] getData() {
        return data;
    }

    public void setData(Data[] data) {
        this.data = data;
    }

//    public Ip(String unit, Integer interval, Integer size, Data[] data) {
//        Unit = unit;
//        Interval = interval;
//        this.size = size;
//        this.data = data;
//    }

    @Override
    public String toString() {
        return "Ip{" +
                "Unit='" + Unit + '\'' +
                ", Interval=" + Interval +
                ", size=" + size +
                ", data=" + Arrays.deepToString(data) +
                '}';
    }
}
