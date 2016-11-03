package com.evanbyrne.vending_machine_kata.inventory;

public class InventoryProduct {

    private final int cents;

    private final String name;

    private final int stock;

    public InventoryProduct(final String name, final int stock, final int cents) {
        this.name = name;
        this.stock = stock;
        this.cents = cents;
    }

    public int getCents() {
        return this.cents;
    }

    public String getName() {
        return this.name;
    }

    public int getStock() {
        return this.stock;
    }

}
