package com.intuit.home.controller;

import com.intuit.home.common.RiskEngineConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;

@Controller
public class PaymentResponseListener {
    private static final Logger logger = LogManager.getLogger(PaymentResponseListener.class.getName());


    @KafkaListener(topics = RiskEngineConstant.PAYMENT_RESPONSE_TOPIC, groupId = RiskEngineConstant.PAYMENT_GROUPID)
    public void listen(String message) {
        logger.debug("Received Message in group foo: " + message);
        //TODO: send response to the specific payeer.
    }
}
