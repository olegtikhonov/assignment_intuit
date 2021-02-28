package com.intuit.home.service;

import com.intuit.home.money.Moneta;
import com.intuit.home.repository.*;
import com.intuit.home.request.PaymentRequest;
import com.intuit.home.response.PaymentResponse;

import com.intuit.home.validation.PaymentValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.AUTO_CONFIGURED;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AUTO_CONFIGURED)
public class NaiveRiskAnalysisTest {
    private NaiveRiskAnalysis naiveRiskAnalysis;
    private PaymentRequest paymentRequest;
    @MockBean private PaymentRepository paymentRepository;
    @MockBean private PaymentValidator paymentValidator;
    @MockBean private ResponseSender responseSender;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        naiveRiskAnalysis = new NaiveRiskAnalysis(responseSender, paymentRepository, paymentValidator);
        Field paymentRepositoryFiled = naiveRiskAnalysis.getClass().getDeclaredField("paymentRepository");
        paymentRepositoryFiled.setAccessible(true);
        paymentRepositoryFiled.set(naiveRiskAnalysis, paymentRepository);

        paymentRequest = new PaymentRequest().setPaymentMethodId(UUID.randomUUID()).
                setAmount(12.45d).
                setCurrency(Moneta.HKD).
                setPayeeId(UUID.randomUUID()).
                setUserId(UUID.randomUUID());
    }

    @Test
    public void performAnalysis() {
        PaymentResponse paymentResponse = naiveRiskAnalysis.performAnalysis(Optional.of(paymentRequest));
        assertNotNull(paymentResponse);
    }
}
