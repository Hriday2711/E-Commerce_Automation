package utils;

import org.apache.logging.log4j.*;

public class Log {

    public static Logger log = LogManager.getLogger(Log.class.getName());

    //Creating these below methods so that we can use the log
    public static void logComment(String message) {
        log.info("Comment: " + message);
    }
    public static void logWarning(String message) {
        log.info("Warning: " + message);
    }
    public static void logStep(String message) {
        log.info("Step: " + message);
    }
    public static void logAction(String message) {
        log.info("Action: " + message);
    }
}
