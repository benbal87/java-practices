package com.ben.javapractices.practices.collectionsandfileoperations.filehandlercomparecomparable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Human implements Comparable<Human> {

    public String name;

    public int age;

    static Human personParse(String personData) {
        String[] string = personData.split(",");

        String pName = string[0];
        int pAge = Integer.parseInt(string[1]);

        return new Human(pName, pAge);
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
        Human other = (Human) obj;
        if (name == null) {
            return other.name == null;
        } else {
            return name.equals(other.name);
        }
    }

    @Override
    public int compareTo(Human person) {
        Integer p1 = age;
        Integer p2 = person.getAge();

        if (name.equals(person.getName())) {
            return p1.compareTo(p2);
        } else {
            return name.compareTo(person.getName());
        }
    }

}
