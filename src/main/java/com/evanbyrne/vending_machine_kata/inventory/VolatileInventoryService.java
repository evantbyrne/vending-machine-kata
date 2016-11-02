package com.evanbyrne.vending_machine_kata.inventory;

import java.util.SortedMap;
import java.util.TreeMap;

public class VolatileInventoryService implements IInventoryService {

    private final TreeMap<String, InventoryProduct> inventory;

    public VolatileInventoryService() {
        this.inventory = new TreeMap<String, InventoryProduct>();
    }

    public InventoryProduct getProduct(final String key) {
        return this.inventory.get(key);
    }

    public void setProduct(final String key, final InventoryProduct inventoryProduct) {
        this.inventory.put(key, inventoryProduct);
    }

    public SortedMap<String, InventoryProduct> getAllProducts() {
        return this.inventory;
    }

    public InventoryProduct vendProduct(final String key) {
        final InventoryProduct inventoryProduct = this.getProduct(key);

        if(inventoryProduct != null) {
            final int newStock = inventoryProduct.getStock() - 1;

            if(newStock >= 0) {
                final InventoryProduct newInventoryProduct = new InventoryProduct(inventoryProduct.getName(), newStock);
                this.setProduct(key, newInventoryProduct);
                return newInventoryProduct;
            }

            this.inventory.remove(key);
        }

        return null;
    }

}
