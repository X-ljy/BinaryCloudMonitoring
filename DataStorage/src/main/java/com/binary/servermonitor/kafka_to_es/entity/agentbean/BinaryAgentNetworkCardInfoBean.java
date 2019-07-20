package com.binary.servermonitor.kafka_to_es.entity.agentbean;

import org.springframework.stereotype.Repository;

/**
 * @author 夕
 * @date 2019/6/30
 */
@Repository
public class BinaryAgentNetworkCardInfoBean {
    /**
     *{"date": "2019-06-29 16:45:04", "data": {"br-a0cf4a964e38": {"iface": "br-a0cf4a964e38", "txkB": "0.00", "rxkB": "0.00", "rxcmp": "0.00", "rxpck": "0.00", "txpck": "0.00", "txmcst": "0.00", "txcmp": "0.00"}, "docker0": {"iface": "docker0", "txkB": "0.00", "rxkB": "0.00", "rxcmp": "0.00", "rxpck": "0.00", "txpck": "0.00", "txmcst": "0.00", "txcmp": "0.00"}, "lo": {"iface": "lo", "txkB": "0.00", "rxkB": "0.00", "rxcmp": "0.00", "rxpck": "0.00", "txpck": "0.00", "txmcst": "0.00", "txcmp": "0.00"}, "vethba5da46": {"iface": "vethba5da46", "txkB": "0.00", "rxkB": "0.00", "rxcmp": "0.00", "rxpck": "0.00", "txpck": "0.00", "txmcst": "0.00", "txcmp": "0.00"}, "br-6941d91b409e": {"iface": "br-6941d91b409e", "txkB": "0.00", "rxkB": "0.00", "rxcmp": "0.00", "rxpck": "0.00", "txpck": "0.00", "txmcst": "0.00", "txcmp": "0.00"}, "eth0": {"iface": "eth0", "txkB": "0.51", "rxkB": "1.82", "rxcmp": "0.00", "rxpck": "13.13", "txpck": "6.06", "txmcst": "0.00", "txcmp": "0.00"}}, "hostIp": "49.82.41.203"}
     * IFACE：就是网络设备的名称；
     *
     * rxpck/s：每秒钟接收到的包数目
     *
     * txpck/s：每秒钟发送出去的包数目
     *
     * rxbyt/s：每秒钟接收到的字节数
     *
     * txbyt/s：每秒钟发送出去的字节数
     *
     * rxcmp/s：每秒钟接收到的压缩包数目
     *
     * txcmp/s：每秒钟发送出去的压缩包数目
     *
     * txmcst/s：每秒钟接收到的多播包的包数目
     */

    private String hostIp;
    private String date;
    private String iface;
    private String rxpck;
    private String txpck;
    private String rxkB;
    private String txkB;
    private String rxcmp;
    private String txcmp;
    private String txmcst;

    public String toJsonString(){
        return "{" +
                "\"hostIp\":\""   +  hostIp    + "\","  +
                "\"date\":\"" + date  +"\","  +
                "\"iface\":\"" + iface  + "\"," +
                "\"rxpck\":\"" + rxpck  + "\"," +
                "\"txpck\":\"" + txpck  + "\"," +
                "\"rxkB\":\"" + rxkB  + "\"," +
                "\"txkB\":\"" + txkB  + "\"," +
                "\"rxcmp\":\"" + rxcmp  + "\"," +
                "\"txcmp\":\"" + txcmp  + "\"," +
                "\"txmcst\":\"" + txmcst  + "\""  +
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

    public String getIface() {
        return iface;
    }

    public void setIface(String iface) {
        this.iface = iface;
    }

    public String getRxpck() {
        return rxpck;
    }

    public void setRxpck(String rxpck) {
        this.rxpck = rxpck;
    }

    public String getTxpck() {
        return txpck;
    }

    public void setTxpck(String txpck) {
        this.txpck = txpck;
    }

    public String getRxkB() {
        return rxkB;
    }

    public void setRxkB(String rxkB) {
        this.rxkB = rxkB;
    }

    public String getTxkB() {
        return txkB;
    }

    public void setTxkB(String txkB) {
        this.txkB = txkB;
    }

    public String getRxcmp() {
        return rxcmp;
    }

    public void setRxcmp(String rxcmp) {
        this.rxcmp = rxcmp;
    }

    public String getTxcmp() {
        return txcmp;
    }

    public void setTxcmp(String txcmp) {
        this.txcmp = txcmp;
    }

    public String getTxmcst() {
        return txmcst;
    }

    public void setTxmcst(String txmcst) {
        this.txmcst = txmcst;
    }
}
