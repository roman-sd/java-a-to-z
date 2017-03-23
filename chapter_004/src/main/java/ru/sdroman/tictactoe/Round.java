package ru.sdroman.tictactoe;

import ru.sdroman.tictactoe.Interfaces.IRound;
import ru.sdroman.tictactoe.Interfaces.Input;
import ru.sdroman.tictactoe.Interfaces.Output;
import ru.sdroman.tictactoe.exceptions.OccupiedCellException;
import ru.sdroman.tictactoe.input.ValidateInput;

/**
 * Class Round.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class Round implements IRound {

    /**
     * Winner.
     */
    private int winner = 0;

    /**
     * x.
     */
    private int x;

    /**
     * y.
     */
    private int y;

    /**
     * Field.
     */
    private Field field;

    /**
     * First player input.
     */
    private Input inputPlayerX;

    /**
     * Second player input.
     */
    private Input inputPlayerO;

    /**
     * Output.
     */
    private Output output;

    /**
     * Constructs a new Round object.
     *
     * @param input1    Input
     * @param input2    Input
     * @param output    Output
     * @param winLength int
     * @param size      int
     */
    Round(Input input1, Input input2, Output output, int winLength, int size) {
        this.field = new Field(winLength, size);
        this.inputPlayerX = input1;
        this.inputPlayerO = input2;
        this.output = output;
    }

    /**
     * Even or odd.
     *
     * @param count int
     * @return boolean
     */
    private boolean isEven(int count) {
        return count % 2 == 0;
    }

    /**
     * ValidateInput.
     *
     * @param question String
     */
    private void validateInput(String question) {
        ValidateInput in = new ValidateInput(question);
        this.x = in.getX();
        this.y = in.getY();
    }

    /**
     * Move.
     *
     * @param input    Input
     * @param question String
     * @param player   int
     * @throws OccupiedCellException exception
     */
    private void playerMove(Input input, String question, int player) throws OccupiedCellException {
        validateInput(input.read(question));
        field.move(this.x, this.y, player);
    }

    /**
     * Run.
     *
     * @param isAIFirstMove boolean
     * @return int
     * @throws OccupiedCellException exception
     */
    @Override
    public int runRound(boolean isAIFirstMove) throws OccupiedCellException {
        this.output.printField(this.field.getField());
        int win = -1;
        boolean done = false;
        int count = isAIFirstMove ? 1 : 0;
        do {
            try {
                if (isEven(count)) {
                    playerMove(inputPlayerX, "Player1 : ", 1);
                    win = 1;
                    System.out.println("Player 1");
                } else {
                    playerMove(inputPlayerO, "Player2 : ", -1);
                    win = -1;
                    System.out.println("Player 2");
                }
                count++;
            } catch (OccupiedCellException oce) {
                System.out.println("This cell is not empty.");
            }

            if (field.hasWinner()) {
                this.winner = win;
                done = true;
                System.out.println("win " + this.winner);
            }
            if (!done && count == field.getSize() * field.getSize()) {
                this.winner = 0;
                done = true;
                System.out.println("draw");
            }
            this.output.printField(this.field.getField());
        } while (!done);
        return this.winner;
    }
}
