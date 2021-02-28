package com.intuit.home.common;

import com.intuit.home.entity.Payment;
import com.intuit.home.money.Moneta;
import com.intuit.home.request.PaymentRequest;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class RequestConverterTest {

    @Test
    public void toString1() {
        PaymentRequest paymentRequest = createPaymentRequest();

        String asAString = RequestConverter.toString(paymentRequest);
        assertNotNull(asAString);

        // case 2: null
        assertEquals("", RequestConverter.toString(null));
        // case 3: exception
        RequestConverter.toString(new ClassThatJacksonCannotSerialize());
        assertTrue(true);
    }

    @Test
    public void fromString() {
        String anInput = "{\"amount\":34.5,\"currency\":\"AED\",\"userId\":\"29061bcc-9eee-4cf6-a625-0f8a25df533b\",\"payeeId\":\"eef6d092-5275-4714-92e2-25c7bb6995cc\",\"paymentMethodId\":\"e48b73aa-ed76-401c-bff2-a7aab1d670e0\"}";
        Optional<PaymentRequest> paymentRequest = RequestConverter.fromString(anInput);
        assertTrue(paymentRequest.isPresent());

        // case 2: null
        assertFalse(RequestConverter.fromString(null).isPresent());

        // case 3:
        String json = "{\"animal\":{\"name\":\"lacy\"}}";
        assertNotNull(RequestConverter.fromString(json));
    }

    @Test
    public void toPayment() {
        PaymentRequest paymentRequest = createPaymentRequest();
        Payment result = RequestConverter.toPayment(paymentRequest);
        assertNotNull(result);

        // case 2: null
        assertNull(RequestConverter.toPayment(null));
    }

    private PaymentRequest createPaymentRequest() {
        return new PaymentRequest().setPaymentMethodId(UUID.randomUUID()).
                setPayeeId(UUID.randomUUID()).
                setUserId(UUID.randomUUID()).
                setCurrency(Moneta.AED).
                setAmount(34.5);
    }

    private static class ClassThatJacksonCannotSerialize {
        private final ClassThatJacksonCannotSerialize self = this;

        @Override
        public String toString() {
            return self.getClass().getName();
        }
    }
}
