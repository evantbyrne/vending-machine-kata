package com.evanbyrne.vending_machine_kata.coin;

public enum Coin {
    QUARTER(25, 3, 3),
    DIME(10, 2, 1),
    NICKEL(5, 1, 2);

    private final int cents;

    private final int diameter;

    private final int weight;

    Coin(final int cents, final int diameter, final int weight) {
        this.cents = cents;
        this.diameter = diameter;
        this.weight = weight;
    }

    public int getCents() {
        return this.cents;
    }

    public int getDiameter() {
        return this.diameter;
    }

    public int getWeight() {
        return this.weight;
    }

}
