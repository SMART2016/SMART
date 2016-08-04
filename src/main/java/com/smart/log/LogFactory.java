package com.smart.log;

import com.smart.log.impl.Log4jLoggerImpl;

/**
 * Created by dipanjan on 25/03/16.
 */
public class LogFactory {
    private LogFactory() {
    }

    public static Logger getLogger(Class className) {
        Logger logger = Log4jLoggerImpl.getInstance();
        logger.createLogger(className);
        return logger;
    }

    public static Logger getConsoleLogger() {
        return Log4jLoggerImpl.getInstance();
    }
}
