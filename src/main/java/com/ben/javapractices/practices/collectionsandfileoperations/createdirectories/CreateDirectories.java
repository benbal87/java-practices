package com.ben.javapractices.practices.collectionsandfileoperations.createdirectories;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.ben.javapractices.utils.Util;

public class CreateDirectories {

    private final String DIRS = Util.getResourcePath() + "test_files/create_directories/dirs.txt";

    public static void main(String[] args) {
        CreateDirectories createDirectories = new CreateDirectories();
        createDirectories.createDirs("c:/test/");
    }

    private void createDirs(String parentDirectoryPath) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(DIRS);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String actualDir = parentDirectoryPath + line;
                File file = new File(actualDir);
                if (!file.exists()) {
                    boolean mkdirs = file.mkdirs();
                    if (mkdirs) {
                        System.out.println("Directory created: " + file.getAbsolutePath());
                    }
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
