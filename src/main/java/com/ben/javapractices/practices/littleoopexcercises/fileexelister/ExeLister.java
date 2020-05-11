package com.ben.javapractices.practices.littleoopexcercises.fileexelister;

import java.io.File;
import java.io.FileFilter;

public class ExeLister {

    public static void main(String[] args) {
        ExeLister m = new ExeLister();
        try {
            File[] executables = m.getExecutables(new File("C:\\Windows"));
            for (File file : executables) {
                System.out.println(file.getAbsolutePath());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private File[] getExecutables(File directory) throws Exception {
        if (!directory.isDirectory()) {
            throw new Exception();
        }
        return directory.listFiles(new FileFilter() {

            @Override
            public boolean accept(File pathname) {
                return (pathname.isFile() && pathname.getName().toLowerCase().endsWith(".exe"));
            }
        });
    }

}
