package ru.sdroman.chess;

import org.junit.Test;
import ru.sdroman.chess.models.Bishop;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class BoardTest.
 *
 * @author sdroman
 * @version 1.0
 * @since 08.12.2016
 */
public class BoardTest {

    /**
     * Test move().
     *
     * @throws OccupiedWayException exception
     * @throws ImpossibleMoveException exception
     * @throws FigureNotFoundException exception
     */
    @Test
    public void whenMoveThenTrue() throws
            OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        final int sourceX = 0;
        final int sourceY = 2;
        final int distX = 5;
        final int distY = 7;
        Board board = new Board();
        Cell source = new Cell(sourceX, sourceY);
        Cell dist = new Cell(distX, distY);
        Bishop bishop = new Bishop(source);
        board.addFigure(bishop);
        boolean isMove = board.move(source, dist);
        assertThat(true, is(isMove));
    }

    /**
     * Test move().
     *
     * @throws OccupiedWayException exception
     * @throws ImpossibleMoveException exception
     * @throws FigureNotFoundException exception
     */
    @Test(expected = OccupiedWayException.class)
    public void whenMoveThenOccupiedWayException() throws
            OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        final int sourceX = 1;
        final int sourceY = 3;
        final int distX = 5;
        final int distY = 7;
        final int X = 3;
        final int Y = 5;
        Board board = new Board();
        Cell source = new Cell(sourceX, sourceY);
        Cell dist = new Cell(distX, distY);
        Bishop whiteBishop = new Bishop(source);
        Bishop blackBishop = new Bishop(new Cell(X, Y));
        board.addFigure(whiteBishop);
        board.addFigure(blackBishop);
        board.move(source, dist);
    }

    /**
     * Test move().
     *
     * @throws OccupiedWayException exception
     * @throws ImpossibleMoveException exception
     * @throws FigureNotFoundException exception
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenMoveThenImpossibleMoveException() throws
            OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        final int sourceX = 2;
        final int sourceY = 5;
        final int distX = 4;
        final int distY = 6;
        Board board = new Board();
        Cell source = new Cell(sourceX, sourceY);
        Bishop bishop = new Bishop(source);
        board.addFigure(bishop);
        board.move(source, new Cell(distX, distY));
    }

    /**
     * Test move().
     *
     * @throws OccupiedWayException exception
     * @throws ImpossibleMoveException exception
     * @throws FigureNotFoundException exception
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenMoveThenFigureNotFoundException() throws
            OccupiedWayException, ImpossibleMoveException, FigureNotFoundException {
        final int sourceX = 2;
        final int sourceY = 5;
        final int distX = 3;
        final int distY = 7;
        final int x = 1;
        final int y = 7;
        Board board = new Board();
        Cell source = new Cell(sourceX, sourceY);
        Bishop bishop = new Bishop(source);
        board.addFigure(bishop);
        board.move(new Cell(x, y), new Cell(distX, distY));
    }
}
