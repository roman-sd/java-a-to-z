package ru.sdroman.aquariumtest;

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
     * @param x int
     * @param y int
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns x.
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * Returns y.
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * Sets x.
     * @param x int
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets y.
     * @param y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * toString.
     * @return String
     */
    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
