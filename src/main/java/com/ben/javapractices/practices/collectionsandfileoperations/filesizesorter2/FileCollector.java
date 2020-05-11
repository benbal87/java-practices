package com.ben.javapractices.practices.collectionsandfileoperations.filesizesorter2;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FileCollector {

    static Map<Long, Set<File>> fileMap = new HashMap<>();

    public static Set<File> removeSameSizedFiles(Set<File> fileSet) {
        Set<CustomFile> customFileSet = new HashSet<>();
        Set<File> result = new HashSet<>();
        for (File file : fileSet) {
            CustomFile cf = new CustomFile(file);
            customFileSet.add(cf);
        }
        result.addAll(customFileSet);
        return result;
    }

    public static Map<Long, Set<File>> collect(String Path) {
        File folder = new File(Path);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                Long size = file.length();
                if (fileMap.containsKey(size)) {
                    fileMap.get(size).add(file);
                } else {
                    Set<File> fileSet = new HashSet<>();
                    fileSet.add(file);
                    fileMap.put(size, fileSet);
                }
            } else if (file.isDirectory()) {
                collect(file.getAbsolutePath());
            }
        }
        return fileMap;
    }

    public static void main(String[] args) {
        Set<File> removed = new HashSet<>();

        File file1 = new File("c:/k/1.txt");
        File file2 = new File("c:/k/2.txt");
        File file3 = new File("c:/k/3.txt");
        File file4 = new File("c:/k/4.txt");

        removed.add(file1);
        removed.add(file2);
        removed.add(file3);
        removed.add(file4);

        Set<File> fileSet = removeSameSizedFiles(removed);
        System.out.println(fileSet.size());

        for (File file : fileSet) {
            System.out.println(file.getAbsolutePath());
        }
    }

}
