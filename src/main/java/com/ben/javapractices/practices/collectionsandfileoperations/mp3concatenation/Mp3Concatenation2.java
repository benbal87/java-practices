package com.ben.javapractices.practices.collectionsandfileoperations.mp3concatenation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ben.javapractices.utils.Util;

public final class Mp3Concatenation2 {

    private Mp3Concatenation2() {
    }

    public static void main(String[] args) {
        String resourcePath = Util.getResourcePath();
        List<String> filePathList = new ArrayList<>();
        filePathList.add(resourcePath + "test_files/mp3_concatenation/first_part.mp3");
        filePathList.add(resourcePath + "test_files/mp3_concatenation/second_part.mp3");
        String outputFilePath = resourcePath + "test_files/mp3_concatenation/concatenated.mp3";
        concatenateFiles(filePathList, outputFilePath);
    }

    public static void concatenateFiles(List<String> filePathList, String outputFilePath) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(new File(outputFilePath));
            for (String filePath : filePathList) {
                FileInputStream fileInputStream = new FileInputStream(filePath);
                write(fileInputStream, fileOutputStream);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void write(FileInputStream fileInputStream, FileOutputStream fileOutputStream) {
        try {
            int temp;
            temp = fileInputStream.read();
            while (temp != -1) {
                fileOutputStream.write(temp);
                temp = fileInputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
