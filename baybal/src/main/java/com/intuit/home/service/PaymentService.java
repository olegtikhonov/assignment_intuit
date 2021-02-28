package com.intuit.home.service;

import com.intuit.home.common.RequestConverter;
import com.intuit.home.config.CommonPropertiesBean;
import com.intuit.home.request.PaymentRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


/**
 * Intends to represent a service which makes payments.
 * TODO: add dead letter mechanism for retries
 */
@Service
public class PaymentService {
    private final Logger logger = LogManager.getLogger(PaymentService.class);
    @Autowired private CommonPropertiesBean commonPropertiesBean;
    @Autowired private KafkaTemplate<String, String> kafkaTemplate;


    /**
     * Puts a payment request into topic/queue.
     *
     * @param paymentRequest a payload of the payment.
     */
    public void sendMessage(PaymentRequest paymentRequest) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(commonPropertiesBean.getKafkaTopicName(), RequestConverter.toString(paymentRequest));

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.debug(String.join(" ", "Sent message=[", RequestConverter.toString(paymentRequest), "] with offset=[", result.getRecordMetadata().offset() + "]"));
            }
            @Override
            public void onFailure(Throwable ex) {
                logger.error(String.join(" ", "Unable to send message=[", RequestConverter.toString(paymentRequest), "] due to:", ex.getMessage()));
            }
        });
    }
}
