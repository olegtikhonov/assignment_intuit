package com.intuit.home.service;

import com.intuit.home.common.RequestConverter;
import com.intuit.home.entity.*;
import com.intuit.home.repository.*;
import com.intuit.home.request.PaymentRequest;
import com.intuit.home.response.PaymentResponse;
import com.intuit.home.strategy.RiskAnalysis;
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
    private PaymentRepository paymentRepository;
    private CurrencyRepository currencyRepository;
    private PaymentMethodRepository paymentMethodRepository;
    private UserRepository userRepository;
    private PayeeRepository payeeRepository;
    private ResponseSender responseSender;
    private final Logger logger = LogManager.getLogger(NaiveRiskAnalysis.class);


    public NaiveRiskAnalysis(PaymentRepository paymentRepository, CurrencyRepository currencyRepository,
                             PaymentMethodRepository paymentMethodRepository, UserRepository userRepository, ResponseSender responseSender, PayeeRepository payeeRepository) {
        this.paymentRepository = paymentRepository;
        this.currencyRepository = currencyRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.userRepository = userRepository;
        this.responseSender = responseSender;
        this.payeeRepository = payeeRepository;
    }


    @Override
    public PaymentResponse performAnalysis(Optional<PaymentRequest> dataToBEAnalyzed) {
        try {
            if (dataToBEAnalyzed.isPresent()) {
                Payment payment = RequestConverter.toPayment(dataToBEAnalyzed.get());
                payment.setSucceeded(false);

                if(!validatePayment(payment)) {
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

    //TODO: move to validator class
    /**
     * Validates @{@link Payment}
     *
     * @param payment to be validated.
     *
     * @return either true or false
     */
    boolean validatePayment(Payment payment) {
        boolean validationResult = true;

        Optional<PaymentMethod> paymentMethod = paymentMethodRepository.findByPaymentMethodId(payment.getPaymentMethodId());
        if (!paymentMethod.isPresent()) {
            logger.error("payment ID seems to be wrong");
            validationResult = false;
        }

        Optional<Currency> currency = currencyRepository.findByName(payment.getCurrencyId());
        if (!currency.isPresent()) {
            logger.error("currency seems to be wrong");
            validationResult = false;
        }

        // case check userID
        Optional<Payer> user = userRepository.findByPayerId(payment.getPayerId());
        if (!user.isPresent()) {
            logger.error("user ID seems to be wrong");
            validationResult = false;
        }

        // case - check payeeID
        Optional<Payee> payee = payeeRepository.findByPayeeId(payment.getPayeeId());
        if (!payee.isPresent()) {
            logger.error("payee ID seems to be wrong");
            validationResult = false;
        }

        // case payment amount
        if (payment.getAmount() <= 0d) {
            logger.error("Amount should be greater than 0.");
            validationResult = false;
        }

        return validationResult;
    }
}
