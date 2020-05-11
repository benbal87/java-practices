package com.ben.javapractices.practices.collectionsandfileoperations.filehandlercomparecomparator;

import java.util.Comparator;

public class Compare implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        Integer p1 = person1.getAge();
        Integer p2 = person2.getAge();

        if (person1.getName().equals(person2.getName())) {
            return p1.compareTo(p2);
        } else {
            return person1.getName().compareTo(person2.getName());
        }
    }

}
