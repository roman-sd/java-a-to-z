package ru.sdroman.tictactoe;

import ru.sdroman.tictactoe.Interfaces.IRound;
import ru.sdroman.tictactoe.Interfaces.Input;
import ru.sdroman.tictactoe.Interfaces.Output;
import ru.sdroman.tictactoe.exceptions.OccupiedCellException;

/**
 * Class Game.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class Game {

    /**
     * winLength.
     */
    private int winLength;

    /**
     * Field's size.
     */
    private int size;

    /**
     * First player's score.
     */
    private int scorePlayer;

    /**
     * Second player's score.
     */
    private int scoreAI;

    /**
     * Draw's score.
     */
    private int scoreDraw;

    /**
     * First player input.
     */
    private Input inputPlayer1;

    /**
     * Second player input.
     */
    private Input inputPlayer2;
    /**
     * Output.
     */
    private Output output;

    /**
     * Constructs a new Game object.
     *
     * @param inputPlayer1 Input
     * @param inputPlayer2 Input
     * @param output       Output
     * @param winLength    int
     * @param size         int
     */
    public Game(Input inputPlayer1, Input inputPlayer2, Output output, int winLength, int size) {
        this.winLength = winLength;
        this.size = size;
        this.inputPlayer1 = inputPlayer1;
        this.inputPlayer2 = inputPlayer2;
        this.output = output;
        scorePlayer = 0;
        scoreAI = 0;
    }

    /**
     * Returns first player's score.
     *
     * @return int
     */
    public int getScorePlayer() {
        return scorePlayer;
    }

    /**
     * Returns second player's score.
     *
     * @return int
     */
    public int getScoreAI() {
        return scoreAI;
    }

    /**
     * Returns draw's score.
     *
     * @return int
     */
    public int getScoreDraw() {
        return scoreDraw;
    }

    /**
     * Even or odd.
     *
     * @param number int
     * @return boolean
     */
    private boolean isEven(int number) {
        return number % 2 == 0;
    }

    /**
     * Run.
     *
     * @param roundNumber int
     * @throws OccupiedCellException exception
     */
    public void runGame(int roundNumber) throws OccupiedCellException {
        int count = 0;
        int winner;
        while (count != roundNumber) {
            IRound round = new Round(inputPlayer1, inputPlayer2, output, winLength, size);
            boolean isAIFirstMove;
            isAIFirstMove = !isEven(count);
            winner = round.runRound(isAIFirstMove);
            if (winner == 1) {
                scorePlayer++;
            } else {
                if (winner == -1) {
                    scoreAI++;
                } else {
                    scoreDraw++;
                    count--;
                }
            }
            count++;
            showScore();
        }
    }

    /**
     * Print score.
     */
    private void showScore() {
        System.out.println("Player : AI : Draw");
        System.out.println("   " + scorePlayer + "     " + scoreAI + "     " + scoreDraw);
    }
}
