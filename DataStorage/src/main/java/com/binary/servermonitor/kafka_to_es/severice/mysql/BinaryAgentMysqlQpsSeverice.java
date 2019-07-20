package com.binary.servermonitor.kafka_to_es.severice.mysql;

import com.binary.servermonitor.kafka_to_es.common.GroupList;
import com.binary.servermonitor.kafka_to_es.common.TopicList;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.mysql.BinaryAgentMysqlQpsConsumer;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.mysql.BinaryAgentMysqlQueryCacheConsumer;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.mysql.BinaryAgentMysqlprocesslistConsumer;
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
public class BinaryAgentMysqlQpsSeverice implements ApplicationRunner {

    @Autowired
    BinaryAgentMysqlQpsConsumer binaryAgentMysqlQpsConsumer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        binaryAgentMysqlQpsConsumer.setTopic(TopicList.binaryAgentMysqlQps);
        binaryAgentMysqlQpsConsumer.setZookeeperConnect(GroupList.zookeeperConnect);
        binaryAgentMysqlQpsConsumer.setGroupId(GroupList.groupBinaryAgentMysqlQps);
        binaryAgentMysqlQpsConsumer.start();
    }
}
