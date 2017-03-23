package ru.sdroman.TicTacToe.input;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test ConsoleInput class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class ConsoleInputTest {

    /**
     * Test read() method.
     */
    @Test
    public void whenSetCoordinatesThenReturnString() {
        String testStr = "0 2";
        ByteArrayInputStream in = new ByteArrayInputStream(testStr.getBytes());
        System.setIn(in);
        String actual = new ConsoleInput().read("testQuestion");
        assertThat(actual, is(testStr));
    }
}