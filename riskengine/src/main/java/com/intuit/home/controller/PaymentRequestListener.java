package com.intuit.home.controller;

import com.intuit.home.common.RequestConverter;
import com.intuit.home.common.RiskEngineConstant;
import com.intuit.home.service.NaiveRiskAnalysis;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;


@Controller
public class PaymentRequestListener {
    private static final Logger logger = LogManager.getLogger(PaymentRequestListener.class.getName());
    @Autowired NaiveRiskAnalysis riskAnalysis;


    @KafkaListener(topics = RiskEngineConstant.PAYMENT_TOPIC, groupId = RiskEngineConstant.PAYMENT_GROUPID)
    public void listen(String message) {
        logger.debug("Received Message in group foo: " + message);
        riskAnalysis.performAnalysis(RequestConverter.fromString(message));
    }
}
