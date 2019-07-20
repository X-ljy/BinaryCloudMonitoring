package com.binary.servermonitor.kafka_to_es.severice;

import com.binary.servermonitor.kafka_to_es.common.GroupList;
import com.binary.servermonitor.kafka_to_es.common.TopicList;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.PublicipOutflowDataConsumer;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.ReadIoDataConsumer;
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
@Order(value = 8)
public class ReadIoStartSeverice implements ApplicationRunner {
    @Autowired
    ReadIoDataConsumer readIoDataConsumer;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        readIoDataConsumer.setTopic(TopicList.ReadIoDataTopic);
        readIoDataConsumer.setZookeeperConnect(GroupList.zookeeperConnect);
        readIoDataConsumer.setGroupId(GroupList.groupReadIo);
        readIoDataConsumer.start();
    }

}
