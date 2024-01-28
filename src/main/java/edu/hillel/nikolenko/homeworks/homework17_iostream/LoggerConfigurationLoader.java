package edu.hillel.nikolenko.homeworks.homework17_iostream;

public interface LoggerConfigurationLoader<T extends LoggerConfiguration> {
    T load(FileLoggerConfiguration fileLoggerConfiguration);
}
