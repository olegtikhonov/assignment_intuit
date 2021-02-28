package com.intuit.home.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * Holds all properties which are in application.properties
 */
@Component
public class CommonPropertiesBean {
    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Value(value = "${kafka.topic.name}")
    private String kafkaTopicName;

    @Value(value = "${kafka.group.id}")
    private String kafkaGroupId;


    @Value(value = "spring.datasource.url")
    private String springDataSourceUrl;


    @Value(value = "spring.datasource.username")
    private String springDatasourceUsername;


    @Value(value = "spring.datasource.password")
    private String springDatasourcePassword;



    public String getBootstrapAddress() {
        return bootstrapAddress;
    }

    public CommonPropertiesBean setBootstrapAddress(String bootstrapAddress) {
        this.bootstrapAddress = bootstrapAddress;
        return this;
    }

    public String getKafkaTopicName() {
        return kafkaTopicName;
    }

    public CommonPropertiesBean setKafkaTopicName(String kafkaTopicName) {
        this.kafkaTopicName = kafkaTopicName;
        return this;
    }

    public String getKafkaGroupId() {
        return kafkaGroupId;
    }

    public CommonPropertiesBean setKafkaGroupId(String kafkaGroupId) {
        this.kafkaGroupId = kafkaGroupId;
        return this;
    }


    public String getSpringDataSourceUrl() {
        return springDataSourceUrl;
    }

    public CommonPropertiesBean setSpringDataSourceUrl(String springDataSourceUrl) {
        this.springDataSourceUrl = springDataSourceUrl;
        return this;
    }

    public String getSpringDatasourceUsername() {
        return springDatasourceUsername;
    }

    public CommonPropertiesBean setSpringDatasourceUsername(String springDatasourceUsername) {
        this.springDatasourceUsername = springDatasourceUsername;
        return this;
    }

    public String getSpringDatasourcePassword() {
        return springDatasourcePassword;
    }

    public CommonPropertiesBean setSpringDatasourcePassword(String springDatasourcePassword) {
        this.springDatasourcePassword = springDatasourcePassword;
        return this;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{bootstrapAddress='").append(bootstrapAddress).append('\'');
        sb.append(", kafkaTopicName='").append(kafkaTopicName).append('\'');
        sb.append(", kafkaGroupId='").append(kafkaGroupId).append('\'');
        sb.append(", springDataSourceUrl='").append(springDataSourceUrl).append('\'');
        sb.append(", springDatasourceUsername='").append(springDatasourceUsername).append('\'');
        sb.append(", springDatasourcePassword='").append(springDatasourcePassword).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
