package com.ben.javapractices.practices.collectionsandfileoperations.filesizesorter2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class CustomFile extends File {

    public CustomFile(File file) {
        super(file.getAbsolutePath());
    }

    public static void main(String[] args) {
        CustomFile cf1 = new CustomFile(new File("C://k/1.txt"));
        CustomFile cf2 = new CustomFile(new File("C://k/3.txt"));
        System.out.println(cf1.equals(cf2));
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            FileInputStream fis1 = new FileInputStream((File) obj);
            FileInputStream fis2 = new FileInputStream(this);
            BufferedInputStream bis1 = new BufferedInputStream(fis1);
            BufferedInputStream bis2 = new BufferedInputStream(fis2);
            byte[] buffer1 = new byte[8192];
            byte[] buffer2 = new byte[8192];
            int readBytes1 = bis1.read(buffer1);
            int readBytes2 = bis2.read(buffer2);
            if (readBytes1 != readBytes2) {
                bis1.close();
                bis2.close();
                return false;
            }
            for (int i = 0; i < readBytes1; i++) {
                if (buffer1[i] != buffer2[i]) {
                    break;
                }
            }
            bis1.close();
            bis2.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
