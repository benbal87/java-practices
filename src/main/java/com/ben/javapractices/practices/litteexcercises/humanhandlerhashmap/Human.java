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
public class Human {

    private int age;

    private String name;

    private double height;

    @Override
    public int hashCode() {
        return -1;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Human other = (Human) obj;
        if (name == null && other.name != null) {
            return false;
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

}
