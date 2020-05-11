package com.ben.javapractices.practices.collectionsandfileoperations.comparefilestructures;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class CollectFiles {

    private List<File> fileList = new ArrayList<>();

    private String folder;

    CollectFiles(String directory) {
        this.folder = directory;
        getFiles();
    }

    List<File> getFileList() {
        return fileList;
    }

    private void getFiles() {
        File[] files = new File(folder).listFiles();

        if (files != null) {
            for (File file : files) {
                if (!file.isDirectory()) {
                    fileList.add(file);
                } else {
                    folder = file.getAbsolutePath();
                    getFiles();
                }
            }
        }
    }

}
