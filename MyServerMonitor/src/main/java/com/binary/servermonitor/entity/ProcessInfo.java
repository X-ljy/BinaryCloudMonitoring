package com.binary.servermonitor.entity;

public class ProcessInfo {

    private String pid;
    private String user;
    private String tty;
    private String cpu;
    private String mem;
    private String vsz;
    private String rss;
    private String start;
    private String command;
    private String stat;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTty() {
        return tty;
    }

    public void setTty(String tty) {
        this.tty = tty;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public String getVsz() {
        return vsz;
    }

    public void setVsz(String vsz) {
        this.vsz = vsz;
    }

    public String getRss() {
        return rss;
    }

    public void setRss(String rss) {
        this.rss = rss;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    @Override
    public String toString() {
        return "ProcessInfo{" +
                "pid='" + pid + '\'' +
                ", user='" + user + '\'' +
                ", tty='" + tty + '\'' +
                ", cpu='" + cpu + '\'' +
                ", mem='" + mem + '\'' +
                ", vsz='" + vsz + '\'' +
                ", rss='" + rss + '\'' +
                ", start='" + start + '\'' +
                ", command='" + command + '\'' +
                ", stat='" + stat + '\'' +
                '}';
    }
}
