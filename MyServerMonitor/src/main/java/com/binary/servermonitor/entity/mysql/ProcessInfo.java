package com.binary.servermonitor.entity.mysql;

/**
 * @author Wei Peng
 */
public class ProcessInfo {

    private String id;
    private String host;
    private String info;
    private String date;
    private String state;
    private String command;
    private String user;
    private String time;
    private String db;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    @Override
    public String toString() {
        return "ProcessInfo{" +
                "id='" + id + '\'' +
                ", host='" + host + '\'' +
                ", info='" + info + '\'' +
                ", date='" + date + '\'' +
                ", state='" + state + '\'' +
                ", command='" + command + '\'' +
                ", user='" + user + '\'' +
                ", time='" + time + '\'' +
                ", db='" + db + '\'' +
                '}';
    }
}
