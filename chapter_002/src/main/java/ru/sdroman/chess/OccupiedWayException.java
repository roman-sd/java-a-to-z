package ru.sdroman.chess;

/**
 * Class OccupiedWayException.
 * @author sdroman
 * @since 07.12.2016
 * @version 1.0
 */
public class OccupiedWayException extends Exception {

    /**
     * Constructs OccupiedWayException.
     * @param msg String
     */
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
