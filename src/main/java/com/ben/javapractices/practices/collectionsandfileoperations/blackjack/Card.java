package com.ben.javapractices.practices.collectionsandfileoperations.blackjack;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Card {

    private Rank rank;

    private Suite suite;

}
