package com.binary.servermonitor.kafka_to_es.kafkaconsumer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.binary.servermonitor.kafka_to_es.common.IndexList;
import com.binary.servermonitor.kafka_to_es.entity.agentbean.BinaryAgentDiskBaseInfoBean;
import com.binary.servermonitor.kafka_to_es.entity.agentbean.BinaryAgentDiskIoInfoBean;
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
public class BinaryAgentDiskIoInfoConsumer extends Thread {
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
    BinaryAgentDiskIoInfoBean ioInfoBean;

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
                    ioInfoBean.setHostIp(jsonObject.getString("hostIp"));
                    ioInfoBean.setDate(jsonObject.getString("date"));
                    ioInfoBean.setWkB(data.getJSONObject(temp).getString("wkB"));
                    ioInfoBean.setRkB(data.getJSONObject(temp).getString("rkB"));
                    ioInfoBean.setR_await(data.getJSONObject(temp).getString("r_await"));
                    ioInfoBean.setW_await(data.getJSONObject(temp).getString("w_await"));
                    ioInfoBean.setAwait(data.getJSONObject(temp).getString("await"));
                    ioInfoBean.setWio(data.getJSONObject(temp).getString("wio"));
                    ioInfoBean.setRio(data.getJSONObject(temp).getString("rio"));
                    ioInfoBean.setAvgqusz(data.getJSONObject(temp).getString("avgqusz"));
                    ioInfoBean.setAvgrqsz(data.getJSONObject(temp).getString("avgrqsz"));
                    ioInfoBean.setRrqm(data.getJSONObject(temp).getString("rmerge"));
                    ioInfoBean.setWrqm(data.getJSONObject(temp).getString("wmerge"));
                    ioInfoBean.setDeviceName(temp);
                    ioInfoBean.setSvctm(data.getJSONObject(temp).getString("svctm"));
                    ioInfoBean.setUtil(data.getJSONObject(temp).getString("util"));

                    EsUtils.sendDataToIndex(IndexList.binaryagentdiskioinfoindex, ioInfoBean.toJsonString());
                }


            } catch (Exception e) {
                logger.error("BinaryAgentDiskIoInfoConsumer :  " + e.getMessage());
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
