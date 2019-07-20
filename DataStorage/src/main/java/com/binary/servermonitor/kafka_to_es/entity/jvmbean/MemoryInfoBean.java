package com.binary.servermonitor.kafka_to_es.entity.jvmbean;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/5/30
 */
@Repository
public class MemoryInfoBean {
    private String host;
    private String date;
    //Heap
    private long heapInit;
    private long heapMax;
    private long heapUsed;
    private long heapCommitted;
    private int heapUseRate;

    //NoHeap
    private long noHeapInit;
    private long noHeapMax;
    private long noHeapUsed;
    private long noHeapCommitted;
    private int noHeapUseRate;


    public String toJsonString(){
        return "{" +
                "\"host\":\"" + host  + "\","  +
                "\"date\":\"" + date  + "\","  +
                "\"heapInit\":\"" + heapInit + "\","  +
                "\"heapMax\":\"" + heapMax + "\","  +
                "\"heapUsed\":\"" + heapUsed + "\","  +
                "\"heapCommitted\":\"" + heapCommitted + "\","  +
                "\"heapUseRate\":\"" + heapUseRate + "\","  +
                "\"noHeapInit\":\"" + noHeapInit + "\","  +
                "\"noHeapMax\":\"" + noHeapMax + "\","  +
                "\"noHeapUsed\":\"" + noHeapUsed + "\","  +
                "\"noHeapCommitted\":\"" + noHeapCommitted + "\","  +
                "\"noHeapUseRate\":\"" + noHeapUseRate + "\""  +
                '}';
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getHeapInit() {
        return heapInit;
    }

    public void setHeapInit(long heapInit) {
        this.heapInit = heapInit;
    }

    public long getHeapMax() {
        return heapMax;
    }

    public void setHeapMax(long heapMax) {
        this.heapMax = heapMax;
    }

    public long getHeapUsed() {
        return heapUsed;
    }

    public void setHeapUsed(long heapUsed) {
        this.heapUsed = heapUsed;
    }

    public long getHeapCommitted() {
        return heapCommitted;
    }

    public void setHeapCommitted(long heapCommitted) {
        this.heapCommitted = heapCommitted;
    }

    public int getHeapUseRate() {
        return heapUseRate;
    }

    public void setHeapUseRate(int heapUseRate) {
        this.heapUseRate = heapUseRate;
    }

    public long getNoHeapInit() {
        return noHeapInit;
    }

    public void setNoHeapInit(long noHeapInit) {
        this.noHeapInit = noHeapInit;
    }

    public long getNoHeapMax() {
        return noHeapMax;
    }

    public void setNoHeapMax(long noHeapMax) {
        this.noHeapMax = noHeapMax;
    }

    public long getNoHeapUsed() {
        return noHeapUsed;
    }

    public void setNoHeapUsed(long noHeapUsed) {
        this.noHeapUsed = noHeapUsed;
    }

    public long getNoHeapCommitted() {
        return noHeapCommitted;
    }

    public void setNoHeapCommitted(long noHeapCommitted) {
        this.noHeapCommitted = noHeapCommitted;
    }

    public int getNoHeapUseRate() {
        return noHeapUseRate;
    }

    public void setNoHeapUseRate(int noHeapUseRate) {
        this.noHeapUseRate = noHeapUseRate;
    }
}
