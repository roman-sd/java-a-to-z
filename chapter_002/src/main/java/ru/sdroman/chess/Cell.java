package ru.sdroman.chess;

/**
 * Class Cell.
 *
 * @author sdroman.
 * @version 1.0
 * @since 07.12.2016
 */
public class Cell {

    /**
     * x.
     */
    public int x;
    /**
     * y.
     */
    public int y;

    /**
     * Constructs a new Cell.
     *
     * @param x int
     * @param y int
     */
    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cell)) {
            return false;
        }
        Cell cell = (Cell) obj;
        return cell.x == x && cell.y == y;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
