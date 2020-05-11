package com.ben.javapractices.practices.collectionsandfileoperations.filesizesorter1;

import java.io.File;
import java.util.Comparator;

public class FilePathComparator implements Comparator<File> {

    @Override
    public int compare(File file1, File file2) {
        if (fileLevel(file1) != fileLevel(file2)) {
            return fileLevel(file1) - fileLevel(file2);
        } else {
            return file1.getAbsolutePath().compareTo(file2.getAbsolutePath());
        }
    }

    private int fileLevel(File file) {
        return file.getAbsolutePath().split("\\\\").length;
    }

}
