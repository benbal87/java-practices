package com.ben.javapractices.practices.collectionsandfileoperations.blackjack;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Hand implements Comparable<Hand> {

    private Set<Card> cardSet = new HashSet<>();

    private int getCardSetValue() {
        int sum = 0;
        for (Card card : cardSet) {
            sum += card.getRank().getValue();
        }
        return sum;
    }

    @Override
    public int compareTo(Hand o) {
        return this.getCardSetValue() - o.getCardSetValue();
    }

    public void receiveCard() {
        cardSet.add(Deck.deal());
    }

}
