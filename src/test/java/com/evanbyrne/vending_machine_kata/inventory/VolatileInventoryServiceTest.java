package com.evanbyrne.vending_machine_kata.inventory;

import static org.junit.Assert.*;

import org.junit.Test;

public class VolatileInventoryServiceTest {

    @Test
    public void testSetProduct() {
        final IInventoryService inventory = new VolatileInventoryService();
        assertEquals(0, inventory.getAllProducts().size());
        assertEquals(null, inventory.getProduct("A1"));

        inventory.setProduct("A", new InventoryProduct("foo", 5));
        assertEquals(1, inventory.getAllProducts().size());
        assertEquals("foo", inventory.getProduct("A").getName());
        assertEquals(5, inventory.getProduct("A").getStock());

        inventory.setProduct("B", new InventoryProduct("bar", 2));
        assertEquals(2, inventory.getAllProducts().size());
        assertEquals("foo", inventory.getProduct("A").getName());
        assertEquals(5, inventory.getProduct("A").getStock());
        assertEquals("bar", inventory.getProduct("B").getName());
        assertEquals(2, inventory.getProduct("B").getStock());
    }

    @Test
    public void testVendProduct() {
        final IInventoryService inventory = new VolatileInventoryService();
        InventoryProduct inventoryProduct = null;
        assertEquals(null, inventory.vendProduct("A"));

        inventory.setProduct("A", new InventoryProduct("foo", 5));
        inventoryProduct = inventory.vendProduct("A");
        assertNotEquals(null, inventoryProduct);
        assertEquals(4, inventoryProduct.getStock());

        inventory.setProduct("B", new InventoryProduct("foo", 2));
        inventoryProduct = inventory.vendProduct("B");
        assertNotEquals(null, inventoryProduct);
        assertEquals(1, inventoryProduct.getStock());

        inventoryProduct = inventory.vendProduct("B");
        assertNotEquals(null, inventoryProduct);
        assertEquals(0, inventoryProduct.getStock());

        inventoryProduct = inventory.vendProduct("B");
        assertEquals(null, inventoryProduct);
    }

}
