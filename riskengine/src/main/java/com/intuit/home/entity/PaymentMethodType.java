package com.intuit.home.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * +------------------------+-------------+------+-----+---------+----------------+
 * | Field                  | Type        | Null | Key | Default | Extra          |
 * +------------------------+-------------+------+-----+---------+----------------+
 * | payment_method_type_id | int(11)     | NO   | PRI | NULL    | auto_increment |
 * | type                   | varchar(25) | NO   |     | NULL    |                |
 * +------------------------+-------------+------+-----+---------+----------------+
 * <p>
 * +------------------------+----------------+
 * | payment_method_type_id | type           |
 * +------------------------+----------------+
 * |                      1 | DIRECT_DEPOSIT |
 * |                      2 | CREDIT_CARD    |
 * |                      3 | MOBILE_PAYMENT |
 * |                      4 | BANK_TRANSFER  |
 * |                      5 | E-WALLET       |
 * |                      6 | PREPAID_CARD   |
 * +------------------------+----------------+
 */
@Entity
@Table
public class PaymentMethodType {
    @Id
    @Column
    private Integer paymentMethodTypeId;

    @Column
    private String type;


    public Integer getPaymentMethodTypeId() {
        return paymentMethodTypeId;
    }

    public PaymentMethodType setPaymentMethodTypeId(Integer paymentMethodTypeId) {
        this.paymentMethodTypeId = paymentMethodTypeId;
        return this;
    }

    public String getType() {
        return type;
    }

    public PaymentMethodType setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{paymentMethodTypeId=").append(paymentMethodTypeId);
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
