package com.binary.servermonitor.kafka_to_es.entity.agentbean;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/6/30
 */
@Repository
public class BinaryAgentOnlineUsersBean {
    /**
     *     获取在线用户信息
     *     USER     TTY      FROM             LOGIN@   IDLE                   JCPU                           PCPU            WHAT
     *     root     pts/1    121.69.12.189    10:05   19:59                   1.08s                         1.07s           python
     *                                              用户空闲时间    和终端连接所有进程占用时间        当前进程占用时间    操作命令
     */

    private String hostIp;
    private String date;
    private String user;
    private String tty;
    private String from;
    private String login;
    private String idle;
    private String jcpu;
    private String pcpu;
    private String what;

    public String toJsonString(){
        return "{" +
                "\"hostIp\":\""   +  hostIp    + "\","  +
                "\"date\":\"" + date  +"\","  +
                "\"user\":\"" + user  + "\"," +
                "\"tty\":\"" + tty  + "\"," +
                "\"from\":\"" + from  + "\"," +
                "\"login\":\"" + login  + "\"," +
                "\"idle\":\"" + idle  + "\"," +
                "\"jcpu\":\"" + jcpu  + "\"," +
                "\"pcpu\":\"" + pcpu  + "\"," +
                "\"what\":\"" + what  + "\""  +
                "}";
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

    public String getTty() {
        return tty;
    }

    public void setTty(String tty) {
        this.tty = tty;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getIdle() {
        return idle;
    }

    public void setIdle(String idle) {
        this.idle = idle;
    }

    public String getJcpu() {
        return jcpu;
    }

    public void setJcpu(String jcpu) {
        this.jcpu = jcpu;
    }

    public String getPcpu() {
        return pcpu;
    }

    public void setPcpu(String pcpu) {
        this.pcpu = pcpu;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }
}
