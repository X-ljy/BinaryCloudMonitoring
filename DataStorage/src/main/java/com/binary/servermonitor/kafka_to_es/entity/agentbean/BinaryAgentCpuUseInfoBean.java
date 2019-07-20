package com.binary.servermonitor.kafka_to_es.entity.agentbean;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/6/30
 */
@Repository
public class BinaryAgentCpuUseInfoBean {
    /**
     * {"ni": "0.0", "sy": "0.0", "hi": "0.0", "si": "0.0", "wa": "0.0", "hostIp": "49.82.41.203", "date": "2019-06-29 16:40:06", "id": 100.0, "us": "0.0", "st": "0.0"}
     * us — 用户空间占用CPU的百分比。
     * sy — 内核空间占用CPU的百分比。
     * ni — 改变过优先级的进程占用CPU的百分比
     * id — 空闲CPU百分比
     * wa — IO等待占用CPU的百分比
     * hi — 硬中断（Hardware IRQ）占用CPU的百分比
     * si — 软中断（Software Interrupts）占用CPU的百分比
     */
    private String hostIp;
    private String date;
    private String us;
    private String sy;
    private String ni;
    private String id;
    private String wa;
    private String hi;
    private String si;
    private String st;

    public String toJsonString(){
        return "{" +
                "\"hostIp\":\""   +  hostIp    + "\","  +
                "\"date\":\"" + date  +"\","  +
                "\"us\":\"" + us  + "\"," +
                "\"sy\":\"" + sy  + "\"," +
                "\"ni\":\"" + ni  + "\"," +
                "\"id\":\"" + id  + "\"," +
                "\"wa\":\"" + wa  + "\"," +
                "\"hi\":\"" + hi  + "\"," +
                "\"st\":\"" + st  + "\"," +
                "\"si\":\"" + si  + "\""  +
                "}";
    }

    public String getSt() {
        return st;
    }

    public void setSt(String st) {
        this.st = st;
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

    public String getUs() {
        return us;
    }

    public void setUs(String us) {
        this.us = us;
    }

    public String getSy() {
        return sy;
    }

    public void setSy(String sy) {
        this.sy = sy;
    }

    public String getNi() {
        return ni;
    }

    public void setNi(String ni) {
        this.ni = ni;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWa() {
        return wa;
    }

    public void setWa(String wa) {
        this.wa = wa;
    }

    public String getHi() {
        return hi;
    }

    public void setHi(String hi) {
        this.hi = hi;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }
}
