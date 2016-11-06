package com.evanbyrne.vending_machine_kata.ui;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;

import org.jooq.lambda.tuple.Tuple2;

import com.evanbyrne.vending_machine_kata.coin.Cents;
import com.evanbyrne.vending_machine_kata.coin.Coin;
import com.evanbyrne.vending_machine_kata.coin.CoinCollection;
import com.evanbyrne.vending_machine_kata.coin.CoinFactory;
import com.evanbyrne.vending_machine_kata.inventory.IInventoryService;
import com.evanbyrne.vending_machine_kata.inventory.InventoryProduct;

/**
 * Manages console input and output.
 */
public class Console {

    /**
     * Get change display for terminal output.
     *
     * @param Change.
     * @return Formatted message.
     */
    public String getChangeDisplay(final CoinCollection change) {
        final ArrayList<String> display = new ArrayList<String>();
        final LinkedHashMap<Coin, Integer> coinMap = new LinkedHashMap<Coin, Integer>();

        display.add("THANK YOU");

        for(final Coin coin : change.getList()) {

            if(coinMap.containsKey(coin)) {
                coinMap.put(coin, coinMap.get(coin) + 1);
            } else {
                coinMap.put(coin, 1);
            }
        }

        if(!coinMap.isEmpty()) {
            final ArrayList<String> displayReturn = new ArrayList<String>();

            for(final Map.Entry<Coin, Integer> entry : coinMap.entrySet()) {
                final String name = entry.getKey().name().toLowerCase();
                final int count = entry.getValue();
                displayReturn.add(String.format("%s (x%d)", name, count));
            }

            display.add("RETURN: " + String.join(", ", displayReturn));
        }

        return String.join("\n", display);
    }

    /**
     * Get product listing display for terminal output.
     *
     * @param Sorted map of all inventory.
     * @return Formatted message.
     */
    public String getProductDisplay(final SortedMap<String, InventoryProduct> inventory) {

        if(!inventory.isEmpty()) {
            final ArrayList<String> display = new ArrayList<String>();

            for(final Map.Entry<String, InventoryProduct> entry : inventory.entrySet()) {
                final String centsString = Cents.toString(entry.getValue().getCents());
                final String name = entry.getValue().getName();
                final String key = entry.getKey();
                display.add(String.format("%s\t%s\t%s", key, centsString, name));
            }

            return String.join("\n", display);
        }

        return "No items in vending machine.";
    }

    /**
     * Prompt user for payment.
     *
     * Loops until payment >= selected product cost.
     *
     * @param Scanner.
     * @param A product representing their selection.
     * @return Payment.
     */
    public CoinCollection promptForPayment(final Scanner scanner, final InventoryProduct selection) {
        final CoinCollection paid = new CoinCollection();
        Coin insert;
        String input;

        do {
            System.out.println("PRICE: " + Cents.toString(selection.getCents()));
            do {
                System.out.print(String.format("INSERT COIN (%s): ", Cents.toString(paid.getTotal())));
                input = scanner.nextLine();
                insert = CoinFactory.getByName(input);
                if(insert == null) {
                    System.out.println("Invalid coin. This machine accepts: quarter, dime, nickel.");
                }
            } while(insert == null);
            paid.addCoin(insert);
        } while(paid.getTotal() < selection.getCents());

        return paid;
    }

    /**
     * Prompt for product selection.
     *
     * Loops until a valid product has been selected.
     *
     * @param Scanner
     * @param An implementation of IInventoryService.
     * @return A tuple with the product key and product.
     */
    public Tuple2<String, InventoryProduct> promptForSelection(final Scanner scanner, final IInventoryService inventoryService) {
        InventoryProduct selection;
        String input;

        do {
            System.out.print("SELECT: ");
            input = scanner.nextLine();
            selection = inventoryService.getProduct(input);

            if( selection == null ) {
                System.out.println("Invalid selection.");
            }
        } while(selection == null);

        return new Tuple2<String, InventoryProduct>(input, selection);
    }

}
