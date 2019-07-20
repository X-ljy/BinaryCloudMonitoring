package com.binary.servermonitor.data_collection.util;

/**
 * @author 夕
 * @date 2019/4/30
 */
import java.util.*;
import java.util.concurrent.ExecutionException;

import com.binary.servermonitor.data_collection.entity.KafkaTopicBean;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.config.ConfigResource;

public class KafkaUtil {


    /**
     * delete the given topics
     * @param client
     */
    public static void deleteTopics(AdminClient client,KafkaTopicBean kafkaTopicBean) throws ExecutionException, InterruptedException {
        KafkaFuture<Void> futures = client.deleteTopics(Arrays.asList(kafkaTopicBean.getTopicName())).all();
        futures.get();
    }
    /**
     * create multiple sample topics
     * @param client
     */
    public static void createTopics(AdminClient client,KafkaTopicBean kafkaTopicBean)
            throws ExecutionException, InterruptedException {

        NewTopic newTopic = new NewTopic(kafkaTopicBean.getTopicName(),
                kafkaTopicBean.getPartition(),
                kafkaTopicBean.getReplication().shortValue());

        CreateTopicsResult ret = client.createTopics(Arrays.asList(newTopic));
        client.close();
        ret.all().get();

    }
    /**
     * print all topics in the cluster
     * @param client
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void listAllTopics(AdminClient client) throws ExecutionException, InterruptedException {
        ListTopicsOptions options = new ListTopicsOptions();
        options.listInternal(true); // includes internal topics such as __consumer_offsets
        ListTopicsResult topics = client.listTopics(options);
        Set<String> topicNames = topics.names().get();
        System.out.println("Current topics in this cluster: " + topicNames);
    }


    /**
     * describe the cluster
     * @param client
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void describeCluster(AdminClient client) throws ExecutionException, InterruptedException {
        DescribeClusterResult ret = client.describeCluster();
        System.out.println(String.format("Cluster id: %s, controller: %s", ret.clusterId().get(), ret.controller().get()));
        System.out.println("Current cluster nodes info: ");
        for (org.apache.kafka.common.Node node : ret.nodes().get()) {
            System.out.println(node);
        }
    }

    /**
     * describe topic's config
     * @param client
     */
    public static void describeConfig(AdminClient client,KafkaTopicBean kafkaTopicBean) throws ExecutionException, InterruptedException {
        DescribeConfigsResult ret = client.describeConfigs(Collections.singleton(new ConfigResource(ConfigResource.Type.TOPIC,
                kafkaTopicBean.getTopicName())));
        Map<ConfigResource, Config> configs = ret.all().get();
        for (Map.Entry<ConfigResource, Config> entry : configs.entrySet()) {
            ConfigResource key = entry.getKey();
            Config value = entry.getValue();
            System.out.println(String.format("Resource type: %s, resource name: %s", key.type(), key.name()));
            Collection<ConfigEntry> configEntries = value.entries();
            for (ConfigEntry each : configEntries) {
                System.out.println(each.name() + " = " + each.value());
            }
        }
    }

    /**
     * alter config for topics
     * @param client
     */
    public static void alterConfigs(AdminClient client,KafkaTopicBean kafkaTopicBean) throws ExecutionException, InterruptedException {
        Config topicConfig = new Config(Arrays.asList(new ConfigEntry("cleanup.policy", "compact")));
        client.alterConfigs(Collections.singletonMap(
                new ConfigResource(ConfigResource.Type.TOPIC, kafkaTopicBean.getTopicName()), topicConfig)).all().get();
    }

    /**
     * describe the given topics
     * @param client
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void describeTopics(AdminClient client,KafkaTopicBean kafkaTopicBean) throws ExecutionException, InterruptedException {
        DescribeTopicsResult ret = client.describeTopics(Arrays.asList(kafkaTopicBean.getTopicName(), "__consumer_offsets"));
        Map<String, TopicDescription> topics = ret.all().get();
        for (Map.Entry<String, TopicDescription> entry : topics.entrySet()) {
            System.out.println(entry.getKey() + " ===> " + entry.getValue());
        }
    }



}