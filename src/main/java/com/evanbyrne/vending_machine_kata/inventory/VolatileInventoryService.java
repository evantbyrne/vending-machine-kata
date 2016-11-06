package com.evanbyrne.vending_machine_kata.inventory;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Implementation of IInventoryService that does not persist data.
 */
public class VolatileInventoryService implements IInventoryService {

    /**
     * A sorted tree representing all available inventory.
     */
    private final TreeMap<String, InventoryProduct> inventory;

    /**
     * Constructor.
     */
    public VolatileInventoryService() {
        this.inventory = new TreeMap<String, InventoryProduct>();
    }

    /**
     * {@inheritDoc}
     */
    public InventoryProduct getProduct(final String key) {
        return this.inventory.get(key);
    }

    /**
     * {@inheritDoc}
     */
    public void setProduct(final String key, final InventoryProduct inventoryProduct) {
        this.inventory.put(key, inventoryProduct);
    }

    /**
     * {@inheritDoc}
     */
    public SortedMap<String, InventoryProduct> getAllProducts() {
        return this.inventory;
    }

    /**
     * {@inheritDoc}
     */
    public InventoryProduct vendProduct(final String key) {
        final InventoryProduct inventoryProduct = this.getProduct(key);

        if(inventoryProduct != null) {
            final int newStock = inventoryProduct.getStock() - 1;
            final InventoryProduct newInventoryProduct = new InventoryProduct(inventoryProduct.getName(), newStock, inventoryProduct.getCents());

            if(newStock > 0) {
                this.setProduct(key, newInventoryProduct);
            } else {
                this.inventory.remove(key);
            }

            return newInventoryProduct;
        }

        return null;
    }

}
