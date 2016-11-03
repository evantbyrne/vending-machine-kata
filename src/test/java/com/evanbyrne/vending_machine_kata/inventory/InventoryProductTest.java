package com.evanbyrne.vending_machine_kata.inventory;

import static org.junit.Assert.*;

import org.junit.Test;

public class InventoryProductTest {

    @Test
    public void testGetters() {
        final InventoryProduct inventoryProduct = new InventoryProduct("foo", 10, 100);
        assertEquals("foo", inventoryProduct.getName());
        assertEquals(10, inventoryProduct.getStock());
        assertEquals(100, inventoryProduct.getCents());
    }

}
