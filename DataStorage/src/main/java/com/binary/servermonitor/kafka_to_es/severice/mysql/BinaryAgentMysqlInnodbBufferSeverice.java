package com.binary.servermonitor.kafka_to_es.severice.mysql;

import com.binary.servermonitor.kafka_to_es.common.GroupList;
import com.binary.servermonitor.kafka_to_es.common.TopicList;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.mysql.BinaryAgentMysqlConnectionNumberConsumer;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.mysql.BinaryAgentMysqlInnodbBufferConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 夕
 * @date 2019/7/2
 */
@Component
@Order(value = 2)
public class BinaryAgentMysqlInnodbBufferSeverice implements ApplicationRunner {

    @Autowired
    BinaryAgentMysqlInnodbBufferConsumer binaryAgentMysqlInnodbBufferConsumer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        binaryAgentMysqlInnodbBufferConsumer.setTopic(TopicList.binaryAgentMysqlInnodbBuffer);
        binaryAgentMysqlInnodbBufferConsumer.setZookeeperConnect(GroupList.zookeeperConnect);
        binaryAgentMysqlInnodbBufferConsumer.setGroupId(GroupList.groupBinaryAgentMysqlInnodbBuffer);
        binaryAgentMysqlInnodbBufferConsumer.start();
    }
}
