package com.evanbyrne.vending_machine_kata.ui;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Test;

import com.evanbyrne.vending_machine_kata.coin.Coin;
import com.evanbyrne.vending_machine_kata.coin.CoinCollection;
import com.evanbyrne.vending_machine_kata.inventory.IInventoryService;
import com.evanbyrne.vending_machine_kata.inventory.InventoryProduct;
import com.evanbyrne.vending_machine_kata.inventory.VolatileInventoryService;
import com.evanbyrne.vending_machine_kata.ui.Console;

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

    @Test(expected=NoSuchElementException.class)
    public void testPromptForPaymentBad() {
        final Console console = new Console();
        final Scanner scanner = new Scanner(new ByteArrayInputStream("penny\n".getBytes()));
        final InventoryProduct selection = new InventoryProduct("cola", 1, 65);
        assertNull(console.promptForPayment(scanner, selection));
    }

    @Test
    public void testPromptForPaymentGood() {
        final Console console = new Console();
        final Scanner scanner = new Scanner(new ByteArrayInputStream("quarter\nquarter\nquarter\n".getBytes()));
        final InventoryProduct selection = new InventoryProduct("cola", 1, 65);
        final CoinCollection paid = console.promptForPayment(scanner, selection);
        assertNotNull(paid);
        assertEquals(75, paid.getTotal());
    }

    @Test(expected=NoSuchElementException.class)
    public void testPromptForSelectionBad() {
        final Console console = new Console();
        final IInventoryService inventoryService = new VolatileInventoryService();
        final Scanner scanner = new Scanner(new ByteArrayInputStream("C\n".getBytes()));
        inventoryService.setProduct("A", new InventoryProduct("cola", 5, 100));
        inventoryService.setProduct("B", new InventoryProduct("bar", 2, 50));
        assertNull(console.promptForSelection(scanner, inventoryService));
    }

    @Test
    public void testPromptForSelectionGood() {
        final Console console = new Console();
        final IInventoryService inventoryService = new VolatileInventoryService();
        final Scanner scanner = new Scanner(new ByteArrayInputStream("A\n".getBytes()));
        inventoryService.setProduct("A", new InventoryProduct("cola", 5, 100));
        inventoryService.setProduct("B", new InventoryProduct("bar", 2, 50));
        assertNotNull(console.promptForSelection(scanner, inventoryService));
    }

}
