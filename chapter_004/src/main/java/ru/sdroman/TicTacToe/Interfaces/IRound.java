package ru.sdroman.TicTacToe.Interfaces;

import ru.sdroman.TicTacToe.exceptions.OccupiedCellException;

/**
 * Interface IRound.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public interface IRound {

    /**
     * Run.
     *
     * @param isAIFirstMove boolean
     * @return int winner.
     * @throws OccupiedCellException exception
     */
    int runRound(boolean isAIFirstMove) throws OccupiedCellException;
}
