package com.intuit.home.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


/**
 * +------------+--------------+------+-----+---------+-------+
 * | Field      | Type         | Null | Key | Default | Extra |
 * +------------+--------------+------+-----+---------+-------+
 * | payee_id   | binary(16)   | NO   | PRI | NULL    |       |
 * | first_name | varchar(3)   | NO   |     | NULL    |       |
 * | last_name  | varchar(100) | YES  |     | NULL    |       |
 * | email      | varchar(100) | YES  |     | NULL    |       |
 * +------------+--------------+------+-----+---------+-------+
 */
@Entity
@Table
public class Payee {
    @Id
    @Type(type="uuid-char")
    private UUID payeeId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;


    public UUID getPayeeId() {
        return payeeId;
    }

    public Payee setPayeeId(UUID payeeId) {
        this.payeeId = payeeId;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Payee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Payee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Payee setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{payeeId=").append(payeeId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
