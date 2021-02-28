package com.intuit.home.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;


/**
 * Represents a response
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentResponse {
    @JsonProperty("paymentId")
    private Long paymentId;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("currencyId")
    private Integer currencyId;

    @JsonProperty("payerId")
    private UUID payerId;

    @JsonProperty("payeeId")
    private UUID payeeId;

    @JsonProperty("paymentMethodId")
    private UUID paymentMethodId;

    @JsonProperty("succeeded")
    private Boolean succeeded;


    public Long getPaymentId() {
        return paymentId;
    }

    public PaymentResponse setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public PaymentResponse setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public PaymentResponse setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
        return this;
    }

    public UUID getPayerId() {
        return payerId;
    }

    public PaymentResponse setPayerId(UUID payerId) {
        this.payerId = payerId;
        return this;
    }

    public UUID getPayeeId() {
        return payeeId;
    }

    public PaymentResponse setPayeeId(UUID payeeId) {
        this.payeeId = payeeId;
        return this;
    }

    public UUID getPaymentMethodId() {
        return paymentMethodId;
    }

    public PaymentResponse setPaymentMethodId(UUID paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
        return this;
    }

    public Boolean getSucceeded() {
        return succeeded;
    }

    public PaymentResponse setSucceeded(Boolean succeeded) {
        this.succeeded = succeeded;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{paymentId=").append(paymentId);
        sb.append(", amount=").append(amount);
        sb.append(", currencyId=").append(currencyId);
        sb.append(", payerId=").append(payerId);
        sb.append(", payeeId=").append(payeeId);
        sb.append(", paymentMethodId=").append(paymentMethodId);
        sb.append(", succeeded=").append(succeeded);
        sb.append('}');
        return sb.toString();
    }
}
