package com.intuit.home.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Maps all application properties.
 * Single source of truth. Makes possible to change properties at runtime.
 * This bean injected to the classes which need take properties.
 */
@Component
public class CommonPropertiesBean {
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Value(value = "${kafka.topic.name}")
    private String kafkaTopicName;

    @Value(value = "${kafka.partition.amount}")
    private Integer kafkaPartitionAmount;

    @Value(value = "${kafka.replication.factor}")
    private Short kafkaReplicationFactor;

    @Value("${response.topic.name}")
    private String responseTopicName;


    public String getBootstrapAddress() {
        return bootstrapAddress;
    }

    public void setBootstrapAddress(String bootstrapAddress) {
        this.bootstrapAddress = bootstrapAddress;
    }

    public String getKafkaTopicName() {
        return kafkaTopicName;
    }

    public void setKafkaTopicName(String kafkaTopicName) {
        this.kafkaTopicName = kafkaTopicName;
    }

    public Integer getKafkaPartitionAmount() {
        return kafkaPartitionAmount;
    }

    public void setKafkaPartitionAmount(Integer kafkaPartitionAmount) {
        this.kafkaPartitionAmount = kafkaPartitionAmount;
    }

    public Short getKafkaReplicationFactor() {
        return kafkaReplicationFactor;
    }

    public void setKafkaReplicationFactor(Short kafkaReplicationFactor) {
        this.kafkaReplicationFactor = kafkaReplicationFactor;
    }

    public String getResponseTopicName() {
        return responseTopicName;
    }

    public void setResponseTopicName(String responseTopicName) {
        this.responseTopicName = responseTopicName;
    }
}
