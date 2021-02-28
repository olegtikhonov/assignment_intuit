package com.intuit.home.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CurrencyTest {
    public static final String DESCRIPTION = "States bucks";
    public static final String ISO_NAME = "USD";
    private Currency currency;

    @BeforeEach
    public void setUp() {
        currency = new Currency().setDescription(DESCRIPTION).setIsoName(ISO_NAME);
    }

    @Test
    public void getIsoName() {
        assertEquals(ISO_NAME, currency.getIsoName());
    }

    @Test
    public void getDescription() {
        assertEquals(DESCRIPTION, currency.getDescription());
    }

    @Test
    public void testToString() {
        assertTrue(currency.toString().contains(Currency.class.getSimpleName()));
    }
}
