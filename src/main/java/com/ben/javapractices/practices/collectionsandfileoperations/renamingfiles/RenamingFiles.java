package com.ben.javapractices.practices.collectionsandfileoperations.renamingfiles;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ben.javapractices.utils.Util;

public class RenamingFiles {

    private static final String[] SKIPPABLE_FOLDERS = { "directory_05" };

    private static String workDir;

    private static List<File> fileList = new ArrayList<>();

    private RenamingFiles(String workDir) {
        RenamingFiles.workDir = workDir;
        getFiles();
    }

    public static void main(String[] args) {
        String resourcePath = Util.getResourcePath();
        RenamingFiles renamingFiles = new RenamingFiles(resourcePath + "test_files/renaming_files/");
        renamingFiles.getFiles();
        renamingFiles.printFiles();
    }

    private void getFiles() {
        File[] files = new File(workDir).listFiles();

        if (files != null) {
            for (File file : files) {
                if (!file.isDirectory()) {
                    fileList.add(file);
                } else if (isNotSkippable(file)) {
                    workDir = file.getAbsolutePath();
                    getFiles();
                }
            }
        }
    }

    private boolean isNotSkippable(File file) {
        List<String> splittedPath = getSplittedReplacedAbsoluteFilePath(file);

        for (String exception : SKIPPABLE_FOLDERS) {
            if (splittedPath.contains(exception)) {
                return false;
            }
        }

        return true;
    }

    private List<String> getSplittedReplacedAbsoluteFilePath(File file) {
        String replacedFilePaths = file.getAbsolutePath().replace("\\", "/");
        String[] splittedAbsoluteFilePaths = replacedFilePaths.split("/");
        List<String> splittedPathsList = Arrays.asList(splittedAbsoluteFilePaths);

        return splittedPathsList;
    }

    public void renameFiles() {
        for (File file : fileList) {
            if (!file.isDirectory() & (file.getName().endsWith(".mp4") || file.getName().endsWith(".mkv")
                                       || file.getName().endsWith(".wmv") || file.getName().endsWith(".mov")
                                       || file.getName().endsWith(".avi"))) {
                String newFileName = file.getParentFile().getName();
                String fileExtension = file.getName().substring(file.getName().lastIndexOf("."));
                File rename = new File(file.getParent() + "/" + newFileName + fileExtension);
                file.renameTo(rename);
            }
        }
    }

    private void printFiles() {
        for (File file : fileList) {
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("\n\n");
    }

}
