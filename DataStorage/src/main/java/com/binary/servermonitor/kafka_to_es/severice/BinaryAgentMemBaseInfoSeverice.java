package com.binary.servermonitor.kafka_to_es.severice;

import com.binary.servermonitor.kafka_to_es.common.GroupList;
import com.binary.servermonitor.kafka_to_es.common.TopicList;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.BinaryAgentMemBaseInfoConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 夕
 * @date 2019/6/30
 */
@Component
@Order(value = 2)
public class BinaryAgentMemBaseInfoSeverice implements ApplicationRunner {
    @Autowired
    BinaryAgentMemBaseInfoConsumer binaryAgentMemBaseInfoConsumer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        binaryAgentMemBaseInfoConsumer.setTopic(TopicList.binaryAgentMemBaseInfo);
        binaryAgentMemBaseInfoConsumer.setZookeeperConnect(GroupList.zookeeperConnect);
        binaryAgentMemBaseInfoConsumer.setGroupId(GroupList.groupMem);
        binaryAgentMemBaseInfoConsumer.start();
    }
}
