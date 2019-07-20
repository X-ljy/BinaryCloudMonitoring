package com.binary.servermonitor.kafka_to_es.entity;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/5/14
 */
@Repository
public class PublicipOutflowDataBean {

    private String id;
    private String date;
    private Double data;
    private String unit;

    public String toJsonString(){
        return "{" +
                "\"id\":\""   +  id    + "\","  +
                "\"date\":\"" + date  +"\","  +
                "\"data\":\"" + data  + "\"," +
                "\"unit\":\"" + unit  + "\""  +
                "}";
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getData() {
        return data;
    }

    public void setData(Double data) {
        this.data = data;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
