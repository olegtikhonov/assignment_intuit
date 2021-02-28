package com.intuit.home;

import java.util.Random;

public final class TestUtils {
    private static final Random random = new Random();

    private TestUtils() {
    }

    /**
     * Generates random {@link String}.
     *
     * @return randomly generated {@link String} lower-case.
     */
    public static String next() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;

        StringBuilder buffer = new StringBuilder(targetStringLength);

        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int) (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();
    }
}
