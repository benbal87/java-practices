package com.ben.javapractices.practices.litteexcercises.humanhandlernamecomparator;

import java.util.Comparator;

public class HumanNameLengthComparator implements Comparator<Human> {

    @Override
    public int compare(Human human1, Human human2) {
        return human1.compareTo(human2);
    }

}
