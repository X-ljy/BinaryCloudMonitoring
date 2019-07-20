package com.binary.servermonitor.kafka_to_es.entity.agentbean.mysql;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/7/2
 */

@Repository
public class BinaryAgentMysqlprocesslistBean {
    /**
     * {
     * 	"date": "2019-07-02 13:25:10",
     * 	"data": {
     * 		"data": {
     * 			"info": " show processlist ",
     * 			"host": " localhost ",
     * 			"state": " starting ",
     * 			"command": " Query   ",
     * 			"user": " root ",
     * 			"time": " 0    ",
     * 			"db": "    ",
     * 			"id": " 939 "
     *                }    * 	},
     * 	"hostIp": "49.82.41.203"
     * }
     *    | Id  | User | Host      | db | Command | Time | State    | Info             |
     *    +-----+------+-----------+----+---------+------+----------+------------------+
     *    | 136 | root | localhost |    | Query   | 0    | starting | show processlist |
     *
     */

    private String hostIp;
    private String date;
    private String info;
    private String host;
    private String state;
    private String command;
    private String user;
    private String time;
    private String db;
    private String id;

    public String toJsonString(){
        return "{" +
                "\"hostIp\":\""   +  hostIp    + "\","  +
                "\"date\":\"" + date  +"\","  +
                "\"info\":\"" + info  + "\"," +
                "\"host\":\"" + host  + "\"," +
                "\"state\":\"" + state  + "\"," +
                "\"id\":\"" + id  + "\"," +
                "\"command\":\"" + command  + "\"," +
                "\"user\":\"" + user  + "\"," +
                "\"time\":\"" + time.replaceAll("\\s*", "")  + "\"," +
                "\"db\":\"" + db  + "\""  +
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
