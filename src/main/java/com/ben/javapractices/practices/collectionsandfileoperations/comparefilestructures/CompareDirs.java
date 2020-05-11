package com.ben.javapractices.practices.collectionsandfileoperations.comparefilestructures;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class CompareDirs {

    private String directory1;

    private String directory2;

    private List<File> differenceIn1st = new ArrayList<>();

    private List<File> differenceIn2nd = new ArrayList<>();

    CompareDirs(String directory1, String directory2) {
        this.directory1 = directory1;
        this.directory2 = directory2;
        Compare();
    }

    List<File> getDifferenceIn1st() {
        return differenceIn1st;
    }

    List<File> getDifferenceIn2nd() {
        return differenceIn2nd;
    }

    private void Compare() {
        CollectFiles collectFiles1 = new CollectFiles(directory1);
        CollectFiles collectFiles2 = new CollectFiles(directory2);
        List<File> filesCollection1 = collectFiles1.getFileList();
        List<File> filesCollection2 = collectFiles2.getFileList();

        for (File value : filesCollection1) {
            for (int j = 0; j < filesCollection2.size(); j++) {
                if (!filesCollection2.contains(value) & !differenceIn1st.contains(value)) {
                    differenceIn1st.add(value);
                }
            }
        }

        for (File file : filesCollection2) {
            for (int j = 0; j < filesCollection1.size(); j++) {
                if (!filesCollection1.contains(file) & !differenceIn2nd.contains(file)) {
                    differenceIn2nd.add(file);
                }
            }
        }
    }

}
