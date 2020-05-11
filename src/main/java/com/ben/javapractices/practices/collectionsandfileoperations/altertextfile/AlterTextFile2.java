package com.ben.javapractices.practices.collectionsandfileoperations.altertextfile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.ben.javapractices.utils.Util;

public class AlterTextFile2 {

    private static final String resourcePath = Util.getResourcePath();

    public final String FILE_PATH = resourcePath + "test_files/alter_text_file/test.txt";

    public static void main(String[] args) {
        AlterTextFile2 alterTextFile = new AlterTextFile2();
        alterTextFile.writeContent();
    }

    public String fileRead() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        int counter = 1;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileReader = new FileReader(FILE_PATH);
            bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                if (counter < 10) {
                    stringBuilder2.append("0");
                }
                stringBuilder2.append(counter++);
                stringBuilder2.append(". ");
                stringBuilder2.append(line);
                stringBuilder2.append("\n");
                stringBuilder.append(stringBuilder2.toString());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }

    public String manageLine(String actualLine) {
        StringBuilder stringBuilder = new StringBuilder();
        char actualChar = ' ';
        for (int i = 0; i < actualLine.length(); i++) {
            actualChar = Character.toLowerCase(actualLine.charAt(i));
            if (actualChar == ' ') {
                actualChar = '_';
                stringBuilder.append(actualChar);
            } else if (actualChar == '"' || actualChar == '$') {

            } else {
                stringBuilder.append(actualChar);
            }
        }
        return stringBuilder.toString();
    }

    public void writeContent() {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        String fileContent = fileRead();
        System.out.println(fileContent);
        try {
            fileWriter = new FileWriter(FILE_PATH);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(fileContent);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

}
