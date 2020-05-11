package com.ben.javapractices.utils;

import java.io.File;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.ben.javapractices.practices.collectionsandfileoperations.mp3concatenation.Mp3Concatenation1;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Util {

    public String getResourcePath() {
        String path = null;
        try {
            URI resourcePathFile = Mp3Concatenation1.class.getResource("/RESOURCE_PATH").toURI();
            String resourcePath = Files.readAllLines(Paths.get(resourcePathFile)).get(0);
            URI rootURI = new File("").toURI();
            URI resourceURI = new File(resourcePath).toURI();
            URI relativeResourceURI = rootURI.relativize(resourceURI);
            path = relativeResourceURI.getPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return path;
    }

}
