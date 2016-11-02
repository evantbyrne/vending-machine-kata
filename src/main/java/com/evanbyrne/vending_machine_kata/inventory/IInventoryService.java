package com.evanbyrne.vending_machine_kata.inventory;

import java.util.SortedMap;

public interface IInventoryService {

    public InventoryProduct getProduct(String key);

    public void setProduct(String key, InventoryProduct inventoryProduct);

    public SortedMap<String, InventoryProduct> getAllProducts();

    public InventoryProduct vendProduct(String key);

}
