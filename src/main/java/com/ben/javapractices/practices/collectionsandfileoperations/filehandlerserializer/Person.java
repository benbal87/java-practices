package com.ben.javapractices.practices.collectionsandfileoperations.filehandlerserializer;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 549315067811183915L;

    public String firstName;

    public String lastName;

    public int age;

    public Person(String firstName, String lastName, int age) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public static Person personParse(String personData) {
        String[] stringPerson = personData.split(",");
        String[] stringName = stringPerson[0].split(" ");

        String firstName = stringName[0];
        String lastName = stringName[1];
        int age = Integer.parseInt(stringPerson[1]);

        Person person = new Person(firstName, lastName, age);

        return person;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
//        final int prime = 31;
//        int result = 1;
//        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
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
        if (firstName == null) {
            if (other.firstName != null) {
                return false;
            }
        } else if (!firstName.equals(other.firstName)) {
            return false;
        }
        return true;
    }

}
