package com.evanbyrne.vending_machine_kata.coin;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Helper class for USD conversations.
 */
public class Cents {

    /**
     * Convert an amount in cents to formatted USD.
     *
     * @param Cents.
     * @return Formatted USD.
     */
    public static String toString(final int cents) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(cents * 0.01);
    }

}
