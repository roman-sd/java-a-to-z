package ru.sdroman.TicTacToe;

import org.junit.Before;
import org.junit.Test;
import ru.sdroman.TicTacToe.Interfaces.Input;
import ru.sdroman.TicTacToe.Interfaces.Output;
import ru.sdroman.TicTacToe.exceptions.OccupiedCellException;
import ru.sdroman.TicTacToe.input.RandomInput;
import ru.sdroman.TicTacToe.input.StubInput;
import ru.sdroman.TicTacToe.output.ConsoleOutput;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Game class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class GameTest {

    /**
     * Field's size.
     */
    private final int size = 3;

    /**
     * winLength.
     */
    private final int winLength = 3;

    /**
     * Game.
     */
    private Game game;

    /**
     * Output.
     */
    private Output output;

    /**
     * Setup.
     */
    @Before
    public void before() {
        output = new ConsoleOutput();
    }

    /**
     * Setup.
     *
     * @param firstPlayerMoves  String[]
     * @param secondPlayerMoves String[]
     * @throws OccupiedCellException exception
     */
    private void setUp(String[] firstPlayerMoves, String[] secondPlayerMoves) throws OccupiedCellException {
        Input inputPlayer1 = new StubInput(firstPlayerMoves);
        Input inputPlayer2 = new StubInput(secondPlayerMoves);
        game = new Game(inputPlayer1, inputPlayer2, output, winLength, size);
        game.runGame(1);
    }

    /**
     * Test draw.
     *
     * @throws OccupiedCellException exception
     */
    @Test
    public void whenRoundDrawThenCountDraw() throws OccupiedCellException {
        String[] firstPlayerMoves = new String[]{"0 0", "1 1", "1 2", "2 0", "0 1", "0 0", "1 1", "2 2"};
        String[] secondPlayerMoves = new String[]{"0 2", "2 2", "2 1", "1 0", "0 2", "2 0"};
        setUp(firstPlayerMoves, secondPlayerMoves);
        assertThat(game.getScoreDraw(), is(1));
    }

    /**
     * Test first player's score.
     *
     * @throws OccupiedCellException exception
     */
    @Test
    public void whenFirstPlayerIsWinThenCountPlayerScore() throws OccupiedCellException {
        String[] firstPlayerMoves = new String[]{"0 0", "1 1", "2 2"};
        String[] secondPlayerMoves = new String[]{"0 2", "2 0"};
        setUp(firstPlayerMoves, secondPlayerMoves);
        assertThat(game.getScorePlayer(), is(1));
    }

    /**
     * Test second player's score.
     *
     * @throws OccupiedCellException exception
     */
    @Test
    public void whenSecondPlayerIsWinThenCountAIScore() throws OccupiedCellException {
        String[] firstPlayerMoves = new String[]{"0 1", "1 1", "2 2"};
        String[] secondPlayerMoves = new String[]{"0 0", "1 0", "2 0"};
        setUp(firstPlayerMoves, secondPlayerMoves);
        assertThat(game.getScoreAI(), is(1));
    }

    /**
     * Test a number of round.
     *
     * @throws OccupiedCellException exception
     */
    @Test
    public void whenSetRoundNumberThenCountWinRounds() throws OccupiedCellException {
        final int expected = 5;
        final int numRounds = 5;
        Input inputFirstPlayer = new RandomInput();
        Input inputSecondPlayer = new RandomInput();
        game = new Game(inputFirstPlayer, inputSecondPlayer, output, winLength, size);
        game.runGame(numRounds);
        int actual = this.game.getScorePlayer() + this.game.getScoreAI();
        assertThat(actual, is(expected));
    }
}
