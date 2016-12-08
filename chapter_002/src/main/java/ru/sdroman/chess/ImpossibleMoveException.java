package ru.sdroman.chess;

/**
 * Class ImpossibleMoveException.
 * @author sdroman
 * @since 07.12.2016
 * @version 1.0
 */
public class ImpossibleMoveException extends Exception {

    /**
     * Constructs new ImpossibleMoveException exception.
     * @param msg String
     */
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}
