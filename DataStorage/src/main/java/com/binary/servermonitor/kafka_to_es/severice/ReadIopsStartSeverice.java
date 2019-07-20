package com.binary.servermonitor.kafka_to_es.severice;

import com.binary.servermonitor.kafka_to_es.common.GroupList;
import com.binary.servermonitor.kafka_to_es.common.TopicList;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.ReadIoDataConsumer;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.ReadIopsDataConsumer;
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
@Order(value = 7)
public class ReadIopsStartSeverice implements ApplicationRunner {
    @Autowired
    ReadIopsDataConsumer readIopsDataConsumer;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        readIopsDataConsumer.setTopic(TopicList.ReadIopsDataTopic);
        readIopsDataConsumer.setZookeeperConnect(GroupList.zookeeperConnect);
        readIopsDataConsumer.setGroupId(GroupList.groupReadIops);
        readIopsDataConsumer.start();
    }


}
