// Write a class, called Human.
// It has the following properties:
// age (int),
// name (String),
// height (double, means the height of the human in meters).
//
// Create a class, called HumanNameLengthComparator which implements java.util.Comparator
// and is able to decide if a human's name is longer than another human's name.
//
// Create a class, called HumanHandler,
// create a main method and instantiate some Human objects in the main method.
// Add the objects to a List.
// Sort the human objects by their lengths of their names in the List.

package com.ben.javapractices.practices.litteexcercises.humanhandlernamecomparator;

import java.util.ArrayList;
import java.util.List;

public class HumanHandler {

    public static void main(String[] args) {
        Human person_01 = new Human(25, "John", 1.85);
        Human person_02 = new Human(25, "Eve", 1.85);
        Human person_03 = new Human(26, "Franklin", 1.65);
        Human person_04 = new Human(30, "Bob", 1.58);
        Human person_05 = new Human(19, "Sarah", 2.06);
        Human person_06 = new Human(38, "Samuel", 1.75);
        Human person_07 = new Human(44, "Jenkins", 2.04);

        List<Human> humanList = new ArrayList<>();
        humanList.add(person_01);
        humanList.add(person_02);
        humanList.add(person_03);
        humanList.add(person_04);
        humanList.add(person_05);
        humanList.add(person_06);
        humanList.add(person_07);

        System.out.println("Before sorting humans:");
        for (Human human : humanList) {
            System.out.println(human);
        }

        System.out.println("After sorting humans:");
        humanList.sort(new HumanNameLengthComparator());
        for (Human human : humanList) {
            System.out.println(human);
        }
    }

}
