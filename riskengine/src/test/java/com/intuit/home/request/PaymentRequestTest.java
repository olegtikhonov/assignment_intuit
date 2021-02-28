package com.intuit.home.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.home.money.Moneta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PaymentRequestTest {

    public static final double AMOUNT = 70.6d;
    public static final double DELTA = 0.001d;
    private PaymentRequest paymentRequest;


    @BeforeEach
    public void setUp() {
        paymentRequest = new PaymentRequest();
    }

    @Test
    public void getAmount() {
        paymentRequest.setAmount(AMOUNT);
        assertEquals(AMOUNT, paymentRequest.getAmount(), DELTA);
    }

    @Test
    public void getCurrency() {
        paymentRequest.setCurrency(Moneta.USD);
        assertEquals(Moneta.USD, paymentRequest.getCurrency());
    }

    @Test
    public void getUserId() {
        UUID userID = UUID.randomUUID();
        paymentRequest.setUserId(userID);
        assertEquals(userID, paymentRequest.getUserId());
    }

    @Test
    public void getPayeeId() {
        UUID payeeID = UUID.randomUUID();
        paymentRequest.setPayeeId(payeeID);
        assertEquals(payeeID, paymentRequest.getPayeeId());
    }

    @Test
    public void getPaymentMethodId() {
        UUID paymentMethodID = UUID.randomUUID();
        paymentRequest.setPaymentMethodId(paymentMethodID);
        assertEquals(paymentMethodID, paymentRequest.getPaymentMethodId());
    }

    @Test
    public void testToString() {
        assertTrue(paymentRequest.toString().contains(PaymentRequest.class.getSimpleName()));
    }

    @Test
    public void testPojoToString() {
        ObjectMapper objectMapper = new ObjectMapper();

        paymentRequest.setPaymentMethodId(UUID.randomUUID());
        paymentRequest.setPayeeId(UUID.randomUUID());
        paymentRequest.setUserId(UUID.randomUUID());
        paymentRequest.setCurrency(Moneta.CAD);
        paymentRequest.setAmount(AMOUNT);

        try {
            System.out.println(objectMapper.writeValueAsString(paymentRequest));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
