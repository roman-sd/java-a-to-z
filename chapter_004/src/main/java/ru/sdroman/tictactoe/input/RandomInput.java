package ru.sdroman.tictactoe.input;

import ru.sdroman.tictactoe.interfaces.Input;

import java.util.Random;

/**
 * Class RandomInput.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class RandomInput implements Input {

    /**
     * Random object.
     */
    private Random random = new Random();

    /**
     * Read.
     *
     * @param question String question
     * @return String
     */
    @Override
    public String read(String question) {
        final int limit = 3;
        StringBuilder builder = new StringBuilder();
        int x = random.nextInt(limit);
        int y = random.nextInt(limit);
        return builder.append(x).append(" ").append(y).toString();
    }
}
