package ru.sdroman.TicTacToe.input;

import ru.sdroman.TicTacToe.Interfaces.Input;

/**
 * Class StubInput.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class StubInput implements Input {

    /**
     * Array of answers.
     */
    private String[] answers;

    /**
     * Position in array.
     */
    private int position;

    /**
     * Constructs the new StubInput objects.
     *
     * @param answers String[]
     */
    public StubInput(String[] answers) {
        this.answers = answers;
        this.position = 0;
    }

    /**
     * read.
     *
     * @param ask String
     * @return String
     */
    @Override
    public String read(String ask) {
        System.out.println(answers[position]);
        return this.answers[this.position++];
    }
}
