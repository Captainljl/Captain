package com.ljl.responsibility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ChainPatternDemo {

    private static AbstractLogger getChainOfLoggers(){

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) throws IOException {

        final File file = new File("/Users/liujialei/code/Captain/test.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("刘佳磊" + System.getProperty("line.separator"));
        }


    }
}
