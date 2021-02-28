package com.intuit.home.validation;

import com.intuit.home.entity.Payment;
import com.intuit.home.repository.CurrencyRepository;
import com.intuit.home.repository.PayeeRepository;
import com.intuit.home.repository.PaymentMethodRepository;
import com.intuit.home.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.when;

class PaymentValidatorTest {
    private PaymentValidator paymentValidator;
    @Mock CurrencyRepository currencyRepository;
    @Mock PaymentMethodRepository paymentMethodRepository;
    @Mock UserRepository userRepository;
    @Mock PayeeRepository payeeRepository;
    @Mock Payment payment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        paymentValidator = new PaymentValidator(currencyRepository, paymentMethodRepository, userRepository, payeeRepository);
    }

    @Test
    void validate() {
        when(payment.getPayerId()).thenReturn(UUID.randomUUID());
        System.out.println(paymentValidator.validate(payment));
    }
}