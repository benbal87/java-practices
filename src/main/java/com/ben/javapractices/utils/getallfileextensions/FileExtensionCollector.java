package com.ben.javapractices.utils.getallfileextensions;

import java.io.File;
import java.util.HashSet;
import java.util.Objects;

import org.apache.commons.io.FilenameUtils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class FileExtensionCollector {

    private void collectExtensions(String dirPath, HashSet<String> extensions) {
        File[] filesInWorkingDirectory = Objects.requireNonNull(new File(dirPath).listFiles());

        for (File file : filesInWorkingDirectory) {
            if (!file.isDirectory()) {
                String extension = FilenameUtils.getExtension(file.getAbsolutePath());
                extensions.add(extension);
            } else {
                dirPath = file.getAbsolutePath();
                collectExtensions(dirPath, extensions);
            }
        }
    }

    public HashSet<String> getExtensions(String dirPath) {
        HashSet<String> extensions = new HashSet<>();
        collectExtensions(dirPath, extensions);
        return extensions;
    }

}
