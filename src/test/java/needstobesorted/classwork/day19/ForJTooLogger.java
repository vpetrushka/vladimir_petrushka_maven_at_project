package needstobesorted.classwork.day19;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ForJTooLogger {

    private static final Logger LOGGER = LogManager.getLogger(ForJTooLogger.class.getName());

    public static void main(String[] args) {

        LOGGER.fatal("Сообщение с уровнем FATAL");
        LOGGER.error("Сообщение с уровнем ERROR");
        LOGGER.warn("Сообщение с уровнем WARNING");
        LOGGER.info("Сообщение с уровнем INFO");
        LOGGER.debug("Сообщение с уровнем DEBUG");
        LOGGER.trace("Сообщение с уровнем TRACE");
    }
}