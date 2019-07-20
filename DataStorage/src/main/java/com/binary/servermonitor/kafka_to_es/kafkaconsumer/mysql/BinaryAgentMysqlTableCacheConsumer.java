package com.binary.servermonitor.kafka_to_es.kafkaconsumer.mysql;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.kafka_to_es.common.IndexList;
import com.binary.servermonitor.kafka_to_es.entity.agentbean.mysql.BinaryAgentMysqlQueryCacheBean;
import com.binary.servermonitor.kafka_to_es.entity.agentbean.mysql.BinaryAgentMysqlTableCacheBean;
import com.binary.servermonitor.kafka_to_es.util.EsUtils;
import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author 夕
 * @date 2019/7/2
 */
@Service
public class BinaryAgentMysqlTableCacheConsumer extends Thread{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private String topic;
    private String zookeeperConnect;
    private String groupId;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getZookeeperConnect() {
        return zookeeperConnect;
    }

    public void setZookeeperConnect(String zookeeperConnect) {
        this.zookeeperConnect = zookeeperConnect;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Autowired
    BinaryAgentMysqlTableCacheBean tableCacheBean;

    @Override
    public void run() {
        ConsumerConnector consumer = createConsumer();
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, 1); // 一次从主题中获取一个数据
        Map<String, List<KafkaStream<byte[], byte[]>>>  messageStreams = consumer.createMessageStreams(topicCountMap);
        KafkaStream<byte[], byte[]> stream = messageStreams.get(topic).get(0);// 获取每次接收到的这个数据
        ConsumerIterator<byte[], byte[]> iterator =  stream.iterator();
        while(iterator.hasNext()){
            try {
                String message = new String(iterator.next().message());
                JSONObject jsonObject = JSON.parseObject(message);
                tableCacheBean.setHostIp(jsonObject.getString("hostIp"));
                tableCacheBean.setDate(jsonObject.getString("date"));
                tableCacheBean.setOpened_tables(jsonObject.getString("Opened_tables"));
                tableCacheBean.setOpen_tables(jsonObject.getString("Open_tables"));
                tableCacheBean.setOpen_table_definitions(jsonObject.getString("Open_table_definitions"));
                tableCacheBean.setOpen_files(jsonObject.getString("Open_files"));
                tableCacheBean.setOpened_files(jsonObject.getString("Opened_files"));
                tableCacheBean.setOpened_table_definitions(jsonObject.getString("Opened_table_definitions"));

                EsUtils.sendDataToIndex(IndexList.binaryagentmysqltablecacheindex,tableCacheBean.toJsonString());

            } catch (Exception e) {
                logger.error("BinaryAgentMysqlTableCacheConsumer  :  " + e.getMessage());
            }

        }
    }

    private ConsumerConnector createConsumer() {
        Properties properties = new Properties();
        properties.put("zookeeper.connect", zookeeperConnect);//声明zk
        properties.put("group.id", groupId);// 必须要使用别的组名称， 如果生产者和消费者都在同一组，则不能访问同一组内的topic数据
        return Consumer.createJavaConsumerConnector(new ConsumerConfig(properties));
    }

}
