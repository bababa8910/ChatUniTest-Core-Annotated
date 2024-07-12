package zju.cst.aces.api;

/**
 * Interface for logging messages at various levels.
 */

public interface Logger {

    /**
     * Logs an informational message.
     *
     * @param msg the message to log
     */
    void info(String msg);

    /**
     * Logs a warning message.
     *
     * @param msg the message to log
     */
    void warn(String msg);

    /**
     * Logs an error message.
     *
     * @param msg the message to log
     */
    void error(String msg);

    /**
     * Logs a debug message.
     *
     * @param msg the message to log
     */
    void debug(String msg);
}
