package com.binary.servermonitor.kafka_to_es.severice.mysql;

import com.binary.servermonitor.kafka_to_es.common.GroupList;
import com.binary.servermonitor.kafka_to_es.common.TopicList;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.mysql.BinaryAgentMysqlInnodbBufferConsumer;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.mysql.BinaryAgentMysqlKeyBufferConsumer;
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
public class BinaryAgentMysqlKeyBufferSeverice implements ApplicationRunner {

    @Autowired
    BinaryAgentMysqlKeyBufferConsumer binaryAgentMysqlKeyBufferConsumer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        binaryAgentMysqlKeyBufferConsumer.setTopic(TopicList.binaryAgentMysqlKeyBuffer);
        binaryAgentMysqlKeyBufferConsumer.setZookeeperConnect(GroupList.zookeeperConnect);
        binaryAgentMysqlKeyBufferConsumer.setGroupId(GroupList.groupBinaryAgentMysqlKeyBuffer);
        binaryAgentMysqlKeyBufferConsumer.start();
    }
}
