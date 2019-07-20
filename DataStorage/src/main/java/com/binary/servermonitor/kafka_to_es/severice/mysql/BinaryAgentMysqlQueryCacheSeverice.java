package com.binary.servermonitor.kafka_to_es.severice.mysql;

import com.binary.servermonitor.kafka_to_es.common.GroupList;
import com.binary.servermonitor.kafka_to_es.common.TopicList;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.mysql.BinaryAgentMysqlQpsConsumer;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.mysql.BinaryAgentMysqlQueryCacheConsumer;
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
public class BinaryAgentMysqlQueryCacheSeverice implements ApplicationRunner {

    @Autowired
    BinaryAgentMysqlQueryCacheConsumer binaryAgentMysqlQueryCacheConsumer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        binaryAgentMysqlQueryCacheConsumer.setTopic(TopicList.binaryAgentMysqlQueryCache);
        binaryAgentMysqlQueryCacheConsumer.setZookeeperConnect(GroupList.zookeeperConnect);
        binaryAgentMysqlQueryCacheConsumer.setGroupId(GroupList.groupBinaryAgentMysqlQueryCache);
        binaryAgentMysqlQueryCacheConsumer.start();
    }
}