package com.binary.servermonitor.data_collection.common;

import java.util.Properties;

/**
 * @author 夕
 * @date 2019/5/4
 */
public class KafkaInfo {

    public static Properties getProperties() {
        Properties props = new Properties();
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("bootstrap.servers", "10.10.44.127:9092,10.10.44.128:9092,10.10.44.129:9092");
        return props;
    }
}
