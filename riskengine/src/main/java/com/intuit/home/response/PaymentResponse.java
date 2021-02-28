package com.intuit.home.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;
import java.util.Objects;
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

    private Map<String, String> details;


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

    public Map<String, String> getDetails() {
        return details;
    }

    public PaymentResponse setDetails(Map<String, String> details) {
        this.details = details;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentResponse)) return false;
        PaymentResponse that = (PaymentResponse) o;
        return Objects.equals(getPaymentId(), that.getPaymentId()) && Objects.equals(getAmount(), that.getAmount()) && Objects.equals(getCurrencyId(), that.getCurrencyId()) && Objects.equals(getPayerId(), that.getPayerId()) && Objects.equals(getPayeeId(), that.getPayeeId()) && Objects.equals(getPaymentMethodId(), that.getPaymentMethodId()) && Objects.equals(getSucceeded(), that.getSucceeded()) && Objects.equals(getDetails(), that.getDetails());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaymentId(), getAmount(), getCurrencyId(), getPayerId(), getPayeeId(), getPaymentMethodId(), getSucceeded(), getDetails());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PaymentResponse{");
        sb.append("paymentId=").append(paymentId);
        sb.append(", amount=").append(amount);
        sb.append(", currencyId=").append(currencyId);
        sb.append(", payerId=").append(payerId);
        sb.append(", payeeId=").append(payeeId);
        sb.append(", paymentMethodId=").append(paymentMethodId);
        sb.append(", succeeded=").append(succeeded);
        sb.append(", details=").append(details);
        sb.append('}');
        return sb.toString();
    }
}
