// Write a class, called Human. It has the following properties:
// age (int),
// name (String),
// height (double, means the height of the human in meters).
// Two humans are equal if they have the same names.
// Create a class, called HumanHandler,
// create a main method and instantiate some Human objects in the main method
// and set some of them the same names.
// Add the objects to a List.
// Create a static method in HumanHandler class
// which gets a List of humans as a parameter and returns with a HashMap
// where the keys are the humans in the list
// and the values are the number of how many times the current human appears in
// the parameter list.
// Call this method from main method
// and print out its result in the following form:
// <name> : <count>
// <name> : <count>
// etc.

package com.ben.javapractices.practices.litteexcercises.humanhandlerhashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HumanHandler {

    static HashMap<Human, Integer> nameOccurrencesFrequency = null;

    static HashMap<Human, Integer> nameFrequencyHashMap = null;

    public static void main(String[] args) {
        Human person_01 = new Human(25, "John", 1.85);
        Human person_02 = new Human(25, "Eve", 1.85);
        Human person_03 = new Human(26, "Franklin", 1.65);
        Human person_04 = new Human(30, "Bob", 1.58);
        Human person_05 = new Human(19, "Sarah", 2.06);
        Human person_06 = new Human(38, "Samuel", 1.75);
        Human person_07 = new Human(44, "Jenkins", 2.04);

        List<Human> humanList = new ArrayList<Human>();
        humanList.add(person_01);
        humanList.add(person_02);
        humanList.add(person_03);
        humanList.add(person_04);
        humanList.add(person_05);
        humanList.add(person_06);
        humanList.add(person_07);

        nameFrequencyHashMap = nameCounter(humanList);

        for (Human human : nameFrequencyHashMap.keySet()) {
            System.out.println(human.getName() + " : " + nameFrequencyHashMap.get(human));
        }
    }

    public static HashMap<Human, Integer> nameCounter(List<Human> humanList) {
        nameOccurrencesFrequency = new HashMap<>();

        for (Human human : humanList) {
            int value = 1;

            if (nameOccurrencesFrequency.containsKey(human)) {
                value = nameOccurrencesFrequency.get(human) + 1;
            }

            nameOccurrencesFrequency.put(human, value);
        }

        return nameOccurrencesFrequency;
    }

}
