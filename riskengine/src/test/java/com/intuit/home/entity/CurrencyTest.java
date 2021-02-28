package com.intuit.home.entity;

import com.intuit.home.money.Moneta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CurrencyTest {
    private Currency currency;


    @BeforeEach
    public void setUp() {
        currency = new Currency().setIsoName(Moneta.AUD.name()).setDescription(Moneta.AUD.to());
    }

    @Test
    public void getIsoName() {
        assertEquals(currency.getIsoName(), Moneta.AUD.name());
    }

    @Test
    public void getDescription() {
        assertEquals(currency.getDescription(), Moneta.AUD.to());
    }

    @Test
    public void toString1() {
        assertTrue(currency.toString().contains(Currency.class.getSimpleName()));
    }
}
