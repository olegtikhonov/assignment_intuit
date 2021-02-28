package com.intuit.home.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.home.entity.Payment;
import com.intuit.home.request.PaymentRequest;
import com.intuit.home.response.PaymentResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Optional;

/**
 * Utility which converts {@link PaymentRequest}
 */
public final class ResponseConverter {
    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static Logger logger = LogManager.getLogger(ResponseConverter.class);


    private ResponseConverter() {}


    /**
     * Converts an {@link Object} to JSON as String
     *
     * @param toBeConverted
     *
     * @return json as payment request.
     */
    public static String toString(Object toBeConverted) {
        try {
            return (toBeConverted != null) ? objectMapper.writeValueAsString(toBeConverted) : "";
        } catch (JsonProcessingException e) {
            logger.error("error {}", e);
        }

        return "";
    }

    /**
     * Create a pojo from {@link String}.
     *
     * @param anObject to be converted.
     *
     * @return a paymentRequest as an optional or empty.
     */
    public static Optional<PaymentResponse> fromString(String anObject) {
        try {
            return (anObject != null) ? Optional.of(objectMapper.readValue(anObject, PaymentResponse.class)) : Optional.empty();
        } catch (IOException e) {
            logger.error("error {}", e);
        }
        return Optional.empty();
    }

    /**
     * Converts {@link PaymentRequest} to {@link Payment}
     *
     * @param paymentResponse to be converted
     *
     * @return an entiry.
     * TODO: add repository to get currency ID
     */
    public static Payment toPayment(PaymentResponse paymentResponse) {
        return (paymentResponse != null) ? new Payment().setAmount(paymentResponse.getAmount()).
                                                        setCurrencyId(paymentResponse.getCurrencyId()).
                                                        setPayerId(paymentResponse.getPayerId()).
                                                        setPayeeId(paymentResponse.getPayeeId()).
                                                        setPaymentMethodId(paymentResponse.getPaymentMethodId()) : null;
    }
}
