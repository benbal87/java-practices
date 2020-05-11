package com.ben.javapractices.practices.collectionsandfileoperations.filehandlercomparecomparable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ben.javapractices.utils.Util;

class Main {

    private static final String resourcePath = Util.getResourcePath();

    private static final String FILE = resourcePath + "test_files/file_handler_compare/names.txt";

    private static String[] textReader(String filePath) {
        String[] personList = null;

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            personList = lines.toArray(new String[lines.size()]);

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return personList;
    }

    public static void main(String[] args) {
        String[] personList = textReader(FILE);
        List<Human> personObjectList = new ArrayList<>();

        for (String person : personList) {
            personObjectList.add(Human.personParse(person));
        }

        Collections.sort(personObjectList);
        Set<String> personSet = new HashSet<>();

        for (Human person : personObjectList) {
            personSet.add(person.getName());
        }

        int personSetSize = personSet.size();
        System.out.println(personSetSize + "\n-------------------------------\n");
        for (Human person : personObjectList) {
            System.out.println(person);
        }
    }

}
