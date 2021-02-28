package com.intuit.home.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


public class PayerTest {
    public static final String FIRST_NAME = "Barney";
    public static final String LAST_NAME = "Gumble";
    public static final String EMAIL = "Barney.Gumble@simpsons.com";
    private Payer payer;

    @BeforeEach
    public void setUp() {
        payer = new Payer().setPayerId(UUID.randomUUID()).setFirstName(FIRST_NAME).setLastName(LAST_NAME).setEmail(EMAIL);
    }

    @Test
    public void getPayerId() {
        assertNotNull(payer.getPayerId());
    }

    @Test
    public void getFirstName() {
        assertEquals(FIRST_NAME, payer.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals(LAST_NAME, payer.getLastName());
    }

    @Test
    public void getEmail() {
        assertEquals(EMAIL, payer.getEmail());
    }

    @Test
    public void toString1() {
        assertTrue(payer.toString().contains(Payer.class.getSimpleName()));
    }
}
