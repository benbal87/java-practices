package com.ben.javapractices.practices.litteexcercises.humanhandlerhashset;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Write a class, called Human.
 * It has the following properties: age (int), name (String), height (double, means the height of the human in meters).
 * Two humans are equal if they have the same names.
 * Create a class, called HumanHandler.
 * Create a main method and instantiate some Human objects in the main method and set some of them the same names.
 * Add the objects to a HashSet. Print out the size of the HashSet you created.
 **/
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
        if (name == null) {
            return other.name == null;
        } else {
            return name.equals(other.name);
        }
    }

}
