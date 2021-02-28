package com.intuit.home.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.intuit.home.money.Moneta;

import java.util.Objects;
import java.util.UUID;

/**
 * Represents a payment request
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentRequest extends BaseRequest {
    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("currency")
    private Moneta currency;

    @JsonProperty("userId")
    private UUID userId;

    @JsonProperty("payeeId")
    private UUID payeeId;

    @JsonProperty("paymentMethodId")
    private UUID paymentMethodId;


    public Double getAmount() {
        return amount;
    }

    public PaymentRequest setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Moneta getCurrency() {
        return currency;
    }

    public PaymentRequest setCurrency(Moneta currency) {
        this.currency = currency;
        return this;
    }

    public UUID getUserId() {
        return userId;
    }

    public PaymentRequest setUserId(UUID userId) {
        this.userId = userId;
        return this;
    }

    public UUID getPayeeId() {
        return payeeId;
    }

    public PaymentRequest setPayeeId(UUID payeeId) {
        this.payeeId = payeeId;
        return this;
    }

    public UUID getPaymentMethodId() {
        return paymentMethodId;
    }

    public PaymentRequest setPaymentMethodId(UUID paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{ amount=").append(amount);
        sb.append(", currency=").append(currency);
        sb.append(", userId=").append(userId);
        sb.append(", payeeId=").append(payeeId);
        sb.append(", paymentMethodId=").append(paymentMethodId);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentRequest)) return false;
        PaymentRequest that = (PaymentRequest) o;
        return Objects.equals(getAmount(), that.getAmount()) && getCurrency() == that.getCurrency() && Objects.equals(getUserId(), that.getUserId()) && Objects.equals(getPayeeId(), that.getPayeeId()) && Objects.equals(getPaymentMethodId(), that.getPaymentMethodId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), getCurrency(), getUserId(), getPayeeId(), getPaymentMethodId());
    }
}
