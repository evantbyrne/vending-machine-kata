package ui;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;

import com.evanbyrne.vending_machine_kata.coin.Cents;
import com.evanbyrne.vending_machine_kata.coin.Coin;
import com.evanbyrne.vending_machine_kata.coin.CoinCollection;
import com.evanbyrne.vending_machine_kata.inventory.IInventoryService;
import com.evanbyrne.vending_machine_kata.inventory.InventoryProduct;

public class Console {

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

    public CoinCollection promptForPayment(final Scanner scanner, final InventoryProduct selection) {
        // TODO: Not implemented.
        return null;
    }

    public InventoryProduct promptForSelection(final Scanner scanner, final IInventoryService inventoryService) {
        // TODO: Not implemented.
        return null;
    }

}
