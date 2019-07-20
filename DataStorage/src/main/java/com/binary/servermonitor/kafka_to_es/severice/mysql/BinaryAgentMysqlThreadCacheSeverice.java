package com.binary.servermonitor.kafka_to_es.severice.mysql;

import com.binary.servermonitor.kafka_to_es.common.GroupList;
import com.binary.servermonitor.kafka_to_es.common.TopicList;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.mysql.BinaryAgentMysqlTableCacheConsumer;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.mysql.BinaryAgentMysqlThreadCacheConsumer;
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
public class BinaryAgentMysqlThreadCacheSeverice implements ApplicationRunner {

    @Autowired
    BinaryAgentMysqlThreadCacheConsumer binaryAgentMysqlThreadCacheConsumer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        binaryAgentMysqlThreadCacheConsumer.setTopic(TopicList.binaryAgentMysqlThreadCache);
        binaryAgentMysqlThreadCacheConsumer.setZookeeperConnect(GroupList.zookeeperConnect);
        binaryAgentMysqlThreadCacheConsumer.setGroupId(GroupList.groupBinaryAgentMysqlThreadCache);
        binaryAgentMysqlThreadCacheConsumer.start();
    }
}
