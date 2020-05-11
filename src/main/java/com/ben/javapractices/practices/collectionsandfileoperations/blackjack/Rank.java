package com.ben.javapractices.practices.collectionsandfileoperations.blackjack;

public enum Rank {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(11);

    private int value;

    private Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        switch (name()) {
            case "JACK":
                return "J";
            case "QUEEN":
                return "Q";
            case "KING":
                return "K";
            case "ACE":
                return "A";
            default:
                return String.valueOf(getValue());
        }
    }
}
