package com.binary.servermonitor.kafka_to_es.kafkaconsumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.kafka_to_es.common.IndexList;
import com.binary.servermonitor.kafka_to_es.entity.agentbean.BinaryAgentCpuUseInfoBean;
import com.binary.servermonitor.kafka_to_es.entity.agentbean.BinaryAgentDiskBaseInfoBean;
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

import java.util.*;

/**
 * @author 夕
 * @date 2019/6/30
 */
@Service
public class BinaryAgentDiskBaseInfoConsumer extends Thread{
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
    BinaryAgentDiskBaseInfoBean baseInfoBean;

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
                JSONObject data = jsonObject.getJSONObject("data");
                Iterator iterator1 = data.keySet().iterator();
                while (iterator1.hasNext()) {
                    String temp = (String) iterator1.next();
                    baseInfoBean.setHostIp(jsonObject.getString("hostIp"));
                    baseInfoBean.setDate(jsonObject.getString("date"));
                    baseInfoBean.setFileSystem(data.getJSONObject(temp).getString("fileSystem"));
                    baseInfoBean.setUsed(data.getJSONObject(temp).getString("diskUsed"));
                    baseInfoBean.setUseRate(data.getJSONObject(temp).getString("diskUseRate"));
                    baseInfoBean.setAvailable(data.getJSONObject(temp).getString("diskAvail"));
                    baseInfoBean.setSize(data.getJSONObject(temp).getString("diskSize"));
                    baseInfoBean.setMounted(data.getJSONObject(temp).getString("mounted"));

                    EsUtils.sendDataToIndex(IndexList.binaryagentdiskbaseinfoindex, baseInfoBean.toJsonString());
                }


            } catch (Exception e) {
                logger.error("BinaryAgentDiskBaseInfoConsumer :  " + e.getMessage());
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
