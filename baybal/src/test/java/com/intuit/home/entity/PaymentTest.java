package com.intuit.home.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


public class PaymentTest {
    public static final double AMOUNT = 12d;
    public static final Integer CURRENCY_ID = 21;
    public static final long PAYMENT_ID = 12L;
    public static final boolean SUCCEEDED = true;
    public static final double DELTA = 0.002;

    private Payment payment;

    @BeforeEach
    public void setUp() {
        payment = new Payment().setPaymentMethodId(UUID.randomUUID()).
                setAmount(AMOUNT).
                setCurrencyId(CURRENCY_ID).
                setPayeeId(UUID.randomUUID()).
                setPayerId(UUID.randomUUID()).
                setPaymentId(PAYMENT_ID).
                setSucceeded(SUCCEEDED);
    }

    @Test
    public void getPaymentId() {
        assertNotNull(payment.getPaymentId());
    }

    @Test
    public void getAmount() {
        assertEquals(AMOUNT, payment.getAmount(), DELTA);
    }

    @Test
    public void getCurrencyId() {
        assertEquals(CURRENCY_ID, payment.getCurrencyId());
    }

    @Test
    public void getPayerId() {
        assertNotNull(payment.getPayerId());
    }

    @Test
    public void getPayeeId() {
        assertNotNull(payment.getPayeeId());
    }

    @Test
    public void getPaymentMethodId() {
        assertNotNull(payment.getPaymentMethodId());
    }

    @Test
    public void getSucceeded() {
        assertTrue(payment.getSucceeded());
    }

    @Test
    public void toString1() {
        assertTrue(payment.toString().contains(Payment.class.getSimpleName()));
    }
}
