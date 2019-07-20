package com.binary.servermonitor.data_collection.entity;

/**
 * @author 夕
 * @date 2019/4/30
 */
public class KafkaTopicBean {

    private String topicName;       // topic 名称
    private Integer partition;      // partition 分区数量
    private Integer replication;    // replication 副本数量
    private String brokerlist;      //kafka 集群 "10.10.44.127:9092,10.10.44.128:9092,10.10.44.129:9092"


    public String getBrokerlist() {
        return brokerlist;
    }
    public void setBrokerlist(String brokerlist) {
        this.brokerlist = brokerlist;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Integer getPartition() {
        return partition;
    }

    public void setPartition(Integer partition) {
        this.partition = partition;
    }

    public Integer getReplication() {
        return replication;
    }

    public void setReplication(Integer replication) {
        this.replication = replication;
    }


    @Override
    public String toString() {
        return "KafkaTopicBean{" +
                "topicName='" + topicName + '\'' +
                ", partition=" + partition +
                ", replication=" + replication +
                ", brokerlist='" + brokerlist + '\'' +
                '}';
    }
}