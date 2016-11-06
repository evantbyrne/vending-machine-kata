package com.evanbyrne.vending_machine_kata.inventory;

import java.util.SortedMap;

/**
 * Common interface for all inventory management implementations.
 */
public interface IInventoryService {

    /**
     * Get a single product.
     *
     * @param Product key.
     * @return An product. Null if not found.
     */
    public InventoryProduct getProduct(String key);

    /**
     * Set a single product.
     *
     * @param Product key.
     * @param A product.
     */
    public void setProduct(String key, InventoryProduct inventoryProduct);

    /**
     * Get all products.
     *
     * @return A sorted map of product keys and products.
     */
    public SortedMap<String, InventoryProduct> getAllProducts();

    /**
     * Vend a single product.
     *
     * Should remove products from storage upon depletion of inventory.
     *
     * @param Product key.
     * @return A product.
     */
    public InventoryProduct vendProduct(String key);

}
