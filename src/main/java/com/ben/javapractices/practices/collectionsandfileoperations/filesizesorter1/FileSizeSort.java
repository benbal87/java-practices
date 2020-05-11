/*
 * Write a program which gets the absolute path of a directory and collects the
 * contained files in a map in unlimited depth. Which keys will be the size of files and the
 * values will a Set which will contains the files with the same file sizes.
 */

package com.ben.javapractices.practices.collectionsandfileoperations.filesizesorter1;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ben.javapractices.utils.Util;

public class FileSizeSort {

    private List<File> fileList = new ArrayList<>();

    private String folder;

    private Map<Long, Set<File>> filesMap = new HashMap<>();

    public FileSizeSort(String directory) {
        this.folder = directory;
        getFiles();
    }

    public static void main(String[] args) {
        String resourcePath = Util.getResourcePath();
        String folder = resourcePath + "test_files/file_size_sorter/";
        FileSizeSort fileSizeSort = new FileSizeSort(folder);
        fileSizeSort.sortFiles();

        Map<Long, Set<File>> filesSorted = fileSizeSort.getFilesMap();

        for (Long key : filesSorted.keySet()) {
            System.out.println(key + "Kbyte file size\n");

            for (File file : filesSorted.get(key)) {
                System.out.println(file.getName());
            }

            System.out.println("-----------------------\n");
        }
    }

    public Map<Long, Set<File>> getFilesMap() {
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
                Set<File> fileSet = new HashSet<>();
                fileSet.add(file);
                filesMap.put(size, fileSet);
            }
        }
    }

}
