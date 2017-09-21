package ru.sdroman.bomberman;

/**
 * @author sdroman
 * @since 09.2017
 */
public class Position {
    /**
     * Coordinate x.
     */
    private final int x;

    /**
     * Coordinate y.
     */
    private final int y;

    /**
     * Constructs a new Position object.
     *
     * @param x int
     * @param y int
     */
    public Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns x.
     *
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * Returns y.
     *
     * @return int
     */
    public int getY() {
        return y;
    }
}
