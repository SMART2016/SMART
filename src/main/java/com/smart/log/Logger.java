package com.smart.log;

/**
 * Created by dipanjan on 25/03/16.
 */
public interface Logger {
    void createLogger(Class className);

    void debug(String message);

    void debug(String message, Throwable t);

    void error(String message);

    void error(String message, Throwable t);

    void warning(String message);

    void warning(String message, Throwable t);

    void info(String message);

    void info(String message, Throwable t);
}
