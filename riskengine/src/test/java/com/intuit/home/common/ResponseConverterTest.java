package com.intuit.home.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.home.TestUtils;
import com.intuit.home.response.PaymentResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ResponseConverterTest {

    @Test
    void testToString() {
        PaymentResponse paymentResponse = new PaymentResponse().setPaymentId(1l).setPaymentMethodId(UUID.randomUUID()).setPayeeId(UUID.randomUUID());
        assertNotNull(ResponseConverter.toString(paymentResponse));
    }

    @Test
    void fromString() {
        PaymentResponse paymentResponse = new PaymentResponse();
        ObjectMapper mapper = new ObjectMapper();
        try {
            String toBeConverted = mapper.writeValueAsString(paymentResponse);
            assertNotNull(ResponseConverter.fromString(toBeConverted).get());
        } catch (JsonProcessingException e) {
            assertFalse(true);
        }

    }

    @Test
    void toPayment() {
        PaymentResponse paymentResponse = new PaymentResponse().setPaymentId(1l).setPaymentMethodId(UUID.randomUUID()).setPayeeId(UUID.randomUUID());
        assertNotNull(ResponseConverter.toPayment(paymentResponse));
    }
}