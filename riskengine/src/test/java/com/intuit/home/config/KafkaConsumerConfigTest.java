package com.intuit.home.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class KafkaConsumerConfigTest {
    @InjectMocks
    KafkaConsumerConfig kafkaConsumerConfig;
    @Mock
    CommonPropertiesBean commonPropertiesBean;


    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        when(commonPropertiesBean.getBootstrapAddress()).thenReturn("localhost:9092");
        when(commonPropertiesBean.getKafkaGroupId()).thenReturn("kafka-test");

    }

    @Test
    public void consumerFactory() {
        ConsumerFactory<String, String> factory = kafkaConsumerConfig.consumerFactory();
        assertNotNull(factory);
    }

    @Test
    public void kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> listenerFactory = kafkaConsumerConfig.kafkaListenerContainerFactory();
        assertNotNull(listenerFactory);
    }
}
