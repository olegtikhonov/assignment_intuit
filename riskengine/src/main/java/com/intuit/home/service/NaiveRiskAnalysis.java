package com.intuit.home.service;

import com.intuit.home.common.RequestConverter;
import com.intuit.home.entity.Currency;
import com.intuit.home.entity.Payment;
import com.intuit.home.entity.PaymentMethod;
import com.intuit.home.repository.CurrencyRepository;
import com.intuit.home.repository.PaymentMethodRepository;
import com.intuit.home.repository.PaymentRepository;
import com.intuit.home.request.PaymentRequest;
import com.intuit.home.response.PaymentResponse;
import com.intuit.home.strategy.RiskAnalysis;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

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
    private final Logger logger = LogManager.getLogger(NaiveRiskAnalysis.class);

    public NaiveRiskAnalysis(PaymentRepository paymentRepository, CurrencyRepository currencyRepository, PaymentMethodRepository paymentMethodRepository) {
        this.paymentRepository = paymentRepository;
        this.currencyRepository = currencyRepository;
        this.paymentMethodRepository = paymentMethodRepository;
    }


    @Override
    public PaymentResponse performAnalysis(Optional<PaymentRequest> dataToBEAnalyzed) {
        try {
            if (dataToBEAnalyzed.isPresent()) {
                Payment payment = RequestConverter.toPayment(dataToBEAnalyzed.get());

                // check if payment is valid:
                // 1. userID is valid,
                // 2. paeeID is valid
                // 3. amount is valid, i.e. is positive
                // 4. currencyId is valid
                // 5. paymentMethodId is valid

                validatePayment(payment);


                if ((paymentRepository.count() % 7) != 0) {
                    // accepts the payments
                    payment.setSucceeded(true);

                } else {
                    payment.setSucceeded(false);
                }

                paymentRepository.save(payment);
            }
        } catch (Exception e) {
            logger.error("{}", e);
            return new PaymentResponse().setSucceeded(false);
        }

        return new PaymentResponse();

    }

    //TODO: move to validator class
    boolean validatePayment(Payment payment) {
        Currency currency = currencyRepository.findByName(payment.getCurrencyId()).get();
        Optional<PaymentMethod> paymentMethod = paymentMethodRepository.findByPaymentMethodId(payment.getPaymentMethodId());
        if(!paymentMethod.isPresent()) {
            logger.error("payment ID seems to be wrong");
        }



        //List<Currency> currency = new ArrayList<>();
        //currencyRepository.findAll().forEach(currency::add);
        return currency != null;
    }
}
