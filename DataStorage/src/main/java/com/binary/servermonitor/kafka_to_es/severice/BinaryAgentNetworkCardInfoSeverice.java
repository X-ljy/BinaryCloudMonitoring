package com.binary.servermonitor.kafka_to_es.severice;

import com.binary.servermonitor.kafka_to_es.common.GroupList;
import com.binary.servermonitor.kafka_to_es.common.TopicList;
import com.binary.servermonitor.kafka_to_es.kafkaconsumer.BinaryAgentNetworkCardInfoConsumer;
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
public class BinaryAgentNetworkCardInfoSeverice implements ApplicationRunner {
    @Autowired
    BinaryAgentNetworkCardInfoConsumer binaryAgentNetworkCardInfoConsumer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        binaryAgentNetworkCardInfoConsumer.setTopic(TopicList.binaryAgentNetworkCardInfo);
        binaryAgentNetworkCardInfoConsumer.setZookeeperConnect(GroupList.zookeeperConnect);
        binaryAgentNetworkCardInfoConsumer.setGroupId(GroupList.groupNetworkCard);
        binaryAgentNetworkCardInfoConsumer.start();
    }
}
