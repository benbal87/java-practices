package com.ben.javapractices.practices.collectionsandfileoperations.filehandlercomparecomparator;

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
class Person {

    public String name;

    public int age;

    static Person personParse(String personData) {
        String[] string = personData.split(",");

        String pName = string[0];
        int pAge = Integer.parseInt(string[1]);

        return new Person(pName, pAge);
    }

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
        Person other = (Person) obj;
        if (name == null) {
            return other.name == null;
        } else {
            return name.equals(other.name);
        }
    }

}
