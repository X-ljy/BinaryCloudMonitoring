package com.binary.servermonitor.kafka_to_es.entity.agentbean.mysql;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/7/2
 */

@Repository
public class BinaryAgentMysqlTableCacheBean {
    private String hostIp;
    private String date;
    private String Opened_tables;
    private String Open_tables;
    private String Open_table_definitions;
    private String Open_files;
    private String Opened_files;
    private String Opened_table_definitions;

    public String toJsonString(){
        return "{" +
                "\"hostIp\":\""   +  hostIp    + "\","  +
                "\"date\":\""   +  date    + "\","  +
                "\"Open_tables\":\"" + Open_tables  +"\","  +
                "\"Open_table_definitions\":\"" + Open_table_definitions  +"\","  +
                "\"Open_files\":\"" + Open_files  +"\","  +
                "\"Opened_files\":\"" + Opened_files  +"\","  +
                "\"Opened_table_definitions\":\"" + Opened_table_definitions  +"\","  +
                "\"Opened_tables\":\"" + Opened_tables  + "\""  +
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

    public String getOpened_tables() {
        return Opened_tables;
    }

    public void setOpened_tables(String opened_tables) {
        Opened_tables = opened_tables;
    }

    public String getOpen_tables() {
        return Open_tables;
    }

    public void setOpen_tables(String open_tables) {
        Open_tables = open_tables;
    }

    public String getOpen_table_definitions() {
        return Open_table_definitions;
    }

    public void setOpen_table_definitions(String open_table_definitions) {
        Open_table_definitions = open_table_definitions;
    }

    public String getOpen_files() {
        return Open_files;
    }

    public void setOpen_files(String open_files) {
        Open_files = open_files;
    }

    public String getOpened_files() {
        return Opened_files;
    }

    public void setOpened_files(String opened_files) {
        Opened_files = opened_files;
    }

    public String getOpened_table_definitions() {
        return Opened_table_definitions;
    }

    public void setOpened_table_definitions(String opened_table_definitions) {
        Opened_table_definitions = opened_table_definitions;
    }
}
