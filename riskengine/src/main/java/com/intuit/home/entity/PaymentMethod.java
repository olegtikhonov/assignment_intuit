package com.intuit.home.entity;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
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
 * <p>
 * +--------------------------------------+--------------+--------------------------------------+------------------------+
 * | payment_method_id                    | bank_account | payer_id                             | payment_method_type_id |
 * +--------------------------------------+--------------+--------------------------------------+------------------------+
 * | a3e26bb6-775d-11eb-aa2b-0242ac110002 | 012345678922 | a3dbb66a-775d-11eb-aa2b-0242ac110002 |                      1 |
 * | a3e27561-775d-11eb-aa2b-0242ac110002 | 022345678922 | a3dbbc6a-775d-11eb-aa2b-0242ac110002 |                      2 |
 * | a3e27b5a-775d-11eb-aa2b-0242ac110002 | 032345678922 | a3dbc09b-775d-11eb-aa2b-0242ac110002 |                      6 |
 * | a3e28027-775d-11eb-aa2b-0242ac110002 | 042345678922 | a3dbc312-775d-11eb-aa2b-0242ac110002 |                      6 |
 * | a3e282d9-775d-11eb-aa2b-0242ac110002 | 052345678922 | a3dbc581-775d-11eb-aa2b-0242ac110002 |                      4 |
 * | a3e2ab1b-775d-11eb-aa2b-0242ac110002 | 062345678922 | a3dbc7e2-775d-11eb-aa2b-0242ac110002 |                      5 |
 * | a3e2b211-775d-11eb-aa2b-0242ac110002 | 072345678922 | a3dbd72c-775d-11eb-aa2b-0242ac110002 |                      3 |
 * | a3e2b711-775d-11eb-aa2b-0242ac110002 | 082345678922 | a3dbda2d-775d-11eb-aa2b-0242ac110002 |                      2 |
 * | a3e2bebc-775d-11eb-aa2b-0242ac110002 | 092345678922 | a3dbdc96-775d-11eb-aa2b-0242ac110002 |                      4 |
 * | a3e2c5c9-775d-11eb-aa2b-0242ac110002 | 093345678922 | a3dbe019-775d-11eb-aa2b-0242ac110002 |                      6 |
 * | a3e2d322-775d-11eb-aa2b-0242ac110002 | 093345678922 | a3dbe019-775d-11eb-aa2b-0242ac110002 |                      5 |
 * | a3e2dbbb-775d-11eb-aa2b-0242ac110002 | 093355678922 | a3dbe019-775d-11eb-aa2b-0242ac110002 |                      2 |
 * +--------------------------------------+--------------+--------------------------------------+------------------------+
 */
@Entity
@Table
public class PaymentMethod {
    @Id
    @Type(type = "uuid-char")
    private UUID paymentMethodId;

    @Column
    private String bankAccount;

    @Column
    @Type(type = "uuid-char") // important
    private UUID payerId;

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
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(').append('*').append(bankAccount.substring(bankAccount.length() - 4)).append(')');
        return (this.bankAccount != null && !this.bankAccount.isEmpty()) ? stringBuffer.toString() : "";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentMethod)) return false;
        PaymentMethod that = (PaymentMethod) o;
        return Objects.equals(getPaymentMethodId(), that.getPaymentMethodId()) && Objects.equals(getBankAccount(), that.getBankAccount()) && Objects.equals(getPayerId(), that.getPayerId()) && Objects.equals(getPaymentMethodTypeId(), that.getPaymentMethodTypeId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPaymentMethodId(), getBankAccount(), getPayerId(), getPaymentMethodTypeId());
    }
}
