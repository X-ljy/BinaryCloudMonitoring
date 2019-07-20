package com.binary.servermonitor.kafka_to_es.severice;

import com.binary.servermonitor.kafka_to_es.common.GroupList;
import com.binary.servermonitor.kafka_to_es.common.TopicList;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.WriteIoDataConsumer;
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
@Order(value = 10)
public class WriteIoStartSeverice implements ApplicationRunner {

    @Autowired
    WriteIoDataConsumer writeIoDataConsumer;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        writeIoDataConsumer.setTopic(TopicList.WriteIoDataTopic);
        writeIoDataConsumer.setZookeeperConnect(GroupList.zookeeperConnect);
        writeIoDataConsumer.setGroupId(GroupList.groupWriteIo);
        writeIoDataConsumer.start();
    }
}
