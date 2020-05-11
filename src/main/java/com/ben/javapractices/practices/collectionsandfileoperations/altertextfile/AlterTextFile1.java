package com.ben.javapractices.practices.collectionsandfileoperations.altertextfile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import com.ben.javapractices.utils.Util;

public class AlterTextFile1 {

    public static void main(String[] args) {
        File file;
        RandomAccessFile randomAccessFile = null;
        int counter = 1;

        try {
            String resourcePath = Util.getResourcePath();
            file = new File(resourcePath + "test_files/alter_text_file/test.txt");
            randomAccessFile = new RandomAccessFile(file, "rw");

            String actualLine;
            while ((actualLine = randomAccessFile.readLine()) != null) {
                StringBuilder stringBuilder = new StringBuilder();
                if (counter < 10) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(counter++);
                stringBuilder.append(". ");
                stringBuilder.append(actualLine);
                stringBuilder.append("\n");
                if (counter <= 2) {
                    randomAccessFile.seek(randomAccessFile.getFilePointer() - stringBuilder.length() - 2);
                } else {
                    randomAccessFile.seek(randomAccessFile.getFilePointer() - stringBuilder.length());
                }
                randomAccessFile.writeBytes(stringBuilder.toString());
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

}
