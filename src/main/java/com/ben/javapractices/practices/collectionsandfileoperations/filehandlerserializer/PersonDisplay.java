package com.ben.javapractices.practices.collectionsandfileoperations.filehandlerserializer;

import java.util.List;

class PersonDisplay {

    private Language language;

    PersonDisplay(Language language) {
        this.language = language;
    }

    void displayPersons(String textFileName, String objectFileName) {
        ObjectHandler objectHandler = new ObjectHandler();

        objectHandler.serializePersonObjects(textFileName, objectFileName);

        List<Person> personObjectList = objectHandler.deserializePeronObjects(objectFileName);

        if (this.language == Language.HUN) {
            personObjectList.sort(new CompareHun());

            for (Person person : personObjectList) {
                System.out.println("Name:\t" + person.lastName + " " + person.firstName + "\nAge:\t" + person.age
                                   + "\n-------------------------------");
            }
        } else if (this.language == Language.ENG) {
            personObjectList.sort(new CompareEng());

            for (Person person : personObjectList) {
                System.out.println("Name:\t" + person.firstName + " " + person.lastName + "\nAge:\t" + person.age
                                   + "\n-------------------------------");
            }
        }
    }

}
