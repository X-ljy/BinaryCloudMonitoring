package com.binary.servermonitor.kafka_to_es.entity;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/5/13
 */
@Repository
public class ReadIopsDataBean {

    private String id;

    private String tag1;
    private double data1;
    private String date1;

    private String tag2;
    private double data2;
    private String date2;

    private String unit;

    public String toJsonString(){

        return "{" +
                "\"id\":\""   +  id    + "\","  +

                "\"data\":{"  +
                "\"tag1\":{"  +  "\"data1\":\"" + data1 + "\","
                +  "\"date1\":\"" + date1 + "\""
                + "},"  +
                "\"tag2\":{"  +  "\"data2\":\"" + data2 + "\","
                +  "\"date2\":\"" + date2 + "\""
                + "}"  +
                "},"+
                "\"unit\":\"" + unit  + "\""  +
                "}";

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public double getData1() {
        return data1;
    }

    public void setData1(double data1) {
        this.data1 = data1;
    }

    public String getDate1() {
        return date1;
    }

    public void setDate1(String date1) {
        this.date1 = date1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public double getData2() {
        return data2;
    }

    public void setData2(double data2) {
        this.data2 = data2;
    }

    public String getDate2() {
        return date2;
    }

    public void setDate2(String date2) {
        this.date2 = date2;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

}
