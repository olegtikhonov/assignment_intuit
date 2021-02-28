package com.intuit.home.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;


/**
 * +------------+--------------+------+-----+---------+-------+
 * | Field      | Type         | Null | Key | Default | Extra |
 * +------------+--------------+------+-----+---------+-------+
 * | payer_id   | binary(16)   | NO   | PRI | NULL    |       |
 * | first_name | varchar(100) | NO   |     | NULL    |       |
 * | last_name  | varchar(100) | YES  |     | NULL    |       |
 * | email      | varchar(100) | YES  |     | NULL    |       |
 * +------------+--------------+------+-----+---------+-------+
 */
@Entity
@Table
public class Payer {
    @Id
    @Type(type="uuid-char")
    private UUID payerId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    private String urlCallback;

    @Column
    public UUID getPayerId() {
        return payerId;
    }

    public Payer setPayerId(UUID payerId) {
        this.payerId = payerId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Payer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Payer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Payer setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getCallbackUrl() {
        return urlCallback;
    }

    public Payer setCallbackUrl(String callbackUrl) {
        this.urlCallback = callbackUrl;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payer)) return false;
        Payer payer = (Payer) o;
        return Objects.equals(getPayerId(), payer.getPayerId()) && Objects.equals(getFirstName(), payer.getFirstName()) && Objects.equals(getLastName(), payer.getLastName()) && Objects.equals(getEmail(), payer.getEmail()) && Objects.equals(getCallbackUrl(), payer.getCallbackUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPayerId(), getFirstName(), getLastName(), getEmail(), getCallbackUrl());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Payer{");
        sb.append("payerId=").append(payerId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", callbackUrl='").append(urlCallback).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
