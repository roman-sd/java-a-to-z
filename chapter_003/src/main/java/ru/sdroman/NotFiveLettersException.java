package ru.sdroman;

/**
 * Class NotFiveLettersException.
 * @author sdroman
 * @since 20.01.17
 * @version 1.0
 */
public class NotFiveLettersException extends Exception {

    /**
     * Constructs new NotFiveLettersException.
     * @param msg String
     */
    NotFiveLettersException(String msg) {
        super(msg);
    }
}
