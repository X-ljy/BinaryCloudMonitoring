package com.binary.servermonitor.data_collection.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 夕
 * @date 2019/5/4
 */

@Component
@ConfigurationProperties(prefix = "spring.kafka.producer")
public class KafkaConfiguration {

    private String acks;
    private int retries;
    private int batchSize;
    private long bufferMemory;
    private int lingerMs;
    private String keySerializer;
    private String valueSerializer;
    private String bootstrapServers;

    public String getAcks() {
        return acks;
    }

    public void setAcks(String acks) {
        this.acks = acks;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }

    public int getBatchSize() {
        return batchSize;
    }

    public void setBatchSize(int batchSize) {
        this.batchSize = batchSize;
    }

    public long getBufferMemory() {
        return bufferMemory;
    }

    public void setBufferMemory(long bufferMemory) {
        this.bufferMemory = bufferMemory;
    }

    public int getLingerMs() {
        return lingerMs;
    }

    public void setLingerMs(int lingerMs) {
        this.lingerMs = lingerMs;
    }

    public String getKeySerializer() {
        return keySerializer;
    }

    public void setKeySerializer(String keySerializer) {
        this.keySerializer = keySerializer;
    }

    public String getValueSerializer() {
        return valueSerializer;
    }

    public void setValueSerializer(String valueSerializer) {
        this.valueSerializer = valueSerializer;
    }

    public String getBootstrapServers() {
        return bootstrapServers;
    }

    public void setBootstrapServers(String bootstrapServers) {
        this.bootstrapServers = bootstrapServers;
    }

    @Override
    public String toString() {
        return "KafkaConfig{" +
                "acks='" + acks + '\'' +
                ", retries=" + retries +
                ", batchSize=" + batchSize +
                ", bufferMemory=" + bufferMemory +
                ", lingerMs=" + lingerMs +
                ", keySerializer='" + keySerializer + '\'' +
                ", valueSerializer='" + valueSerializer + '\'' +
                ", bootstrapServers='" + bootstrapServers + '\'' +
                '}';
    }
}
