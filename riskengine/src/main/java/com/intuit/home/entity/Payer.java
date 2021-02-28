package com.intuit.home.entity;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;


/**
 * +--------------------------------------+------------+--------------------+-------------------------------------+----------------------------------------------+
 * | payer_id                             | first_name | last_name          | email                               | url_callback                                 |
 * +--------------------------------------+------------+--------------------+-------------------------------------+----------------------------------------------+
 * | a3dbb66a-775d-11eb-aa2b-0242ac110002 | Homer      | Simpson            | Homer.Simpson@simpsons.com          | http://localhost:1000/users/homer/callback   |
 * | a3dbbc6a-775d-11eb-aa2b-0242ac110002 | Marge      | Simpson            | Marge.Simpson@simpsons.com          | http://localhost:1000/users/marge/callback   |
 * | a3dbc09b-775d-11eb-aa2b-0242ac110002 | Bart       | Simpson            | Bart.Simpson@simpsons.com           | http://localhost:1000/users/bart/callback    |
 * | a3dbc312-775d-11eb-aa2b-0242ac110002 | Lisa       | Simpson            | Lisa.Simpson@simpsons.com           | http://localhost:1000/users/lisa/callback    |
 * | a3dbc581-775d-11eb-aa2b-0242ac110002 | Maggie     | Simpson            | Lisa.Simpson@simpsons.com           | http://localhost:1000/users/lisa/callback    |
 * | a3dbc7e2-775d-11eb-aa2b-0242ac110002 | Abraham    | Simpson            | Abraham.Simpson@simpsons.com        | http://localhost:1000/users/abraham/callback |
 * | a3dbd72c-775d-11eb-aa2b-0242ac110002 | Apu        | Nahasapeemapetilon | Apu.Nahasapeemapetilon@simpsons.com | http://localhost:1000/users/apu/callback     |
 * | a3dbda2d-775d-11eb-aa2b-0242ac110002 | Barney     | Gumble             | Barney.Gumble@simpsons.com          | http://localhost:1000/users/barney/callback  |
 * | a3dbdc96-775d-11eb-aa2b-0242ac110002 | Dewey      | Largo              | Dewey.Largo@simpsons.com            | http://localhost:1000/users/dewey/callback   |
 * | a3dbe019-775d-11eb-aa2b-0242ac110002 | Edna       | Krabappel          | Edna.Krabappel@simpsons.com         | http://localhost:1000/users/edna/callback    |
 * +--------------------------------------+------------+--------------------+-------------------------------------+----------------------------------------------+
 */
@Entity
@Table
public class Payer {
    @Id
    @Type(type = "uuid-char")
    private UUID payerId;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String urlCallback;

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

    public String getUrlCallback() {
        return urlCallback;
    }

    public Payer setUrlCallback(String urlCallback) {
        this.urlCallback = urlCallback;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payer)) return false;
        Payer payer = (Payer) o;
        return Objects.equals(getPayerId(), payer.getPayerId()) && Objects.equals(getFirstName(), payer.getFirstName()) && Objects.equals(getLastName(), payer.getLastName()) && Objects.equals(getEmail(), payer.getEmail()) && Objects.equals(getUrlCallback(), payer.getUrlCallback());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPayerId(), getFirstName(), getLastName(), getEmail(), getUrlCallback());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("{payerId=").append(payerId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", urlCallback='").append(urlCallback).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
