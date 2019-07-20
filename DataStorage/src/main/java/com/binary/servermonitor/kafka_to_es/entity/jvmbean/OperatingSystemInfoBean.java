package com.binary.servermonitor.kafka_to_es.entity.jvmbean;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/5/29
 */
@Repository
public class OperatingSystemInfoBean {

    private String host;
    private String date;
    private String osName;
    private String osVersion;
    private String osArch;
    private int osAvailableProcessors;
    private long totalPhysicalMemory;
    private long usedPhysicalMemorySize;
    private long freePhysicalMemory;
    private long totalSwapSpaceSize;
    private long usedSwapSpaceSize;
    private long freeSwapSpaceSize;
    private double cpuUseRate;

    public String toJsonString(){

        return "{" +
                "\"host\":\"" + host  + "\","  +
                "\"date\":\"" + date  + "\","  +
                "\"osName\":\"" + osName + "\","  +
                "\"osVersion\":\"" + osVersion + "\","  +
                "\"osArch\":\"" + osArch + "\","  +
                "\"osAvailableProcessors\":\"" + osAvailableProcessors + "\","  +
                "\"totalPhysicalMemory\":\"" + totalPhysicalMemory + "\","  +
                "\"usedPhysicalMemorySize\":\"" + usedPhysicalMemorySize + "\","  +
                "\"freePhysicalMemory\":\"" + freePhysicalMemory + "\","  +
                "\"totalSwapSpaceSize\":\"" + totalSwapSpaceSize + "\","  +
                "\"usedSwapSpaceSize\":\"" + usedSwapSpaceSize + "\","  +
                "\"freeSwapSpaceSize\":\"" + freeSwapSpaceSize + "\","  +
                "\"cpuUseRate\":\"" + cpuUseRate + "\""  +
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

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getOsArch() {
        return osArch;
    }

    public void setOsArch(String osArch) {
        this.osArch = osArch;
    }

    public int getOsAvailableProcessors() {
        return osAvailableProcessors;
    }

    public void setOsAvailableProcessors(int osAvailableProcessors) {
        this.osAvailableProcessors = osAvailableProcessors;
    }

    public long getTotalPhysicalMemory() {
        return totalPhysicalMemory;
    }

    public void setTotalPhysicalMemory(long totalPhysicalMemory) {
        this.totalPhysicalMemory = totalPhysicalMemory;
    }

    public long getUsedPhysicalMemorySize() {
        return usedPhysicalMemorySize;
    }

    public void setUsedPhysicalMemorySize(long usedPhysicalMemorySize) {
        this.usedPhysicalMemorySize = usedPhysicalMemorySize;
    }

    public long getFreePhysicalMemory() {
        return freePhysicalMemory;
    }

    public void setFreePhysicalMemory(long freePhysicalMemory) {
        this.freePhysicalMemory = freePhysicalMemory;
    }

    public long getTotalSwapSpaceSize() {
        return totalSwapSpaceSize;
    }

    public void setTotalSwapSpaceSize(long totalSwapSpaceSize) {
        this.totalSwapSpaceSize = totalSwapSpaceSize;
    }

    public long getUsedSwapSpaceSize() {
        return usedSwapSpaceSize;
    }

    public void setUsedSwapSpaceSize(long usedSwapSpaceSize) {
        this.usedSwapSpaceSize = usedSwapSpaceSize;
    }

    public long getFreeSwapSpaceSize() {
        return freeSwapSpaceSize;
    }

    public void setFreeSwapSpaceSize(long freeSwapSpaceSize) {
        this.freeSwapSpaceSize = freeSwapSpaceSize;
    }

    public double getCpuUseRate() {
        return cpuUseRate;
    }

    public void setCpuUseRate(double cpuUseRate) {
        this.cpuUseRate = cpuUseRate;
    }
}
