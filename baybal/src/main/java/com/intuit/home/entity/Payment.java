package com.intuit.home.entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;


/**
 * +-------------------+---------------+------+-----+---------+----------------+
 * | Field             | Type          | Null | Key | Default | Extra          |
 * +-------------------+---------------+------+-----+---------+----------------+
 * | payment_id        | bigint(20)    | NO   | PRI | NULL    | auto_increment |
 * | ammount           | decimal(13,2) | YES  |     | NULL    |                |
 * | iso_name          | varchar(3)    | YES  | MUL | NULL    |                |
 * | payer_id          | binary(16)    | YES  | MUL | NULL    |                |
 * | payee_id          | binary(16)    | YES  | MUL | NULL    |                |
 * | payment_method_id | binary(16)    | YES  | MUL | NULL    |                |
 * | succeeded         | tinyint(1)    | YES  |     | NULL    |                |
 * +-------------------+---------------+------+-----+---------+----------------+
 *
 * +------------+--------+-------------+--------------------------------------+--------------------------------------+--------------------------------------+-----------+
 * | payment_id | amount | currency_id | payer_id                             | payee_id                             | payment_method_id                    | succeeded |
 * +------------+--------+-------------+--------------------------------------+--------------------------------------+--------------------------------------+-----------+
 * |          1 |  78.90 |          21 | 2f051590-933a-11e9-a9c3-0242ac110003 | 2f0618d3-933a-11e9-a9c3-0242ac110003 | 2f08c100-933a-11e9-a9c3-0242ac110003 |         1 |
 * +------------+--------+-------------+--------------------------------------+--------------------------------------+--------------------------------------+-----------+
 *
 */
@Entity
@Table
public class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long paymentId;

    @Column
    private Double amount;

    @Column
    private Integer currencyId;

    @Column
    @Type(type="uuid-char")
    private UUID payerId;

    @Column
    @Type(type="uuid-char")
    private UUID payeeId;

    @Column
    @Type(type="uuid-char")
    private UUID paymentMethodId;

    @Column(columnDefinition = "BOOLEAN")
    private Boolean succeeded;


    public Long getPaymentId() {
        return paymentId;
    }

    public Payment setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
        return this;
    }

    public Double getAmount() {
        return amount;
    }

    public Payment setAmount(Double amount) {
        this.amount = amount;
        return this;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public Payment setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
        return this;
    }

    public UUID getPayerId() {
        return payerId;
    }

    public Payment setPayerId(UUID payerId) {
        this.payerId = payerId;
        return this;
    }

    public UUID getPayeeId() {
        return payeeId;
    }

    public Payment setPayeeId(UUID payeeId) {
        this.payeeId = payeeId;
        return this;
    }

    public UUID getPaymentMethodId() {
        return paymentMethodId;
    }

    public Payment setPaymentMethodId(UUID paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
        return this;
    }

    public Boolean getSucceeded() {
        return succeeded;
    }

    public Payment setSucceeded(Boolean succeeded) {
        this.succeeded = succeeded;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{paymentId=").append(paymentId);
        sb.append(", amount=").append(amount);
        sb.append(", currency_id='").append(currencyId).append('\'');
        sb.append(", payerId='").append(payerId).append('\'');
        sb.append(", payeeId='").append(payeeId).append('\'');
        sb.append(", paymentMethodId='").append(paymentMethodId).append('\'');
        sb.append(", succeeded=").append(succeeded);
        sb.append('}');
        return sb.toString();
    }
}
