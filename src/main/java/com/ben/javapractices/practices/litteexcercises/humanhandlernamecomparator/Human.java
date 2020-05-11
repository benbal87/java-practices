package com.ben.javapractices.practices.litteexcercises.humanhandlernamecomparator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * Write a class, called Human.
 * It has the following properties: age (int), name (String), height (double, means the height of the human in meters).
 * Create a class, called HumanNameLengthComparator which implements java.util.Comparator and is able to decide if a
 * human's name is longer than another human's name.
 * Create a class, called HumanHandler.
 * Create a main method and instantiate some Human objects in the main method.
 * Add the objects to a List.
 * Sort the human objects by their lengths of their names in the List.
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Human implements Comparable<Human> {

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

    @Override
    public int compareTo(Human human) {
        return name.length() - human.getName().length();
    }

}
