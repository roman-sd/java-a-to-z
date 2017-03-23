package ru.sdroman.tictactoe;

import org.junit.Before;
import org.junit.Test;
import ru.sdroman.tictactoe.Interfaces.IRound;
import ru.sdroman.tictactoe.Interfaces.Input;
import ru.sdroman.tictactoe.Interfaces.Output;
import ru.sdroman.tictactoe.exceptions.OccupiedCellException;
import ru.sdroman.tictactoe.input.StubInput;
import ru.sdroman.tictactoe.output.ConsoleOutput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Round class.
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class RoundTest {

    /**
     * Output.
     */
    private Output output;

    /**
     * round.
     */
    private IRound round;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        this.output = new ConsoleOutput();
    }

    /**
     * Setup.
     * @param firstPlayerMoves String[]
     * @param secondPlayerMoves String[]
     */
    private void settings(String[] firstPlayerMoves, String[] secondPlayerMoves) {
        final int winLength = 3;
        final int size = 3;
        Input inputPlayer1 = new StubInput(firstPlayerMoves);
        Input inputPlayer2 = new StubInput(secondPlayerMoves);
        round = new Round(inputPlayer1, inputPlayer2, output, winLength, size);
    }

    /**
     * Test winner.
     * @throws OccupiedCellException exception
     */
    @Test
    public void whenFirstPlayerHaveWinLengthThenReturnOne() throws OccupiedCellException {
        String[] firstPlayerMoves = new String[]{"0 0", "1 1", "2 2"};
        String[] secondPlayerMoves = new String[]{"0 2", "1 2"};
        settings(firstPlayerMoves, secondPlayerMoves);
        int actual = round.runRound(false);
        assertThat(actual, is(1));
    }

    /**
     * Test winner.
     * @throws OccupiedCellException exception
     */
    @Test
    public void whenSecondPlayerHaveWinLengthThenReturnMinusOne() throws OccupiedCellException {
        String[] firstPlayerMoves = new String[]{"0 0", "0 1", "2 1"};
        String[] secondPlayerMoves = new String[]{"0 2", "1 2", "2 2"};
        settings(firstPlayerMoves, secondPlayerMoves);
        int actual = round.runRound(false);
        assertThat(actual, is(-1));
    }

    /**
     * Test draw.
     * @throws OccupiedCellException exception
     */
    @Test
    public void whenDrawThenReturnZero() throws OccupiedCellException {
        String[] firstPlayerMoves = new String[]{"0 0", "1 1", "1 2", "2 0", "0 1"};
        String[] secondPlayerMoves = new String[]{"0 2", "2 2", "2 1", "1 0"};
        settings(firstPlayerMoves, secondPlayerMoves);
        int actual = round.runRound(false);
        assertThat(actual, is(0));
    }

    /**
     * Test first move.
     * @throws OccupiedCellException exception
     */
    @Test
    public void whenFirstMoveIsSecondPlayerThenReturnMinusOne() throws OccupiedCellException {
        String[] firstPlayerMoves = new String[]{"0 1", "1 0"};
        String[] secondPlayerMoves = new String[]{"1 1", "0 0", "2 2"};
        settings(firstPlayerMoves, secondPlayerMoves);
        int actual = round.runRound(true);
        assertThat(actual, is(-1));
    }
}
