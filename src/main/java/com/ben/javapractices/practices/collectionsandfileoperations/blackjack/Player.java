package com.ben.javapractices.practices.collectionsandfileoperations.blackjack;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Player implements Comparable<Player> {

    private String name;

    private Hand hand;

    public Player(String name) {
        this.name = name;
        hand = null;
    }

    @Override
    public int compareTo(Player o) {
        return hand.compareTo(o.getHand());
    }

}
