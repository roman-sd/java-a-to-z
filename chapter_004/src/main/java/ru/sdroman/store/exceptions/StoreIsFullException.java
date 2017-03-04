package ru.sdroman.store.exceptions;

/**
 * Class StoreIsFullException.
 * @author sdroman
 * @since 02.17
 * @version 0.1
 */
public class StoreIsFullException extends Exception {

    /**
     * Constructs new StoreIsFullException object.
     * @param msg String
     */
    public StoreIsFullException(String msg) {
        super(msg);
    }
}
