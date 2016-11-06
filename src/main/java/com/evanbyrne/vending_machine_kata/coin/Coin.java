package com.evanbyrne.vending_machine_kata.coin;

/**
 * Represents physical coins.
 */
public enum Coin {
    QUARTER(25, 3, 3),
    DIME(10, 2, 1),
    NICKEL(5, 1, 2);

    /**
     * Value of coin in cents.
     */
    private final int cents;

    /**
     * Coin diameter.
     */
    private final int diameter;

    /**
     * Coin weight.
     */
    private final int weight;

    /**
     * Constructor.
     *
     * @param Value of coin in cents.
     * @param Coin diameter.
     * @param Coin weight.
     */
    Coin(final int cents, final int diameter, final int weight) {
        this.cents = cents;
        this.diameter = diameter;
        this.weight = weight;
    }

    /**
     * Get cents.
     *
     * @return Value of coin in cents.
     */
    public int getCents() {
        return this.cents;
    }

    /**
     * Get diameter.
     *
     * @return Coin diameter.
     */
    public int getDiameter() {
        return this.diameter;
    }

    /**
     * Get weight
     *
     * @return Coin weight.
     */
    public int getWeight() {
        return this.weight;
    }

}
