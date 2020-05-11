package com.ben.javapractices.practices.collectionsandfileoperations.carddecksorter;

public enum Suit {
    HEART('h'),
    DIAMOND('d'),
    CLUB('c'),
    SPADE('s');

    char value;

    private Suit(char value) {
        this.value = value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
