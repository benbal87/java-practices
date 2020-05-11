package com.ben.javapractices.practices.collectionsandfileoperations.comparefilestructures;

import java.io.File;
import java.util.List;

import com.ben.javapractices.utils.Util;

public class Main {

    public static void main(String[] args) {
        String resourcePath = Util.getResourcePath();
        String directory1 = resourcePath + "test_files/compare_file_structure/dir1";
        String directory2 = resourcePath + "test_files/compare_file_structure/dir2";
        CompareDirs compareDirs = new CompareDirs(directory1, directory2);
        List<File> differenceIn1st = compareDirs.getDifferenceIn1st();
        List<File> differenceIn2nd = compareDirs.getDifferenceIn2nd();

        System.out.println("DIFFERENCES IN FIRST");
        for (File file : differenceIn1st) {
            System.out.println(file.getName());
        }
        System.out.println("\n\nDIFFERENCES IN SECOND");
        for (File file : differenceIn2nd) {
            System.out.println(file.getName());
        }
    }

}
