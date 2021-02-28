package com.intuit.home.service;

import com.intuit.home.common.RequestConverter;
import com.intuit.home.entity.*;
import com.intuit.home.repository.*;
import com.intuit.home.request.PaymentRequest;
import com.intuit.home.response.PaymentResponse;
import com.intuit.home.strategy.RiskAnalysis;
import com.intuit.home.validation.PaymentValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * This risk analysis works as follows:
 * Calculate number of Payment rows mod 7
 * if it != 0, it accepts it, otherwise rejects.
 */
@Service
public class NaiveRiskAnalysis implements RiskAnalysis<PaymentResponse, Optional<PaymentRequest>> {
    private final PaymentRepository paymentRepository;
    private final ResponseSender responseSender;
    private final PaymentValidator paymentValidator;
    private final Logger logger = LogManager.getLogger(NaiveRiskAnalysis.class);


    public NaiveRiskAnalysis(ResponseSender responseSender, PaymentRepository paymentRepository, PaymentValidator paymentValidator) {
        this.paymentRepository = paymentRepository;
        this.responseSender = responseSender;
        this.paymentValidator = paymentValidator;
    }


    @Override
    public PaymentResponse performAnalysis(Optional<PaymentRequest> dataToBEAnalyzed) {
        try {
            if (dataToBEAnalyzed.isPresent()) {
                Payment payment = RequestConverter.toPayment(dataToBEAnalyzed.get());
                payment.setSucceeded(false);

                if (!paymentValidator.validate(payment)) {
                    logger.debug("Sending response ...");
                    responseSender.sendMessage(new PaymentResponse().setDetails(createExplanation(payment)));
                    return new PaymentResponse().setSucceeded(false);
                }

                if ((paymentRepository.count() % 7) != 0) {
                    // accepts the payments
                    payment.setSucceeded(true);
                }
                paymentRepository.save(payment);
            }
        } catch (Exception e) {
            logger.error("{}", e);
            responseSender.sendMessage(new PaymentResponse().setDetails(createErrorMessage("error_occurred", e.toString())));
        }

        return new PaymentResponse();

    }

    private Map<String, String> createErrorMessage(String error_occurred, String s) {
        Map<String, String> wrongPayment = new HashMap<>();
        wrongPayment.put(error_occurred, s);
        return wrongPayment;
    }

    private Map<String, String> createExplanation(Payment payment) {
        Map<String, String> wrongPayment = new HashMap<>();
        wrongPayment.put("payment_validation", "A payment contains wrong data. Please check it.");
        wrongPayment.put("payerID", String.valueOf(payment.getPayerId()));
        wrongPayment.put("payeeID", String.valueOf(payment.getPayeeId()));
        wrongPayment.put("paymentID", String.valueOf(payment.getPaymentId()));
        return wrongPayment;
    }
}
