package ru.sdroman.chess.models;

import ru.sdroman.chess.Cell;
import ru.sdroman.chess.Figure;
import ru.sdroman.chess.ImpossibleMoveException;

import static java.lang.Math.abs;

/**
 * Class Bishop.
 *
 * @author sdroman
 * @version 1.0
 * @since 07.12.2016
 */
public class Bishop extends Figure {

    /**
     * Constructs a new Bishop figure.
     *
     * @param position Cell
     */
    public Bishop(Cell position) {
        super(position);
    }

    /**
     * Returns Bishop's way.
     *
     * @param dist Cell
     * @return Cell[]
     * @throws ImpossibleMoveException exception
     */
    @Override
    public Cell[] way(Cell dist) throws ImpossibleMoveException {
        int deltaX = dist.x - this.position.x;
        int deltaY = dist.y - this.position.y;
        Cell[] figureWay = new Cell[abs(deltaX)];
        final int maxX = 8;
        final int maxY = 8;

        if (dist.x >= 0 && dist.y >= 0 && dist.x < maxX && dist.y < maxY && abs(deltaX) == abs(deltaY)) {
            int vectorX = (deltaX) > 0 ? 1 : -1;
            int vectorY = (deltaY) > 0 ? 1 : -1;
            for (int i = 0; i < abs(deltaX); i++) {
                figureWay[i] =
                        new Cell(this.position.x + (i + 1) * vectorX, this.position.y + (i + 1) * vectorY);
            }
        } else {
            throw new ImpossibleMoveException("Impossible move");
        }
        return figureWay;
    }

    /**
     * Rewrite Bishop's position.
     *
     * @param dist Cell
     * @return figure
     */
    @Override
    public Figure clone(Cell dist) {
        return new Bishop(dist);
    }
}
