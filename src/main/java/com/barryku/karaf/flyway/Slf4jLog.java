package com.barryku.karaf.flyway;

import org.flywaydb.core.api.logging.Log;
import org.slf4j.Logger;

/** Workaround flywaydb-5.2.4 bad OSGi log factory. */
class Slf4jLog implements Log {
    /**
     * Slf4j Logger.
     */
    private final Logger logger;

    /**
     * Creates a new wrapper around this logger.
     *
     * @param logger The original Slf4j Logger.
     */
    public Slf4jLog(Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void error(String message, Exception e) {
        logger.error(message, e);
    }
}