package com.evanbyrne.vending_machine_kata.coin;

import static org.junit.Assert.*;

import org.junit.Test;

import com.evanbyrne.vending_machine_kata.coin.Coin;
import com.evanbyrne.vending_machine_kata.coin.CoinCollection;

public class CoinCollectionTest {

    @Test
    public void testTotal() {
        final CoinCollection coins = new CoinCollection();
        assertEquals( 0, coins.getTotal() );
    }
    
    @Test
    public void testAddCoin() {
        final CoinCollection coins = new CoinCollection();
        
        assertEquals(0, coins.getTotal());
        assertEquals(0, coins.getList().size());

        coins.addCoin(Coin.DIME);
        assertEquals(10, coins.getTotal());
        assertEquals(1, coins.getList().size());
        assertEquals(Coin.DIME, coins.getList().get(0));
        
        coins.addCoin(Coin.QUARTER);
        assertEquals(35, coins.getTotal());
        assertEquals(2, coins.getList().size());
        assertEquals(Coin.DIME, coins.getList().get(0));
        assertEquals(Coin.QUARTER, coins.getList().get(1));
        
        coins.addCoin(Coin.NICKEL);
        assertEquals(40, coins.getTotal());
        assertEquals(3, coins.getList().size());
        assertEquals(Coin.DIME, coins.getList().get(0));
        assertEquals(Coin.QUARTER, coins.getList().get(1));
        assertEquals(Coin.NICKEL, coins.getList().get(2));
    }
    
    @Test
    public void testMakeChange() {
        // TODO: subtract change.
        final CoinCollection coins = new CoinCollection();
        CoinCollection change = coins.makeChange(0);
        
        assertEquals(0, change.getTotal());
        assertEquals(0, change.getList().size());
        
        change = coins.makeChange(25);
        assertEquals(25, change.getTotal());
        assertEquals(1, change.getList().size());
        assertEquals(Coin.QUARTER, change.getList().get(0));
        
        change = coins.makeChange(5);
        assertEquals(5, change.getTotal());
        assertEquals(1, change.getList().size());
        assertEquals(Coin.NICKEL, change.getList().get(0));
        
        change = coins.makeChange(15);
        assertEquals(15, change.getTotal());
        assertEquals(2, change.getList().size());
        assertEquals(Coin.DIME, change.getList().get(0));
        assertEquals(Coin.NICKEL, change.getList().get(1));
        
        change = coins.makeChange(60);
        assertEquals(60, change.getTotal());
        assertEquals(3, change.getList().size());
        assertEquals(Coin.QUARTER, change.getList().get(0));
        assertEquals(Coin.QUARTER, change.getList().get(1));
        assertEquals(Coin.DIME, change.getList().get(2));
    }

}
