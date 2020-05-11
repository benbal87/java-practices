package com.ben.javapractices.practices.collectionsandfileoperations.carddecksorter;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    public final static List<Card> CARDS = new ArrayList<>();

    static {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                CARDS.add(new Card(suit, rank));
            }
        }
    }
}
