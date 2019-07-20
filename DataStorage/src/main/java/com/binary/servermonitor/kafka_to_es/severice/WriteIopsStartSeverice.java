package com.binary.servermonitor.kafka_to_es.severice;

import com.binary.servermonitor.kafka_to_es.common.GroupList;
import com.binary.servermonitor.kafka_to_es.common.TopicList;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.WriteIoDataConsumer;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.WriteIopsDataConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 夕
 * @date 2019/5/16
 */
@Component
@Order(value = 11)
public class WriteIopsStartSeverice implements ApplicationRunner {

    @Autowired
    WriteIopsDataConsumer writeIopsDataConsumer;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        writeIopsDataConsumer.setTopic(TopicList.WriteIopsDataTopic);
        writeIopsDataConsumer.setZookeeperConnect(GroupList.zookeeperConnect);
        writeIopsDataConsumer.setGroupId(GroupList.groupWriteIops);
        writeIopsDataConsumer.start();
    }
}
