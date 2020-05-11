package com.ben.javapractices.practices.collectionsandfileoperations.readtextfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ben.javapractices.utils.Util;

public class ReadTextFile {

    private static final String FILE = Util.getResourcePath() + "test_files/cities/cities.txt";

    public static List<String> textReader(String filePath) {
        List<String> lines = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }

        return lines;
    }

    public static void main(String[] args) {
        List<String> cityList = textReader(FILE);
        String cities = String.join("\n", cityList);
        System.out.println(cities);
    }

}
