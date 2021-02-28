package com.intuit.home.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.home.entity.Payment;
import com.intuit.home.money.Moneta;
import com.intuit.home.request.PaymentRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Optional;

/**
 * Utility which converts {@link com.intuit.home.request.PaymentRequest}
 */
public final class RequestConverter {
    private final static ObjectMapper objectMapper = new ObjectMapper();
    private final static Logger logger = LogManager.getLogger(RequestConverter.class);


    private RequestConverter() {}


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
    public static Optional<PaymentRequest> fromString(String anObject) {
        try {
            return (anObject != null) ? Optional.of(objectMapper.readValue(anObject, PaymentRequest.class)) : Optional.empty();
        } catch (IOException e) {
            logger.error("error {}", e);
        }
        return Optional.empty();
    }

    /**
     * Converts {@link PaymentRequest} to {@link Payment}
     *
     * @param paymentRequest to be converted
     *
     * @return an entiry.
     * TODO: add repository to get currency ID
     */
    public static Payment toPayment(PaymentRequest paymentRequest) {
        return (paymentRequest != null) ? new Payment().setAmount(paymentRequest.getAmount()).
                                                        setCurrencyId(paymentRequest.getCurrency().ordinal() + 1).
                                                        setPayerId(paymentRequest.getUserId()).
                                                        setPayeeId(paymentRequest.getPayeeId()).
                                                        setPaymentMethodId(paymentRequest.getPaymentMethodId()) : null;
    }
}
