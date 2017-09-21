package ru.sdroman.bomberman;

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
     * Array of blocks.
     */
    private final Position[] block;

    /**
     * Board.
     */
    private final Cell[][] board;

    /**
     * Constructs a new Board object.
     *
     * @param x int
     * @param y int
     * @param block Position[]
     */
    public Board(final int x, final int y, final Position[] block) {
        this.maxX = x;
        this.maxY = y;
        this.block = block;
        this.board = new Cell[x][y];
        fillBoard();
    }

    /**
     * Fills board.
     */
    private void fillBoard() {
        int numBlock = 0;
        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxY; j++) {
                this.board[i][j] = new Cell(new Position(i, j));
                if (numBlock < block.length && i == this.block[numBlock].getX() && j == this.block[numBlock].getY()) {
                    this.board[i][j].getLock().lock();
                    numBlock++;
                }
            }
        }
    }

    /**
     * Returns cell.
     *
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
     *
     * @param x int
     * @param y int
     * @return true if point on board
     */
    public boolean isOnBoard(int x, int y) {
        return x >= 0 && y >= 0 && x < maxX && y < maxY;
    }
}
