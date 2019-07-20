package com.binary.servermonitor.data_collection.util;

import com.binary.servermonitor.data_collection.common.TopicList;
import com.binary.servermonitor.data_collection.data_api.cpu.CpuApi;
import com.binary.servermonitor.data_collection.data_api.disk.ReadIoApi;
import com.binary.servermonitor.data_collection.data_api.disk.ReadIopsApi;
import com.binary.servermonitor.data_collection.data_api.image.Inquire;
import com.binary.servermonitor.data_collection.data_api.parameters.Requestparameters;
import com.binary.servermonitor.data_collection.entity.KafkaTopicBean;
import org.apache.kafka.clients.admin.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author 夕
 * @date 2019/4/29
 */


public class KafkaUtilExample {

    public static void  main(String[] args) throws IOException {

        KafkaTopicBean kafkaTopicBean = new KafkaTopicBean();

        kafkaTopicBean.setTopicName(TopicList.CpuDataTopic);
        kafkaTopicBean.setPartition(3);
        kafkaTopicBean.setReplication(3);
        kafkaTopicBean.setBrokerlist("10.10.44.127:9092,10.10.44.128:9092,10.10.44.129:9092");


        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaTopicBean.getBrokerlist());

        try {
            AdminClient client = AdminClient.create(props);

            KafkaUtil.listAllTopics(client);

        }catch (Exception e){
            e.printStackTrace();
        }


    }





}
