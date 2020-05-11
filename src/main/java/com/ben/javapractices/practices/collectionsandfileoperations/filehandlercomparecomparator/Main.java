package com.ben.javapractices.practices.collectionsandfileoperations.filehandlercomparecomparator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.ben.javapractices.utils.Util;

public class Main {

    private static final String resourcePath = Util.getResourcePath();

    private static final String FILE = resourcePath + "test_files/file_handler_compare/names.txt";

    public static String[] textReader(String filePath) {
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

        List<Person> personObjectList = new ArrayList<Person>();

        for (String person : personList) {
            personObjectList.add(Person.personParse(person));
        }

        personObjectList.sort(new Compare());
        Set<String> personSet = new HashSet<>();

        for (Person person : personObjectList) {
            personSet.add(person.getName());
        }

        System.out.println(personSet.size() + "\n-------------------------------\n");
        for (Person person : personObjectList) {
            System.out.println(person);
        }
    }

}
