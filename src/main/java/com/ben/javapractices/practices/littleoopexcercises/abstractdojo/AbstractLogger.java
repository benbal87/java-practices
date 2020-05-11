package com.ben.javapractices.practices.littleoopexcercises.abstractdojo;

public abstract class AbstractLogger {

    static final int INFO = 1;

    static final int DEBUG = 2;

    static final int ERROR = 3;

    private int level;

    private AbstractLogger nextLogger;

    AbstractLogger(int level) {
        this.level = level;
    }

    void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    protected abstract void write(String message);

}
