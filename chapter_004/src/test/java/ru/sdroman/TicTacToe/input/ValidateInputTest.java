package ru.sdroman.TicTacToe.input;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test ValidateInput class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class ValidateInputTest {

    /**
     * ValidateInput instance.
     */
    private ValidateInput validate;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        String testString = "0 2";
        this.validate = new ValidateInput(testString);
    }

    /**
     * Test a coordinate x.
     */
    @Test
    public void whenSetStringThenReturnCoordinateX() {
        final int expected = 0;
        assertThat(this.validate.getX(), is(expected));
    }

    /**
     * Test a coordinate y.
     */
    @Test
    public void whenSetStringThenReturnCoordinateY() {
        final int expected = 2;
        assertThat(this.validate.getY(), is(expected));
    }
}
