package com.ben.javapractices.practices.collectionsandfileoperations.carddecksorter;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Collections.shuffle(Deck.CARDS);
        for (Card card : Deck.CARDS) {
            System.out.print(card.toString() + ", ");
        }

        System.out.println();
        Collections.sort(Deck.CARDS);
        for (Card card : Deck.CARDS) {
            System.out.print(card.toString() + ", ");
        }
    }

}
