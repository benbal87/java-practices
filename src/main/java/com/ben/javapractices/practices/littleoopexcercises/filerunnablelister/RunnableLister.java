package com.ben.javapractices.practices.littleoopexcercises.filerunnablelister;

import java.io.File;
import java.io.FileFilter;

public class RunnableLister {

    private static File[] getExecutables(File dir) {
        return dir.listFiles(new ExeFilter());
    }

    public static void main(String[] args) {
        File file_01 = new File("C:\\Windows");

        File[] fileList = getExecutables(file_01);

        for (File file : fileList) {
            System.out.println(file.getAbsolutePath());
        }
    }

    static class ExeFilter implements FileFilter {

        @Override
        public boolean accept(File pathname) {
            return pathname.getName().endsWith(".dll");
        }

    }

}
