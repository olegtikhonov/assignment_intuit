package com.intuit.home.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;


public class PayeeTest {
    public static final String EMAIL = "Bender.Bending.Rodriguez@futurama.com";
    public static final String FIRST_NAME = "Bender";
    public static final String LAST_NAME = "Rodriguez";
    private Payee payee;

    @BeforeEach
    public void setUp() {
        payee = new Payee().setEmail(EMAIL).
                setFirstName(FIRST_NAME).
                setLastName(LAST_NAME).
                setPayeeId(UUID.randomUUID());
    }

    @Test
    public void getPayeeId() {
        assertNotNull(payee.getPayeeId());
    }

    @Test
    public void getFirstName() {
        assertEquals(FIRST_NAME, payee.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals(LAST_NAME, payee.getLastName());
    }

    @Test
    public void getEmail() {
        assertEquals(EMAIL, payee.getEmail());
    }

    @Test
    public void toString1() {
        assertTrue(payee.toString().contains(Payee.class.getSimpleName()));
    }
}
