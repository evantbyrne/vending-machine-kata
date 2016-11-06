package com.evanbyrne.vending_machine_kata.inventory;

/**
 * A single product.
 */
public class InventoryProduct {

    /**
     * Cost in cents of product.
     */
    private final int cents;

    /**
     * Product name.
     */
    private final String name;

    /**
     * Available stock.
     */
    private final int stock;

    /**
     * Constructor.
     *
     * @param Product name.
     * @param Available stock.
     * @param Cost in cents of product.
     */
    public InventoryProduct(final String name, final int stock, final int cents) {
        this.name = name;
        this.stock = stock;
        this.cents = cents;
    }

    /**
     * Get cents.
     *
     * @return Cost in cents of product.
     */
    public int getCents() {
        return this.cents;
    }

    /**
     * Get name.
     *
     * @return Product name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Get stock.
     *
     * @return Available stock.
     */
    public int getStock() {
        return this.stock;
    }

}
