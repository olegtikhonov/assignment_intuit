package com.intuit.home.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.core.KafkaAdmin;

import static com.intuit.home.TestConstants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


public class KafkaTopicConfigTest {
    @InjectMocks
    KafkaTopicConfig kafkaTopicConfig;
    @Mock
    CommonPropertiesBean commonPropertiesBean;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(commonPropertiesBean.getBootstrapAddress()).thenReturn(KAFKA_BOOTSTRAP);
        when(commonPropertiesBean.getKafkaTopicName()).thenReturn(KAFKA_TOPIC);
        when(commonPropertiesBean.getKafkaPartitionAmount()).thenReturn(PARTITION_NUMBER);
        when(commonPropertiesBean.getKafkaReplicationFactor()).thenReturn(REPLICATION_FACTOR);
    }

    @Test
    public void kafkaAdmin() {
        KafkaAdmin kafkaAdmin = kafkaTopicConfig.kafkaAdmin();
        assertEquals(KAFKA_BOOTSTRAP, kafkaAdmin.getConfigurationProperties().get(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG));
    }

    @Test
    public void createTopic() {
        NewTopic newTopic = kafkaTopicConfig.createTopic();
        assertNotNull(newTopic);
    }
}
