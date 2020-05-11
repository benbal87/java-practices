package com.ben.javapractices.practices.collectionsandfileoperations.blackjack;

public enum Suite {

    HEART("h"),
    DIAMOND("d"),
    CLUB("c"),
    SPADE("s");

    private String value;

    private Suite(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
