package com.intuit.home.money;

/**
 * Short list of currencies.
 * https://en.wikipedia.org/wiki/ISO_4217
 *
 */
public enum Moneta {
    AED("United Arab Emirates dirham"),
    AUD("Australian dollar"),
    BRL("Brazilian real"),
    CAD("Canadian dollar"),
    CHF("Swiss franc"),
    EUR("Euro"),
    GBP("Pound sterling"),
    HKD("Hong Kong dollar"),
    ILS("Israeli new shekel"),
    INR("Indian rupee"),
    JPY("Japanese yen"),
    KRW("South Korean won"),
    KWD("Kuwaiti dinar"),
    MXN("Mexican peso"),
    NZD("New Zealand dollar"),
    QAR("Qatari riyal"),
    RUB("Russian ruble"),
    SAR("Saudi riyal"),
    SLL("Sierra Leonean leone"),
    TRY("Turkish lira"),
    USD("United States dollar"),
    CNY("Renminbi (Chinese) yuan");


    private String value;


    private Moneta(String value) {
        this.value = value;
    }

    /**
     * Gets a value.
     * In this case currency description.
     *
     * @return
     */
    public String to() {
        return this.value;
    }

}
