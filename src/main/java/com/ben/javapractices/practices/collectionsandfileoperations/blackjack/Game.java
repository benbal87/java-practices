package com.ben.javapractices.practices.collectionsandfileoperations.blackjack;

public class Game {

    public static void main(String[] args) {
        Player playerOne = new Player("Adam");
        Player playerTwo = new Player("John");
        Hand handOne = new Hand();
        Hand handTwo = new Hand();
        handOne.receiveCard();
        handTwo.receiveCard();
        handOne.receiveCard();
        handTwo.receiveCard();
        playerOne.setHand(handOne);
        playerTwo.setHand(handTwo);
        System.out.println(playerOne);
        System.out.println(playerTwo);
        String winner = playerOne.compareTo(playerTwo) > 0
            ? playerOne.getName()
            : playerOne.compareTo(playerTwo) < 0 ? playerTwo.getName() : "Draw!";
        System.out.print("Winner: " + winner);
    }

}
