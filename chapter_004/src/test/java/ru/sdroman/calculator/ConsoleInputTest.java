package ru.sdroman.calculator;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test ConsoleInput class.
 *
 * @author sdroman
 * @since 02.17
 * @version 0.1
 */
public class ConsoleInputTest {

    /**
     * Test ask() method.
     */
    @Test
    public void whenSetTwoThenReturnTwoInAsk() {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        String actual = new ConsoleInput().ask("testQuestion");
        assertThat(actual, is("2"));
    }
}
