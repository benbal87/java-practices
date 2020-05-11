package com.ben.javapractices.practices.littleoopexcercises.abstractdojo;

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        super(level);
    }

    @Override
    public void write(String message) {
        System.out.println("[Console]: " + message);
    }

}
