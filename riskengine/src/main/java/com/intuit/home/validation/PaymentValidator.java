package com.intuit.home.validation;

import com.intuit.home.entity.*;
import com.intuit.home.repository.CurrencyRepository;
import com.intuit.home.repository.PayeeRepository;
import com.intuit.home.repository.PaymentMethodRepository;
import com.intuit.home.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class PaymentValidator implements BasicValidator<Payment> {
    private final CurrencyRepository currencyRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final UserRepository userRepository;
    private final PayeeRepository payeeRepository;
    private final Logger logger = LogManager.getLogger(PaymentValidator.class);

    public PaymentValidator(CurrencyRepository currencyRepository, PaymentMethodRepository paymentMethodRepository, UserRepository userRepository, PayeeRepository payeeRepository) {
        this.currencyRepository = currencyRepository;
        this.paymentMethodRepository = paymentMethodRepository;
        this.userRepository = userRepository;
        this.payeeRepository = payeeRepository;
    }

    @Override
    public boolean validate(Payment payment) {
        boolean validationResult = true;

        Optional<PaymentMethod> paymentMethod = paymentMethodRepository.findByPayerId(payment.getPayerId());
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
