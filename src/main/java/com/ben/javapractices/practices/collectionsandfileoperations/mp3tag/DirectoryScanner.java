package com.ben.javapractices.practices.collectionsandfileoperations.mp3tag;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.List;

public class DirectoryScanner {

    List<File> mp3Files;

    public DirectoryScanner(File directory, String extension) throws FileNotFoundException, NotDirectoryException {
        if (!directory.exists()) {
            throw new FileNotFoundException();
        }
        if (directory.isFile()) {
            throw new NotDirectoryException(extension);
        }
        if (directory.isDirectory()) {
            mp3Files = new ArrayList<File>();
            collect(directory);
        }
    }

    public List<File> getMP3Files() {
        return mp3Files;
    }

    public void collect(File directory) {
        File[] fileList = directory.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                if (pathname.isFile()) {
                    String extension;
                    int lastPointIndex = pathname.getName().lastIndexOf('.');
                    if (lastPointIndex > -1) {
                        extension = pathname.getName().substring(lastPointIndex + 1);
                        return extension.toLowerCase().equals("mp3");
                    } else {
                        return false;
                    }
                }
                return true;
            }
        });
        if (fileList != null) {
            for (File file : fileList) {
                if (file.isDirectory()) {
                    collect(file);
                } else {
                    mp3Files.add(file);
                }
            }
        }
    }

}
