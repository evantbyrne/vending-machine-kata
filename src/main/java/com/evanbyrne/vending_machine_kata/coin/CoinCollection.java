package com.evanbyrne.vending_machine_kata.coin;

import java.util.ArrayList;
import java.util.List;

public class CoinCollection {

    private List<Coin> coins;

    private int total;

    public CoinCollection() {
        this(new ArrayList<Coin>());
    }

    public CoinCollection(final List<Coin> coins) {
        this.coins = coins;
        this.total = 0;

        for(final Coin coin : coins) {
            this.addCoin(coin);
        }
    }

    public void addCoin(final Coin coin) {
        this.coins.add(coin);
        this.total += coin.getCents();
    }

    public List<Coin> getList() {
        return this.coins;
    }

    public int getTotal() {
        return this.total;
    }

    public CoinCollection makeChange(final int totalChange) {
        // TODO: subtract change.
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

    private Coin makeChangeCoin(final int changeNeeded) {

        for(final Coin coin : Coin.values()) {

            if(coin.getCents() <= changeNeeded) {
                return coin;
            }
        }

        return null;
    }

}
