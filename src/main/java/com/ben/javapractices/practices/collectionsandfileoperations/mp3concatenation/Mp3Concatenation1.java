package com.ben.javapractices.practices.collectionsandfileoperations.mp3concatenation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.ben.javapractices.utils.Util;

public final class Mp3Concatenation1 {

    private Mp3Concatenation1() {
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
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(new File(outputFilePath));
            for (String filePath : filePathList) {
                InputStream inputStream = new FileInputStream(filePath);
                write(inputStream, outputStream);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void write(InputStream inputStream, OutputStream outputStream) {
        byte[] buffer = new byte[1 << 20]; // loads 1 MB of the file
        int count;
        try {
            while ((count = inputStream.read(buffer)) != -1) {
                try {
                    outputStream.write(buffer, 0, count);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                outputStream.flush();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

}
