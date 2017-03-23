package ru.sdroman.TicTacToe.exceptions;

/**
 * Class OccupiedCellException.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class OccupiedCellException extends Exception {

    /**
     * Constructs the new OccupiedCellException object.
     *
     * @param msg String
     */
    public OccupiedCellException(String msg) {
        super(msg);
    }
}
