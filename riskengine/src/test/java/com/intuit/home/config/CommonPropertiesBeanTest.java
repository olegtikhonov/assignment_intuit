package com.intuit.home.config;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonPropertiesBeanTest {
    public static final String BOOTSTRAP_ADDRESS = "localhost:9092";
    public static final String KAFKA_GROUP = "test-kafka-group";
    public static final String KAFKA_TOPIC = "test-kafka-topic";
    public static final String PASSWORD = "don_t_say";
    public static final String DATA_SOURCE_URL = "jdbc:127.0.0.1:6342/dummy";
    public static final String DATASOURCE_USERNAME = "guess_what";
    private CommonPropertiesBean commonPropertiesBean;

    @BeforeEach
    public void setUp() {
        commonPropertiesBean = new CommonPropertiesBean().setBootstrapAddress(BOOTSTRAP_ADDRESS).
                setKafkaGroupId(KAFKA_GROUP).
                setKafkaTopicName(KAFKA_TOPIC).
                setSpringDatasourcePassword(PASSWORD).
                setSpringDataSourceUrl(DATA_SOURCE_URL).
                setSpringDatasourceUsername(DATASOURCE_USERNAME);
    }

    @Test
    public void getBootstrapAddress() {
        assertEquals(BOOTSTRAP_ADDRESS, commonPropertiesBean.getBootstrapAddress());
    }

    @Test
    public void getKafkaTopicName() {
        assertEquals(KAFKA_TOPIC, commonPropertiesBean.getKafkaTopicName());
    }

    @Test
    public void getKafkaGroupId() {
        assertEquals(KAFKA_GROUP, commonPropertiesBean.getKafkaGroupId());
    }

    @Test
    public void getSpringDataSourceUrl() {
        assertEquals(DATA_SOURCE_URL, commonPropertiesBean.getSpringDataSourceUrl());
    }

    @Test
    public void getSpringDatasourceUsername() {
        assertEquals(DATASOURCE_USERNAME, commonPropertiesBean.getSpringDatasourceUsername());
    }

    @Test
    public void getSpringDatasourcePassword() {
        assertEquals(PASSWORD, commonPropertiesBean.getSpringDatasourcePassword());
    }

    @Test
    public void toString1() {
        assertTrue(commonPropertiesBean.toString().contains(CommonPropertiesBean.class.getSimpleName()));
    }
}
