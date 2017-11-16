package ru.sdroman.aquarium;

/**
 * @author sdroman
 * @since 10.2017
 */
public class Position {
    /**
     * x.
     */
    private int x;

    /**
     * y.
     */
    private int y;

    /**
     * Constructs a new Position object.
     *
     * @param x int
     * @param y int
     */
    public Position(int x, int y) {
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
     * Sets x.
     *
     * @param x int
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns y.
     *
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y int
     */
    public void setY(int y) {
        this.y = y;
    }
}
