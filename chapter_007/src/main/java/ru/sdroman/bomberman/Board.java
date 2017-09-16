package ru.sdroman.bomberman;


import java.util.Arrays;

/**
 * @author sdroman
 * @since 09.2017
 */
public class Board {

    /**
     * Max x coordinate.
     */
    private final int maxX;

    /**
     * Max y coordinate.
     */
    private final int maxY;

    /**
     * Board.
     */
    private final Cell[][] board;

    /**
     * Constructs a new Board object.
     * @param x int
     * @param y int
     */
    public Board(final int x, final int y) {
        this.maxX = x;
        this.maxY = y;
        this.board = new Cell[x][y];
        fillBoard();
    }

    /**
     * Fills board.
     */
    private void fillBoard() {
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxY; j++) {
                board[i][j] = new Cell(new Position(i, j));
            }
        }
    }

    /**
     * Returns cell.
     * @param position Position
     * @return Cell
     */
    public Cell getCell(Position position) {
        Cell cell = null;
        int x = position.getX();
        int y = position.getY();
        if (isOnBoard(x, y)) {
            cell = this.board[x][y];
        }
        return cell;
    }

    /**
     * Checks position.
     * @param x int
     * @param y int
     * @return true if point on board
     */
    private boolean isOnBoard(int x, int y) {
        return x >= 0 && y >= 0 && x < maxX && y < maxY;
    }
}
