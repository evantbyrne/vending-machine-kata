package com.evanbyrne.vending_machine_kata.coin;

import static org.junit.Assert.*;

import org.junit.Test;

public class CentsTest {

    @Test
    public void testToString() {
        assertEquals("$0.50", Cents.toString(50));
        assertEquals("$1.00", Cents.toString(100));
        assertEquals("$1.25", Cents.toString(125));
        assertEquals("$2.65", Cents.toString(265));
    }

}
