package com.evanbyrne.vending_machine_kata.coin;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a collection of physical coins.
 */
public class CoinCollection {

    /**
     * A list of all coins in collection.
     */
    private List<Coin> coins;

    /**
     * Total cent value of coins in collection.
     */
    private int total;

    /**
     * Constructor.
     */
    public CoinCollection() {
        this(new ArrayList<Coin>());
    }

    /**
     * Constructor.
     *
     * @param A list of coins.
     */
    public CoinCollection(final List<Coin> coins) {
        this.coins = coins;
        this.total = 0;

        for(final Coin coin : coins) {
            this.addCoin(coin);
        }
    }

    /**
     * Add coin to collection.
     *
     * @param Coin.
     */
    public void addCoin(final Coin coin) {
        this.coins.add(coin);
        this.total += coin.getCents();
    }

    /**
     * Get all coins in collection.
     *
     * @return List of coins.
     */
    public List<Coin> getList() {
        return this.coins;
    }

    /**
     * Get total value of coins.
     *
     * @return Value in cents.
     */
    public int getTotal() {
        return this.total;
    }

    /**
     * Make change.
     *
     * TODO: Only use coins from this collection.
     *
     * @param Total amount of change needed in cents.
     * @return Coin collection representing change. Null if change could not be made.
     */
    public CoinCollection makeChange(final int totalChange) {
        final CoinCollection change = new CoinCollection();

        while(change.getTotal() < totalChange) {
            final Coin coin = this.makeChangeCoin(totalChange - change.getTotal());

            if(coin == null) {
                return null;
            }

            change.addCoin(coin);
        }

        return change;
    }

    /**
     * Get another coin for making change.
     *
     * @param Amount of change still needed in cents.
     * @return Coin. Null if no valid coins exist.
     */
    private Coin makeChangeCoin(final int changeNeeded) {

        for(final Coin coin : Coin.values()) {

            if(coin.getCents() <= changeNeeded) {
                return coin;
            }
        }

        return null;
    }

}
