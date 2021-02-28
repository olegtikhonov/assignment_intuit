package com.intuit.home.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;


/**
 * +--------------------------------------+------------+-----------------+------------------------------------+
 * | payee_id                             | first_name | last_name       | email                              |
 * +--------------------------------------+------------+-----------------+------------------------------------+
 * | a3deb797-775d-11eb-aa2b-0242ac110002 | Philip J.  | Fry             | Philip.Fry@futurama.com            |
 * | a3debb66-775d-11eb-aa2b-0242ac110002 | Turanga    | Leela           | Turanga.Leela@futurama.com         |
 * | a3debdb6-775d-11eb-aa2b-0242ac110002 | Bender     | Simpson         | Bender.Rodriguez@futurama.com      |
 * | a3debf21-775d-11eb-aa2b-0242ac110002 | Amy        | Wong            | Amy.Wong@futurama.com              |
 * | a3dec0d2-775d-11eb-aa2b-0242ac110002 | Hermes     | Conrad          | Hermes.Conrad@futurama.com         |
 * | a3dec22d-775d-11eb-aa2b-0242ac110002 | Hubert J.  | Farnsworth      | Hubert.Farnsworth@futurama.com     |
 * | a3dec3ca-775d-11eb-aa2b-0242ac110002 | John       | Zoidberg        | John.Zoidberg@futurama.com         |
 * | a3dec508-775d-11eb-aa2b-0242ac110002 | Zapp       | Brannigan       | Zapp.Brannigan@futurama.com        |
 * | a3dec64d-775d-11eb-aa2b-0242ac110002 | Linda      | van Schoonhoven | Linda.van.Schoonhoven@futurama.com |
 * | a3dec78e-775d-11eb-aa2b-0242ac110002 | Barbados   | Slim            | Barbados.Slim@futurama.com         |
 * +--------------------------------------+------------+-----------------+------------------------------------+
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payee)) return false;
        Payee payee = (Payee) o;
        return Objects.equals(getPayeeId(), payee.getPayeeId()) && Objects.equals(getFirstName(), payee.getFirstName()) && Objects.equals(getLastName(), payee.getLastName()) && Objects.equals(getEmail(), payee.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPayeeId(), getFirstName(), getLastName(), getEmail());
    }
}
