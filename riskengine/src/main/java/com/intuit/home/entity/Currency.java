package com.intuit.home.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * +-------------+----------+-----------------------------+
 * | currency_id | iso_name | description                 |
 * +-------------+----------+-----------------------------+
 * |           1 | AED      | United Arab Emirates dirham |
 * |           2 | AUD      | Australian dollar           |
 * |           3 | BRL      | Brazilian real              |
 * |           4 | CAD      | Canadian dollar             |
 * |           5 | CHF      | Swiss franc                 |
 * |           6 | EUR      | Euro                        |
 * |           7 | GBP      | Pound sterling              |
 * |           8 | HKD      | Hong Kong dollar            |
 * |           9 | ILS      | Israeli new shekel          |
 * |          10 | INR      | Indian rupee                |
 * |          11 | JPY      | Japanese yen                |
 * |          12 | KRW      | South Korean won            |
 * |          13 | KWD      | Kuwaiti dinar               |
 * |          14 | MXN      | Mexican peso                |
 * |          15 | NZD      | New Zealand dollar          |
 * |          16 | QAR      | Qatari riyal                |
 * |          17 | RUB      | Russian ruble               |
 * |          18 | SAR      | Saudi riyal                 |
 * |          19 | SLL      | Sierra Leonean leone        |
 * |          20 | TRY      | Turkish lira                |
 * |          21 | USD      | United States dollar        |
 * |          22 | CNY      | Renminbi (Chinese) yuan     |
 * +-------------+----------+-----------------------------+
 *
 */
@Entity
@Table
public class Currency {
    @Id //must be initialized by the application
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer currencyId;

    @Column
    private String isoName;

    @Column
    private String description;


    public String getIsoName() {
        return isoName;
    }

    public Currency setIsoName(String isoName) {
        this.isoName = isoName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Currency setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public Currency setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency)) return false;
        Currency currency = (Currency) o;
        return Objects.equals(getCurrencyId(), currency.getCurrencyId()) && Objects.equals(getIsoName(), currency.getIsoName()) && Objects.equals(getDescription(), currency.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCurrencyId(), getIsoName(), getDescription());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Currency{");
        sb.append("currencyId=").append(currencyId);
        sb.append(", isoName='").append(isoName).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
