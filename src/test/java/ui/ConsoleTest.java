package ui;

import static org.junit.Assert.*;

import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Test;

import com.evanbyrne.vending_machine_kata.coin.Coin;
import com.evanbyrne.vending_machine_kata.coin.CoinCollection;
import com.evanbyrne.vending_machine_kata.inventory.InventoryProduct;

public class ConsoleTest {

    @Test
    public void testChangeDisplay() {
        final Console console = new Console();
        final CoinCollection change = new CoinCollection();
        assertEquals("THANK YOU", console.getChangeDisplay(change));

        change.addCoin(Coin.QUARTER);
        assertEquals("THANK YOU\nRETURN: quarter (x1)", console.getChangeDisplay(change));

        change.addCoin(Coin.QUARTER);
        assertEquals("THANK YOU\nRETURN: quarter (x2)", console.getChangeDisplay(change));

        change.addCoin(Coin.NICKEL);
        assertEquals("THANK YOU\nRETURN: quarter (x2), nickel (x1)", console.getChangeDisplay(change));

        change.addCoin(Coin.DIME);
        assertEquals("THANK YOU\nRETURN: quarter (x2), nickel (x1), dime (x1)", console.getChangeDisplay(change));

        change.addCoin(Coin.NICKEL);
        assertEquals("THANK YOU\nRETURN: quarter (x2), nickel (x2), dime (x1)", console.getChangeDisplay(change));
    }

    @Test
    public void testProductsDisplay() {
        final Console console = new Console();
        final SortedMap<String, InventoryProduct> inventory = new TreeMap<String, InventoryProduct>();
        assertEquals("No items in vending machine.", console.getProductDisplay(inventory));

        inventory.put("A", new InventoryProduct("foo", 1, 100));
        assertEquals("A\t$1.00\tfoo", console.getProductDisplay(inventory));

        inventory.put("C", new InventoryProduct("bar", 1, 125));
        assertEquals("A\t$1.00\tfoo\nC\t$1.25\tbar", console.getProductDisplay(inventory));

        inventory.put("B", new InventoryProduct("baz", 1, 265));
        assertEquals("A\t$1.00\tfoo\nB\t$2.65\tbaz\nC\t$1.25\tbar", console.getProductDisplay(inventory));
    }

}
