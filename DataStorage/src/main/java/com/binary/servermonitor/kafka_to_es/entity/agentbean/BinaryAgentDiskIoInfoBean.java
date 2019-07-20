package com.binary.servermonitor.kafka_to_es.entity.agentbean;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/6/30
 */
@Repository
public class BinaryAgentDiskIoInfoBean {
    /**
     * {"date": "2019-06-29 16:40:04", "data": {"vda": {"wkB": "15.41", "rmerge": "0.12", "rkB": "81.16", "avgqusz": "0.13", "avgrqsz": "74.95", "wio": "1.45", "await": "56.00", "util": "0.48", "rio": "1.13", "svctm": "1.86", "r_await": "114.59", "hostIp": "49.82.41.203", "date": "2019-06-29 16:40:04", "wmerge": "1.58", "w_await": "10.52"}, "vdb": {"wkB": "0.24", "rmerge": "0.00", "rkB": "0.01", "avgqusz": "0.00", "avgrqsz": "616.57", "wio": "0.00", "await": "47.43", "util": "0.00", "rio": "0.00", "svctm": "2.69", "r_await": "2.87", "hostIp": "49.82.41.203", "date": "2019-06-29 16:40:04", "wmerge": "0.03", "w_await": "63.92"}, "scd1": {"wkB": "0.00", "rmerge": "0.00", "rkB": "0.00", "avgqusz": "0.00", "avgrqsz": "8.00", "wio": "0.00", "await": "4.44", "util": "0.00", "rio": "0.00", "svctm": "4.44", "r_await": "4.44", "hostIp": "49.82.41.203", "date": "2019-06-29 16:40:04", "wmerge": "0.00", "w_await": "0.00"}}, "hostIp": "49.82.41.203"}
     *         rrqm/s:  每秒进行 merge 的读操作数目。即 rmerge/s
     *         wrqm/s:  每秒进行 merge 的写操作数目。即 wmerge/s
     *         r/s:  每秒完成的读 I/O 设备次数。即 rio/s
     *         w/s:  每秒完成的写 I/O 设备次数。即 wio/s
     *         rkB/s:  每秒读K字节数。是 rsect/s 的一半，因为每扇区大小为512字节。
     *         wkB/s:  每秒写K字节数。是 wsect/s 的一半。
     *         avgrq-sz:  平均每次设备I/O操作的数据大小 (扇区)。
     *         avgqu-sz:  平均I/O队列长度。
     *         await: 平均每次设备I/O操作的等待时间 (毫秒)。
     *         r_await:每个读操作平均所需的时间,不仅包括硬盘设备读操作的时间，还包括了在kernel队列中等待的时间。
     *         w_await:每个写操作平均所需的时间,不仅包括硬盘设备写操作的时间，还包括了在kernel队列中等待的时间。
     *         svctm: 平均每次设备I/O操作的服务时间 (毫秒)。
     *         %util:  一秒中有百分之多少的时间用于 I/O 操作，即被io消耗的cpu百分比
     */
    private String hostIp;
    private String date;
    private String deviceName;
    private String rrqm;
    private String wrqm;
    private String rio;
    private String wio;
    private String rkB;
    private String wkB;
    private String avgrqsz;
    private String avgqusz;
    private String await;
    private String r_await;
    private String w_await;
    private String svctm;
    private String util;

    public String toJsonString(){
        return "{" +
                "\"hostIp\":\""   +  hostIp    + "\","  +
                "\"date\":\"" + date  +"\","  +
                "\"deviceName\":\"" + deviceName  + "\"," +
                "\"rrqm\":\"" + rrqm  + "\"," +
                "\"wrqm\":\"" + wrqm  + "\"," +
                "\"rio\":\"" + rio  + "\"," +
                "\"wio\":\"" + wio  + "\"," +
                "\"rkB\":\"" + rkB  + "\"," +
                "\"wkB\":\"" + wkB  + "\"," +
                "\"avgrqsz\":\"" + avgrqsz  + "\"," +
                "\"avgqusz\":\"" + avgqusz  + "\"," +
                "\"await\":\"" + await  + "\"," +
                "\"r_await\":\"" + r_await  + "\"," +
                "\"w_await\":\"" + w_await  + "\"," +
                "\"svctm\":\"" + svctm  + "\"," +
                "\"util\":\"" + util  + "\""  +
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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getRrqm() {
        return rrqm;
    }

    public void setRrqm(String rrqm) {
        this.rrqm = rrqm;
    }

    public String getWrqm() {
        return wrqm;
    }

    public void setWrqm(String wrqm) {
        this.wrqm = wrqm;
    }

    public String getRio() {
        return rio;
    }

    public void setRio(String rio) {
        this.rio = rio;
    }

    public String getWio() {
        return wio;
    }

    public void setWio(String wio) {
        this.wio = wio;
    }

    public String getRkB() {
        return rkB;
    }

    public void setRkB(String rkB) {
        this.rkB = rkB;
    }

    public String getWkB() {
        return wkB;
    }

    public void setWkB(String wkB) {
        this.wkB = wkB;
    }

    public String getAvgrqsz() {
        return avgrqsz;
    }

    public void setAvgrqsz(String avgrqsz) {
        this.avgrqsz = avgrqsz;
    }

    public String getAvgqusz() {
        return avgqusz;
    }

    public void setAvgqusz(String avgqusz) {
        this.avgqusz = avgqusz;
    }

    public String getAwait() {
        return await;
    }

    public void setAwait(String await) {
        this.await = await;
    }

    public String getR_await() {
        return r_await;
    }

    public void setR_await(String r_await) {
        this.r_await = r_await;
    }

    public String getW_await() {
        return w_await;
    }

    public void setW_await(String w_await) {
        this.w_await = w_await;
    }

    public String getSvctm() {
        return svctm;
    }

    public void setSvctm(String svctm) {
        this.svctm = svctm;
    }

    public String getUtil() {
        return util;
    }

    public void setUtil(String util) {
        this.util = util;
    }
}
