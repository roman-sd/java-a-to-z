package ru.sdroman.bomberman;

/**
 * @author sdroman
 * @since 09.2017
 */
public interface Input {

    /**
     * Returns new coordinates.
     *
     * @param board    Board
     * @param position Position
     * @return next position
     */
    Position nextStep(Board board, Position position);
}
