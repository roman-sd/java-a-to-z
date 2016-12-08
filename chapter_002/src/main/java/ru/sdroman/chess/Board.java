package ru.sdroman.chess;

/**
 * Class Board.
 *
 * @author sdroman
 * @version 1.0
 * @since 07.12.2016
 */
public class Board {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 32;

    /**
     * An array of chessmen.
     */
    private Figure[] figures = new Figure[DEFAULT_CAPACITY];

    /**
     * Adds a new figure to the array.
     *
     * @param figure Figure
     */
    public void addFigure(Figure figure) {

        for (int i = 0; i < figures.length; i++) {
            if (figures[i] == null) {
                figures[i] = figure;
                break;
            }
        }
    }

    /**
     * Can a figure move into dist cell.
     *
     * @param source Cell
     * @param dist   Cell
     * @return true
     * @throws ImpossibleMoveException exception
     * @throws OccupiedWayException exception
     * @throws FigureNotFoundException exception
     */
    public boolean move(Cell source, Cell dist)
            throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        boolean flag = false;
        Cell[] figureWay = null;
        for (Figure figure : figures) {
            if (figure != null && figure.position == source) {
                figureWay = figure.way(dist);
                flag = true;
                break;
            }
        }
        if (!flag) {
            throw new FigureNotFoundException("Figure not found");
        }

        flag = false;
        for (Figure figure : figures) {
            for (Cell aFigureWay : figureWay) {
                if (figure != null && figure.position.x == aFigureWay.x && figure.position.y == aFigureWay.y) {
                    flag = true;
                    break;
                }
            }
            if (flag)  {
                break;
            }
        }
        if (flag) {
            throw new OccupiedWayException("Occupied way");
        }

        for (int i = 0; i < figures.length; i++) {
            if (figures[i] != null && figures[i].position.x == source.x && figures[i].position.y == source.y) {
                figures[i] = figures[i].clone(dist);
            }
        }
        return true;
    }
}
