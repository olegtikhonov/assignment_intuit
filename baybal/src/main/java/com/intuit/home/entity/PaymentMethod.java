package com.intuit.home.entity;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


/**
 * +------------------------+-------------+------+-----+---------+-------+
 * | Field                  | Type        | Null | Key | Default | Extra |
 * +------------------------+-------------+------+-----+---------+-------+
 * | payment_method_id      | binary(16)  | NO   | PRI | NULL    |       |
 * | bank_account           | varchar(12) | YES  |     | NULL    |       |
 * | payer_id               | binary(16)  | YES  | MUL | NULL    |       |
 * | payment_method_type_id | int(11)     | YES  | MUL | NULL    |       |
 * +------------------------+-------------+------+-----+---------+-------+
 */
@Entity
@Table(name = "payment_method")
public class PaymentMethod {
    @Id
    @Type(type="uuid-char")
    private UUID paymentMethodId;

    @Column
    private String bankAccount;

    //@JoinColumn defines foreign key column and indicates the owner of the relationship.
    // payer
    @Column
    @Type(type="uuid-char") // important
    private UUID payerId;

    //@JoinColumn defines foreign key column and indicates the owner of the relationship.
    // payment_method_type
    @Column
    private Integer paymentMethodTypeId;


    public UUID getPaymentMethodId() {
        return paymentMethodId;
    }

    public PaymentMethod setPaymentMethodId(UUID paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
        return this;
    }

    public String getBankAccount() {
        if(bankAccount == null || bankAccount.isEmpty()) {
            return "";
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(').append('*').append( bankAccount.substring(bankAccount.length() - 4)).append(')');
        return stringBuffer.toString();
    }

    public PaymentMethod setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public UUID getPayerId() {
        return payerId;
    }

    public PaymentMethod setPayerId(UUID payerId) {
        this.payerId = payerId;
        return this;
    }

    public Integer getPaymentMethodTypeId() {
        return paymentMethodTypeId;
    }

    public PaymentMethod setPaymentMethodTypeId(Integer paymentMethodTypeId) {
        this.paymentMethodTypeId = paymentMethodTypeId;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{paymentMethodId=").append(paymentMethodId);
        sb.append(", bankAccount='").append(bankAccount).append('\'');
        sb.append(", payerId=").append(payerId);
        sb.append(", paymentMethodTypeId=").append(paymentMethodTypeId);
        sb.append('}');
        return sb.toString();
    }
}
