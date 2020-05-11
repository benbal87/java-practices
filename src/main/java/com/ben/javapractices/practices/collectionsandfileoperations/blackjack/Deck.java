package com.ben.javapractices.practices.collectionsandfileoperations.blackjack;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Deck {

    private static final LinkedList<Card> cards = new LinkedList<>();

    private static Queue<Card> queue = cards;

    static {
        reset();
    }

    private Deck() {
    }

    static Card deal() {
        return queue.poll();
    }

    private static void reset() {
        cards.clear();
        for (Suite suite : Suite.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(rank, suite);
                cards.add(card);
            }
        }
        Collections.shuffle(cards);
    }

}
