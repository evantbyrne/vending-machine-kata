package com.evanbyrne.vending_machine_kata.coin;

/**
 * Creates objects that represent physical coins.
 */
public class CoinFactory {

    /**
     * Get a coin object by name.
     *
     * Should only be used in a simulation environment.
     *
     * @param Case insensitive coin name.
     * @return Coin object or null on invalid.
     */
    public static Coin getByName(String name) {
        name = name.toUpperCase();

        for (final Coin coin : Coin.values()) {

            if (coin.name().equals(name)) {
                return coin;
            }
        }

        return null;
    }

    /**
     * Get a coin object by its diameter and weight.
     *
     * @param Coin diameter.
     * @param Coin weight.
     * @return Coin object or null on invalid.
     */
    public static Coin getByDiameterAndWeight(final int diameter, final int weight) {

        for (final Coin coin : Coin.values()) {

            if (coin.getDiameter() == diameter && coin.getWeight() == weight) {
                return coin;
            }
        }

        return null;
    }

}
