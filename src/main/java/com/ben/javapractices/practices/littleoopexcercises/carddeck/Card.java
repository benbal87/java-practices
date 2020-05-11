package com.ben.javapractices.practices.littleoopexcercises.carddeck;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Card {

    private Suit suit;

    private Rank rank;

}
