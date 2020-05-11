/*
 * Write a program which gets the absolute path of a directory and collects the
 * contained files in a map in unlimited depth. Which keys will be the size of files and the
 * values will be a Set which will contains the files with the same file sizes.
 * After that the the program will delete files with the same filecontents
 */

package com.ben.javapractices.practices.collectionsandfileoperations.filesizesorter1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import com.ben.javapractices.utils.Util;

public class FileSizeSort2 {

    private List<File> fileList = new ArrayList<>();

    private String folder;

    private Map<Long, SortedSet<File>> filesMap = new HashMap<>();

    public FileSizeSort2(String directory) {
        this.folder = directory;
        getFiles();
    }

    public static void main(String[] args) {
        String resourcePath = Util.getResourcePath();
        String folder = resourcePath + "test_files/file_size_sorter/";
        FileSizeSort2 fileSizeSort = new FileSizeSort2(folder);
        fileSizeSort.sortFiles();

        Map<Long, SortedSet<File>> filesSorted = fileSizeSort.getFilesMap();

        for (Long key : filesSorted.keySet()) {
            System.out.println(key + " Kbyte file size\n");
            for (File file : filesSorted.get(key)) {
                System.out.println(file.getName());
            }
            System.out.println("-----------------------\n");
        }

        System.out.println("After removing duplicate files: \n");
        fileSizeSort.removeDuplicates();
        Map<Long, SortedSet<File>> filesSortedWithoutDuplicates = fileSizeSort.getFilesMap();

        for (Long key : filesSortedWithoutDuplicates.keySet()) {
            System.out.println(key + " Kbyte file size\n");
            for (File file : filesSortedWithoutDuplicates.get(key)) {
                System.out.println(file.getName());
            }
            System.out.println("-----------------------\n");
        }
    }

    public Map<Long, SortedSet<File>> getFilesMap() {
        return filesMap;
    }

    public void getFiles() {
        File[] files = new File(folder).listFiles();
        for (File file : files) {
            if (!file.isDirectory()) {
                fileList.add(file);
            } else {
                folder = file.getAbsolutePath();
                getFiles();
            }
        }
    }

    public void sortFiles() {
        for (File file : fileList) {
            Long size = file.length();
            if (filesMap.containsKey(size)) {
                filesMap.get(size).add(file);
            } else {
                SortedSet<File> fileSet = new TreeSet<>(new FilePathComparator());
                fileSet.add(file);
                filesMap.put(size, fileSet);
            }
        }
    }

    public void removeDuplicates() {
        Set<File> filesToRemove = new HashSet<>();
        for (long fileSize : filesMap.keySet()) {
            if (filesMap.get(fileSize).size() > 1) {
                Iterator<File> filesSetIterator = filesMap.get(fileSize).iterator();
                while (filesSetIterator.hasNext()) {
                    File fileToCompare = filesSetIterator.next();
                    for (File fileToCheck : filesMap.get(fileSize)) {
                        if (fileToCompare.equals(fileToCheck) || filesToRemove.contains(fileToCompare)) {
                            continue;
                        } else if (checkIfSame(fileToCompare, fileToCheck)) {
                            filesToRemove.add(fileToCheck);
                        }
                    }
                }
                filesMap.get(fileSize).removeAll(filesToRemove);
            }
        }
    }

    private boolean checkIfSame(File fileToCompare, File fileToCheck) {
        FileInputStream fileInputStream1 = null;
        FileInputStream fileInputStream2 = null;
        BufferedInputStream bufferedInputStream1 = null;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            int bufferSize = 8 * 1024;
            fileInputStream1 = new FileInputStream(fileToCompare);
            bufferedInputStream1 = new BufferedInputStream(fileInputStream1, bufferSize);
            fileInputStream2 = new FileInputStream(fileToCheck);
            bufferedInputStream2 = new BufferedInputStream(fileInputStream2, bufferSize);

            int actualBytes1 = 0;
            int actualBytes2 = 0;
            while ((actualBytes1 = bufferedInputStream1.read()) != -1
                   && (actualBytes2 = bufferedInputStream2.read()) != -1) {
                if (actualBytes1 != actualBytes2) {
                    return false;
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (bufferedInputStream1 != null) {
                    bufferedInputStream1.close();
                }
                if (fileInputStream1 != null) {
                    fileInputStream1.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return true;
    }

}
