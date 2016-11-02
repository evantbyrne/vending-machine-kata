package com.evanbyrne.vending_machine_kata.inventory;

public class InventoryProduct {

    private final String name;

    private final int stock;

    public InventoryProduct(final String name, final int stock) {
        this.name = name;
        this.stock = stock;
    }

    public String getName() {
        return this.name;
    }

    public int getStock() {
        return this.stock;
    }

}
