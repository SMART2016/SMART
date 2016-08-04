package com.smart.log.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by dipanjan on 25/03/16.
 */
public class Log4jLoggerImpl implements com.smart.log.Logger {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Log4jLoggerImpl instance = new Log4jLoggerImpl();

    private Log4jLoggerImpl() {
    }

    private Logger logger;

    public static com.smart.log.Logger getInstance() {
        return instance;
    }

    public void createLogger(Class className) {
        this.logger = LogManager.getLogger(className);
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    @Override
    public void debug(String message, Throwable t) {
        if (logger != null) {
            logger.debug(message, t);
        } else {
            LOGGER.debug(message, t);
        }
    }

    @Override
    public void error(String message) {
        if (logger != null) {
            logger.error(message);
        } else {
            LOGGER.error(message);
        }
    }

    @Override
    public void error(String message, Throwable t) {
        if (logger != null) {
            logger.error(message, t);
        } else {
            LOGGER.error(message, t);
        }
    }

    @Override
    public void warning(String message) {
        if (logger != null) {
            logger.warn(message);
        } else {
            LOGGER.warn(message);
        }
    }

    @Override
    public void warning(String message, Throwable t) {
        if (logger != null) {
            logger.warn(message, t);
        } else {
            LOGGER.warn(message, t);
        }
    }

    @Override
    public void info(String message) {
        if (logger != null) {
            logger.info(message);
        } else {
            LOGGER.info(message);
        }
    }

    @Override
    public void info(String message, Throwable t) {
        if (logger != null) {
            logger.info(message, t);
        } else {
            LOGGER.info(message, t);
        }
    }
}
