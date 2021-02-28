package com.intuit.home.service;

import com.intuit.home.common.RequestConverter;
import com.intuit.home.common.ResponseConverter;
import com.intuit.home.config.CommonPropertiesBean;
import com.intuit.home.request.PaymentRequest;
import com.intuit.home.response.PaymentResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class ResponseSender {
    private final Logger logger = LogManager.getLogger(ResponseSender.class);
    private KafkaTemplate<String, String> kafkaTemplate;
    private CommonPropertiesBean propertiesBean;


    public ResponseSender(KafkaTemplate<String, String> kafkaTemplate, CommonPropertiesBean commonPropertiesBean) {
        this.kafkaTemplate = kafkaTemplate;
        this.propertiesBean = commonPropertiesBean;
    }

    public void sendMessage(PaymentResponse paymentResponse) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(propertiesBean.getResponseTopicName(), ResponseConverter.toString(paymentResponse));

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.debug(String.join(" ", "Sent message=[", ResponseConverter.toString(paymentResponse), "] with offset=[", result.getRecordMetadata().offset() + "]"));
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.error(String.join(" ", "Unable to send message=[", ResponseConverter.toString(paymentResponse), "] due to:", ex.getMessage()));
            }
        });
    }
}
