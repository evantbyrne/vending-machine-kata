package com.evanbyrne.vending_machine_kata.coin;

import java.text.NumberFormat;
import java.util.Locale;

public class Cents {

    public static String toString(final int cents) {
        return NumberFormat.getCurrencyInstance(Locale.US).format(cents * 0.01);
    }

}
