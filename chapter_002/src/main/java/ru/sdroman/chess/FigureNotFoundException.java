package ru.sdroman.chess;

/**
 * Class FigureNotFoundException.
 * @author sdroman
 * @since 07.12.2016
 * @version 1.0
 */
public class FigureNotFoundException extends Exception {

    /**
     * Constructs new FigureNotFoundException exception.
     * @param msg String
     */
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}
