package ru.sdroman.TicTacToe;

import org.junit.Before;
import org.junit.Test;
import ru.sdroman.TicTacToe.exceptions.OccupiedCellException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Field class.
 * @author sdroman
 * @since 03.2017
 * @version 0.1
 */
public class FieldTest {

    /**
     * X.
     */
    private static final int PLAYER_X = 1;

    /**
     * 0.
     */
    private static final int PLAYER_O = -1;

    /**
     * Field's size.
     */
    private final int size = 3;

    /**
     * Field.
     */
    private Field field;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        final int winCount = 3;
        field = new Field(winCount, size);
    }

    /**
     * Test move() method in empty cell.
     * @throws OccupiedCellException exception
     */
    @Test
    public void whenMoveInEmptyCellThenSetPlayerInCell() throws OccupiedCellException {
        final int x = 0;
        final int y = 0;
        final int player = 1;
        field.move(x, y, player);
        assertThat(field.getCell(x, y), is(1));
    }

    /**
     * Generates exception in move method.
     * @throws OccupiedCellException exception
     */
    @Test(expected = OccupiedCellException.class)
    public void whenMoveInOccupiedCellThenException() throws OccupiedCellException {
        final int x = 0;
        final int y = 0;
        final int playerX = 1;
        final int playerO = 0;
        field.move(x, y, playerX);
        field.move(x, y, playerO);
    }

    /**
     * Test hasWinner method.
     * @throws OccupiedCellException exception
     */
    @Test
    public void whenWinLengthIsLineThenReturnTrue() throws OccupiedCellException {
        for (int i = 0; i < size; i++) {
            field.move(0, i, PLAYER_X);
        }
        assertThat(field.hasWinner(), is(true));
    }

    /**
     * Test hasWinner method.
     */
    @Test
    public void whenNoWinLengthThenReturnFalse() {
        assertThat(field.hasWinner(), is(false));
    }

    /**
     * Test hasWinner method.
     * @throws OccupiedCellException exception
     */
    @Test
    public void whenWinLengthIsColumnThenReturnTrue() throws OccupiedCellException {
        for (int i = 0; i < size; i++) {
            field.move(i, 0, PLAYER_O);
        }
        assertThat(field.hasWinner(), is(true));
    }

    /**
     * Test hasWinner method.
     * @throws OccupiedCellException exception
     */
    @Test
    public void whenWinLengthIsMainDiagonalThenReturnTrue() throws OccupiedCellException {
        for (int i = 0; i < size; i++) {
            field.move(i, i, PLAYER_X);
        }
        assertThat(field.hasWinner(), is(true));
    }

    /**
     * Test hasWinner method.
     * @throws OccupiedCellException excepti
     */
    @Test
    public void whenWinLengthIsSecondDiagonalThenReturnTrue() throws OccupiedCellException {
        for (int i = 0; i < size; i++) {
            field.move(i, size - 1 - i, PLAYER_O);
        }
        assertThat(field.hasWinner(), is(true));
    }
}
