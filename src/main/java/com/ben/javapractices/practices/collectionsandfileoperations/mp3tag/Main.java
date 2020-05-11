package com.ben.javapractices.practices.collectionsandfileoperations.mp3tag;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.NotDirectoryException;
import java.util.List;

import com.ben.javapractices.utils.Util;

public class Main {

    public static void main(String[] args) {
        String resourcePath = Util.getResourcePath();
        File directory = new File(resourcePath + "test_files/mp3_tag/");
        String extension = "mp3";
        try {
            DirectoryScanner directoryScanner = new DirectoryScanner(directory, extension);
            List<File> mp3Files = directoryScanner.getMP3Files();
            for (File mp3File : mp3Files) {
                ID3Tag tag = ID3Tag.parse(mp3File);
                System.out.println(tag);
            }
        } catch (FileNotFoundException | NotDirectoryException exception) {
            exception.printStackTrace();
        }
    }

}
