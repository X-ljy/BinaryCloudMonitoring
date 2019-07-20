package com.binary.servermonitor.kafka_to_es.entity.agentbean;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/6/30
 */
@Repository
public class BinaryAgentProcInfoBean {
    /**
     *       • USER：该进程属于那个使用者账号的？
     *       • PID ：该进程的进程ID号。
     *       • %CPU：该进程使用掉的 CPU 资源百分比；
     *       • %MEM：该进程所占用的物理内存百分比；
     *       • VSZ ：该进程使用掉的虚拟内存量 (Kbytes)
     *       • RSS ：该进程占用的固定的内存量 (Kbytes)
     *       • TTY ：该进程是在那个终端机上面运作，若与终端机无关，则显示 ?，另外， tty1-tty6 是本机上面的登入者程序，若为 pts/0 等等的，则表示为由网络连接进主机的程序。
     *       • STAT：该程序目前的状态，主要的状态有：
     *         R ：该程序目前正在运作，或者是可被运作；
     *         S ：该程序目前正在睡眠当中 (可说是 idle 状态啦！)，但可被某些讯号(signal) 唤醒。
     *         T ：该程序目前正在侦测或者是停止了；
     *         Z ：该程序应该已经终止，但是其父程序却无法正常的终止他，造成 zombie (疆尸) 程序的状态
     *       • START：该进程被触发启动的时间；
     *       • TIME ：该进程实际使用 CPU 运作的时间。
     *       • COMMAND：该程序的实际指令为什么？
     *
     *       USER       PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
     *       root         2  0.0  0.0      0     0 ?        S    Jun15   0:00 [kthreadd]
     */
    private String hostIp;
    private String date;
    private String user;
    private String pid;
    private String cpu;
    private String mem;
    private String vsz;
    private String rss;
    private String tty;
    private String stat;
    private String startTime;
    private String command;

    public String toJsonString(){

        return "{" +
                "\"hostIp\":\""  +  hostIp    + "\","  +
                "\"date\":\"" + date  +"\","  +
                "\"user\":\"" + user  + "\"," +
                "\"tty\":\"" + tty  + "\"," +
                "\"pid\":\"" + pid  + "\"," +
                "\"cpu\":\"" + cpu  + "\"," +
                "\"mem\":\"" + mem  + "\"," +
                "\"vsz\":\"" + vsz  + "\"," +
                "\"rss\":\"" + rss  + "\"," +
                "\"start\":\"" + startTime  + "\"," +
                "\"command\":\"" + command  + "\"," +
                "\"stat\":\"" + stat  + "\""  +
                "}";
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getHostIp() {
        return hostIp;
    }

    public void setHostIp(String hostIp) {
        this.hostIp = hostIp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public String getTty() {
        return tty;
    }

    public void setTty(String tty) {
        this.tty = tty;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
}
