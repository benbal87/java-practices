package com.ben.javapractices.practices.littleoopexcercises.filehandler;

import java.io.PrintStream;
import java.util.Random;

public class FileHandlerTest {

    public static void main(String[] args) {
        String file = "d://movies.xml";

        try {
            FileHandler handler = new FileHandler(file);
            handler.writeData(10);
            handler.closeFile();

            PrintStream outOld = System.out;

            Random r = new Random();

            System.setOut(new PrintStream("c://sysout.log"));

            for (int i = 0; i < 500000; i++) {

                int data = r.nextInt(1000);
                System.out.println("Written data: " + data);
                handler.writeData(data);
            }
            handler.closeFile();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
