package ru.sdroman.tictactoe.interfaces;

import ru.sdroman.tictactoe.exceptions.OccupiedCellException;

/**
 * Interface IField.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public interface IField {

    /**
     * Returns cells value.
     *
     * @param x int
     * @param y int
     * @return int
     */
    int getCell(int x, int y);

    /**
     * Move.
     *
     * @param x      int
     * @param y      int
     * @param player int
     * @exception OccupiedCellException exception
     */
    void move(int x, int y, int player) throws OccupiedCellException;

    /**
     * HasWinner.
     *
     * @return boolean
     */
    boolean hasWinner();

    /**
     * Returns field's array.
     *
     * @return int[][]
     */
    int[][] getField();
}
