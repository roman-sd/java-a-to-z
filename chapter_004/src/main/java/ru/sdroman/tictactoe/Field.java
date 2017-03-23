package ru.sdroman.tictactoe;

import ru.sdroman.tictactoe.interfaces.IField;
import ru.sdroman.tictactoe.exceptions.OccupiedCellException;

/**
 * Class Field.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class Field implements IField {

    /**
     * Array of cells.
     */
    private int[][] field;

    /**
     * WinCount.
     */
    private int winLength;

    /**
     * Array's size.
     */
    private int size;

    /**
     * Constructs the new Field object.
     *
     * @param winCount int
     * @param size     int
     */
    public Field(int winCount, int size) {
        this.size = size;
        this.winLength = winCount;
        this.field = new int[this.size][this.size];
        this.fillField();
    }

    /**
     * Fills the array of -1.
     */
    private void fillField() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.field[i][j] = 0;
            }
        }
    }

    /**
     * Returns cell's value.
     *
     * @param x int
     * @param y int
     * @return int
     */
    @Override
    public int getCell(int x, int y) {
        return this.field[x][y];
    }

    /**
     * Makes a move.
     *
     * @param x      int
     * @param y      int
     * @param player int
     * @throws OccupiedCellException exception
     */
    @Override
    public void move(int x, int y, int player) throws OccupiedCellException {
        if (this.isEmpty(x, y)) {
            this.field[x][y] = player;
        } else {
            throw new OccupiedCellException("Cell is occupied.");
        }
    }

    /**
     * Checks line.
     *
     * @param x        int
     * @param y        int
     * @param dx       int
     * @param dy       int
     * @param winCount int
     * @return boolean
     */
    private boolean checkWinLength(int x, int y, int dx, int dy, int winCount) {
        boolean result = false;
        if (winCount == this.winLength) {
            result = true;
        } else {
            if (x < size && y < size
                    && this.field[x][y] == this.field[x + dx][y + dy]) {
                result = checkWinLength(x + dx, y + dy, dx, dy, winCount + 1);
            }
        }
        return result;
    }

    /**
     * hasWinner.
     *
     * @return boolean
     */
    @Override
    public boolean hasWinner() {
        boolean result = false;
        for (int i = 0; i < this.winLength; i++) {
            if (this.checkWinLength(i, 0, 0, 1, 1) && !this.isEmpty(i, 0)
                    || this.checkWinLength(0, i, 1, 0, 1) && !this.isEmpty(0, i)) {
                result = true;
            }
        }
        if (!result) {
            if (this.checkWinLength(0, 0, 1, 1, 1) && !this.isEmpty(0, 0)
                    || this.checkWinLength(0, size - 1, 1, -1, 1) && !this.isEmpty(0, 2)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * Returns field's size.
     *
     * @return int
     */
    public int getSize() {
        return size;
    }

    /**
     * isEmpty.
     *
     * @param x int
     * @param y int
     * @return boolean
     */
    private boolean isEmpty(int x, int y) {
        return this.getCell(x, y) == 0;
    }

    /**
     * Returns array of cells.
     *
     * @return int[][]
     */
    @Override
    public int[][] getField() {
        return this.field;
    }
}

