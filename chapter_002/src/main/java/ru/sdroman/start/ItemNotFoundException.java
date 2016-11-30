package ru.sdroman.start;

/**
 * class ItemNotFoundException.
 */
public class ItemNotFoundException extends RuntimeException {

    /**
     * Constricts new ItemNotFoundException object.
     *
     * @param msg String
     */
    public ItemNotFoundException(String msg) {
        super(msg);
    }
}
