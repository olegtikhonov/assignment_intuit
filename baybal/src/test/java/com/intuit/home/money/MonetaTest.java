package com.intuit.home.money;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MonetaTest {
    private static final String description = "Swiss franc";

    @Test
    public void to() {
        assertEquals(description, Moneta.CHF.to());
    }
}
