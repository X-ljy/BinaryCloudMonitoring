package com.binary.servermonitor.kafka_to_es.kafkaconsumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.kafka_to_es.common.IndexList;
import com.binary.servermonitor.kafka_to_es.entity.agentbean.BinaryAgentDiskIoInfoBean;
import com.binary.servermonitor.kafka_to_es.entity.agentbean.BinaryAgentProcInfoBean;
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
public class BinaryAgentProcInfoConsumer extends Thread{
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
    BinaryAgentProcInfoBean procInfoBean;

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
                    procInfoBean.setHostIp(jsonObject.getString("hostIp"));
                    procInfoBean.setDate(jsonObject.getString("date"));
                    procInfoBean.setUser(data.getJSONObject(temp).getString("user"));
                    procInfoBean.setPid(data.getJSONObject(temp).getString("pid"));
                    procInfoBean.setCpu(data.getJSONObject(temp).getString("cpu"));
                    procInfoBean.setMem(data.getJSONObject(temp).getString("mem"));
                    procInfoBean.setVsz(data.getJSONObject(temp).getString("vsz"));
                    procInfoBean.setRss(data.getJSONObject(temp).getString("rss"));
                    procInfoBean.setTty(data.getJSONObject(temp).getString("tty"));
                    procInfoBean.setStat(data.getJSONObject(temp).getString("status"));
                    procInfoBean.setStartTime(data.getJSONObject(temp).getString("startTime"));
                    procInfoBean.setCommand(data.getJSONObject(temp).getString("command"));

                    EsUtils.sendDataToIndex(IndexList.binaryagentprocinfoindex, procInfoBean.toJsonString());
                }


            } catch (Exception e) {
                logger.error("BinaryAgentProcInfoConsumer :  " + e.getMessage());
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
