package com.ben.javapractices.practices.littleoopexcercises.abstractdojo;

public class ChainPatternDemo {

    public static void main(String[] args) {
        AbstractLogger loggerChain = getLoggerChain();
        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug-information.");
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error-message.");
    }

    private static AbstractLogger getLoggerChain() {
        AbstractLogger consoleLogger = new ConsoleLogger(ConsoleLogger.INFO);
        AbstractLogger errorLogger = new ErrorLogger(ErrorLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(FileLogger.DEBUG);
        consoleLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(errorLogger);
        return consoleLogger;
    }

}
