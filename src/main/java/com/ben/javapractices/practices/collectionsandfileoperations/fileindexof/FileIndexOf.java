package com.ben.javapractices.practices.collectionsandfileoperations.fileindexof;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.ben.javapractices.utils.Util;

public class FileIndexOf {

    public static void main(String[] args) {
        String resourcePath = Util.getResourcePath();
        String filePath = resourcePath + "test_files/file_index_of/testFile.txt";
        File file = new File(filePath);
        char charToFind = 'F';
        long startByte = 0;

        FileIndexOf fileIndexOf = new FileIndexOf();
        long index = fileIndexOf.indexOf(file, charToFind, startByte);

        System.out.println(index);
    }

    public long indexOf(File file, char charToFind, long startByte) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            long byteCount = 0;
            int actualByte;
            while ((actualByte = fileInputStream.read()) != -1) {
                if (byteCount >= startByte) {
                    char actualChar = (char) actualByte;
                    if (actualChar == charToFind) {
                        return byteCount;
                    }
                }
                byteCount++;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return -1;
    }

}
