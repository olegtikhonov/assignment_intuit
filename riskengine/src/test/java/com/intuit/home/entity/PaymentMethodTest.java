package com.intuit.home.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentMethodTest {
    public static final String BANK_ACCOUNT = "1234567890989";
    public static final Integer PAYMENT_METHOD_TYPE_ID = 12;
    private PaymentMethod paymentMethod;

    @BeforeEach
    public void setUp() {
        paymentMethod = new PaymentMethod().setPaymentMethodId(UUID.randomUUID()).
                setBankAccount(BANK_ACCOUNT).
                setPayerId(UUID.randomUUID()).
                setPaymentMethodTypeId(PAYMENT_METHOD_TYPE_ID);
    }

    @Test
    public void getPaymentMethodId() {
        assertNotNull(paymentMethod.getPaymentMethodId());
    }

    @Test
    public void getBankAccount() {
        assertTrue(paymentMethod.getBankAccount().contains("0989"));
    }

    @Test
    public void getPayerId() {
        assertNotNull(paymentMethod.getPayerId());
    }

    @Test
    public void getPaymentMethodTypeId() {
        assertEquals(PAYMENT_METHOD_TYPE_ID, paymentMethod.getPaymentMethodTypeId());
    }

    @Test
    public void toString1() {
        assertTrue(paymentMethod.toString().contains(PaymentMethod.class.getSimpleName()));
    }
}
