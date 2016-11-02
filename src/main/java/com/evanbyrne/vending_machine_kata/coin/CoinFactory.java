package com.evanbyrne.vending_machine_kata.coin;

public class CoinFactory {

    public static Coin getByName(String name) {
        name = name.toUpperCase();

        for (final Coin coin : Coin.values()) {

            if (coin.name().equals(name)) {
                return coin;
            }
        }

        return null;
    }

    public static Coin getByDiameterAndWeight(final int diameter, final int weight) {

        for (final Coin coin : Coin.values()) {

            if (coin.getDiameter() == diameter && coin.getWeight() == weight) {
                return coin;
            }
        }

        return null;
    }

}
