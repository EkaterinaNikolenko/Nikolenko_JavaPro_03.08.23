package edu.hillel.nikolenko.homeworks.homework17_iostream;

import java.io.File;

public class Main {
    public static void main(String[] args) throws FileMaxSizeReachedException, InterruptedException {
        File file = new File("LogFile.txt");
        FileLoggerConfiguration fileLoggerConfiguration = new FileLoggerConfiguration(file, LoggingLevel.DEBUG, 500);
        FileLogger fileLogger = new FileLogger(fileLoggerConfiguration);
        FileLoggerConfigurationLoader fileLoggerConfigurationLoader = new FileLoggerConfigurationLoader();
        for (int i = 0; i < 100; i++) {
            fileLogger.debug("debugging");
            Thread.sleep(100);
            fileLogger.info("info");
        }
        fileLoggerConfigurationLoader.load(fileLoggerConfiguration);
    }
}
