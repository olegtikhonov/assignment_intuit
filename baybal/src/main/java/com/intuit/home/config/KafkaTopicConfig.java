package com.intuit.home.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * Kafka configuration uses admin capabilities to create a new topic.
 */
@Configuration
public class KafkaTopicConfig {
    private @Autowired
    CommonPropertiesBean commonPropertiesBean;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, commonPropertiesBean.getBootstrapAddress());
        return new KafkaAdmin(configs);
    }

    // for payments
    @Bean
    public NewTopic createTopic() {
        // params: topic name, number of partitions, replication factor
        return new NewTopic(commonPropertiesBean.getKafkaTopicName(), commonPropertiesBean.getKafkaPartitionAmount(), commonPropertiesBean.getKafkaReplicationFactor());
    }

    // for responses
    @Bean
    public NewTopic responseTopic() {
        return new NewTopic(commonPropertiesBean.getResponseTopicName(), commonPropertiesBean.getKafkaPartitionAmount(), commonPropertiesBean.getKafkaReplicationFactor());
    }
}
