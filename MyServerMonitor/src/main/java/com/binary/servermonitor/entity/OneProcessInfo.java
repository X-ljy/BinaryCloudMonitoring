package com.binary.servermonitor.entity;

public class OneProcessInfo {

    private float cpu;
    private float mem;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getCpu() {
        return cpu;
    }

    public void setCpu(float cpu) {
        this.cpu = cpu;
    }

    public float getMem() {
        return mem;
    }

    public void setMem(float mem) {
        this.mem = mem;
    }

    @Override
    public String toString() {
        return "OneProcessInfo{" +
                "cpu=" + cpu +
                ", mem=" + mem +
                ", date='" + date + '\'' +
                '}';
    }
}
