package ru.sdroman.tictactoe.input;

import org.junit.Before;
import org.junit.Test;
import ru.sdroman.tictactoe.Interfaces.Input;

import static org.junit.Assert.assertTrue;

/**
 * Test RandomInputClass.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class RandomInputTest {

    /**
     * Min.
     */
    private static final int MIN = 0;

    /**
     * Max.
     */
    private static final int MAX = 2;

    /**
     * validate.
     */
    private ValidateInput validate;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        Input input = new RandomInput();
        String actualStr = input.read("testQuestion");
        validate = new ValidateInput(actualStr);
    }

    /**
     * Test read() method; X.
     */
    @Test
    public void whenRandomInputThenRandomXCoordinate() {
        int actualX = validate.getX();
        assertTrue(MIN <= actualX && actualX <= MAX);
    }

    /**
     * Test read() method; Y.
     */
    @Test
    public void whenRandomInputThenRandomYCoordinate() {
        int actualY = validate.getY();
        assertTrue(MIN <= actualY && actualY <= MAX);
    }
}