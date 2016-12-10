package ru.sdroman.chess;

import org.junit.Test;
import ru.sdroman.chess.models.Bishop;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class BishopTest.
 *
 * @author sdroman
 * @version 1.0
 * @since 08.12.2016
 */
public class BishopTest {

    /**
     * Test way method in Bishop class.
     *
     * @throws ImpossibleMoveException exception
     */
    @Test
    public void whenWayThenReturnsCellsArray() throws ImpossibleMoveException {
        final int sourceX = 1;
        final int sourceY = 2;
        final int distX = 4;
        final int distY = 5;
        Bishop bishop = new Bishop(new Cell(sourceX, sourceY));
        Cell dist = new Cell(distX, distY);
        final int cellOneX = 2;
        final int cellOneY = 3;
        final int cellTwoX = 3;
        final int cellTwoY = 4;
        final int cellThreeX = 4;
        final int cellThreeY = 5;
        Cell[] expected = new Cell[]{new Cell(cellOneX, cellOneY),
                new Cell(cellTwoX, cellTwoY), new Cell(cellThreeX, cellThreeY)};
        assertThat(expected, is(bishop.way(dist)));
    }

    /**
     * Test ImpossibleMoveException exception.
     *
     * @throws ImpossibleMoveException exception
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenWayThenException() throws ImpossibleMoveException {
        final int sourceX = 2;
        final int sourceY = 2;
        final int distX = 5;
        final int distY = 6;
        Bishop bishop = new Bishop(new Cell(sourceX, sourceY));
        bishop.way(new Cell(distX, distY));
    }

    /**
     * Test clone() method in Bishop class.
     */
    @Test
    public void whenCloneFigureThenRewriteFigure() {
        final int sourceX = 2;
        final int sourceY = 3;
        final int distX = 4;
        final int distY = 5;
        Bishop bishop = new Bishop(new Cell(sourceX, sourceY));
        bishop = (Bishop) bishop.clone(new Cell(distX, distY));
        final int x = 4;
        final int y = 5;
        assertThat(x, is(bishop.position.x));
        assertThat(y, is(bishop.position.y));
    }
}
