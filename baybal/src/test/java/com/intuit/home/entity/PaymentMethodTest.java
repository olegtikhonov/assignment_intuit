package com.intuit.home.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentMethodTest {
    public static final int PAYMENT_METHOD_TYPE_ID = 11;
    public static final String BANK_ACCOUNT = "1234567890123";
    private PaymentMethod paymentMethod;

    @BeforeEach
    public void setUp() {
        paymentMethod = new PaymentMethod().setPaymentMethodTypeId(PAYMENT_METHOD_TYPE_ID).
                setPaymentMethodId(UUID.randomUUID()).
                setBankAccount(BANK_ACCOUNT).
                setPayerId(UUID.randomUUID());
    }

    @Test
    public void getPaymentMethodId() {
        assertNotNull(paymentMethod.getPaymentMethodId());
    }

    @Test
    public void getBankAccount() {
        // case != null
        assertNotNull(paymentMethod.getBankAccount());
        // case null
        paymentMethod.setBankAccount(null);
        assertEquals("", paymentMethod.getBankAccount());
        // case: an empty string
        paymentMethod.setBankAccount("");
        assertEquals("", paymentMethod.getBankAccount());
    }

    @Test
    public void getPayerId() {
        assertNotNull(paymentMethod.getPayerId());
    }

    @Test
    public void getPaymentMethodTypeId() {
        assertNotNull(paymentMethod.getPaymentMethodTypeId());
    }

    @Test
    public void toString1() {
        assertTrue(paymentMethod.toString().contains(PaymentMethod.class.getSimpleName()));
    }
}
