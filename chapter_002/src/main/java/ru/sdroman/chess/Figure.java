package ru.sdroman.chess;

/**
 * abstract class Figure.
 */
public abstract class Figure {

    /**
     * position.
     */
    protected final Cell position;

    /**
     * Constructs new Figure.
     *
     * @param position Cell.
     */
    public Figure(Cell position) {
        this.position = position;
    }

    /**
     * returns figure's way.
     *
     * @param dist Cell
     * @return Cell[]
     * @throws ImpossibleMoveException msg;
     */
    public abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    /**
     * Rewrite figure's position.
     *
     * @param dist Cell
     * @return Figure
     */
    public abstract Figure clone(Cell dist);
}
