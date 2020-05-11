package com.ben.javapractices.practices.collectionsandfileoperations.filehandlerserializer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class TextRead {

    private String[] textReader(String textFile) {
        String[] personList = null;

        try {
            FileReader fileReader = new FileReader(textFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> lineList = new ArrayList<>();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                lineList.add(line);
            }

            personList = lineList.toArray(new String[lineList.size()]);
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return personList;
    }

    List<Person> objectFactory(String textFile) {
        String[] personList = textReader(textFile);
        List<Person> personObjectList = new ArrayList<>();

        for (String person : personList) {
            personObjectList.add(Person.personParse(person));
        }

        return personObjectList;
    }

}
