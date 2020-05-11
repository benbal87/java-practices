package com.ben.javapractices.practices.collectionsandfileoperations.filehandlerserializer;

import java.util.Comparator;

public class CompareHun implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        Integer p1 = person1.getAge();
        Integer p2 = person2.getAge();

        if (person1.getLastName().equals(person2.getLastName())) {
            return p1.compareTo(p2);
        } else {
            return person1.getLastName().compareTo(person2.getLastName());
        }
    }

}
