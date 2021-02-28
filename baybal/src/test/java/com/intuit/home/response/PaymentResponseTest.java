package com.intuit.home.response;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentResponseTest {
    public static final Long PAYMENT_ID = 1L;
    public static final Double AMOUNT = 23d;
    public static final Integer CURRENCY_ID = 11;
    public static final Boolean SUCCEEDED = true;
    private PaymentResponse paymentResponse;


    @BeforeEach
    public void setUp() {
        paymentResponse = new PaymentResponse().setPaymentId(PAYMENT_ID).
                setPaymentMethodId(UUID.randomUUID()).
                setAmount(AMOUNT).
                setCurrencyId(CURRENCY_ID).
                setPayeeId(UUID.randomUUID()).
                setPayerId(UUID.randomUUID()).
                setSucceeded(SUCCEEDED);
    }

    @Test
    public void getPaymentId() {
        assertEquals(PAYMENT_ID, paymentResponse.getPaymentId());
    }

    @Test
    public void getAmount() {
        assertEquals(AMOUNT, paymentResponse.getAmount());
    }

    @Test
    public void getCurrencyId() {
        assertEquals(CURRENCY_ID, paymentResponse.getCurrencyId());
    }

    @Test
    public void getPayerId() {
        assertNotNull(paymentResponse.getPayerId());
    }

    @Test
    public void getPayeeId() {
        assertNotNull(paymentResponse.getPayeeId());
    }

    @Test
    public void getPaymentMethodId() {
        assertNotNull(paymentResponse.getPaymentMethodId());
    }

    @Test
    public void getSucceeded() {
        assertEquals(SUCCEEDED, paymentResponse.getSucceeded());
    }

    @Test
    public void toString1() {
        assertTrue(paymentResponse.toString().contains(PaymentResponse.class.getSimpleName()));
    }
}
