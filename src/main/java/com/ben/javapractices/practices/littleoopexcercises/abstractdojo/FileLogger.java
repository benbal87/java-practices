package com.ben.javapractices.practices.littleoopexcercises.abstractdojo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        super(level);
    }

    @Override
    protected void write(String message) {
        try {
            FileWriter writer = new FileWriter("log.txt", true);
            writer.write("[" + Calendar.getInstance().getTime() + "]: " + message + "\n");
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
