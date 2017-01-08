package ru.sdroman;

/**
 * Class Point.
 *
 * @author sdroman
 * @since 20.12.2016
 * @version 1.0
 */
public class Point {

    /**
     * координата X.
     */
    private int x;

    /**
     * координата Y.
     */
    private int y;

    /**
     * Значение.
     */
    private int value;

    /**
     * Конструктор для двух параметров.
     * @param x int
     * @param y int
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Конструктор для трех параметров.
     * @param x int
     * @param y int
     * @param value int
     */
    public Point(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    /**
     * get x.
     * @return int
     */
    public int getX() {
        return this.x;
    }

    /**
     * get y.
     * @return int
     */
    public int getY() {
        return this.y;
    }

    /**
     * get value.
     * @return int
     */
    public int getValue() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return point.x == x && point.y == y && point.value == value;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
