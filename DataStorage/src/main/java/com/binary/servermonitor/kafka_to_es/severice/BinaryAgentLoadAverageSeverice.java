package com.binary.servermonitor.kafka_to_es.severice;

import com.binary.servermonitor.kafka_to_es.common.GroupList;
import com.binary.servermonitor.kafka_to_es.common.TopicList;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.BinaryAgentLoadAverageConsumer;
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
public class BinaryAgentLoadAverageSeverice implements ApplicationRunner {

    @Autowired
    BinaryAgentLoadAverageConsumer binaryAgentLoadAverageConsumer;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        binaryAgentLoadAverageConsumer.setTopic(TopicList.binaryAgentLoadAverage);
        binaryAgentLoadAverageConsumer.setZookeeperConnect(GroupList.zookeeperConnect);
        binaryAgentLoadAverageConsumer.setGroupId(GroupList.groupLoadAverage);
        binaryAgentLoadAverageConsumer.start();
    }
}
