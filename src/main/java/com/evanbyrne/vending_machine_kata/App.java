package com.evanbyrne.vending_machine_kata;

import java.util.Scanner;

import org.jooq.lambda.tuple.Tuple2;

import com.evanbyrne.vending_machine_kata.coin.CoinCollection;
import com.evanbyrne.vending_machine_kata.inventory.IInventoryService;
import com.evanbyrne.vending_machine_kata.inventory.InventoryProduct;
import com.evanbyrne.vending_machine_kata.inventory.VolatileInventoryService;

import ui.Console;

public class App {

    public static void main(final String[] args) {
        final Console console = new Console();
        final IInventoryService inventoryService = new VolatileInventoryService();
        final Scanner scanner = new Scanner(System.in);

        // Load up our machine with products
        inventoryService.setProduct("A", new InventoryProduct("cola", 5, 100));
        inventoryService.setProduct("B", new InventoryProduct("chips", 2, 50));
        inventoryService.setProduct("C", new InventoryProduct("candy", 7, 65));

        do {
            // Select a product
            System.out.println(console.getProductDisplay(inventoryService.getAllProducts()));
            final Tuple2<String, InventoryProduct> selection = console.promptForSelection(scanner, inventoryService);

            // Accept coins
            final CoinCollection paid = console.promptForPayment(scanner, selection.v2);

            // Vend and return change
            inventoryService.vendProduct(selection.v1);
            final int changeTotal = paid.getTotal() - selection.v2.getCents();
            System.out.println(console.getChangeDisplay(paid.makeChange(changeTotal)));

            // Continue?
            System.out.print("CONTINUE (yes/no): ");
        } while(scanner.nextLine().equalsIgnoreCase("yes"));

        scanner.close();
    }
}
