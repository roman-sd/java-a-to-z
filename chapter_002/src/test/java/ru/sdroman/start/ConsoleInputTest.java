package ru.sdroman.start;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class ConsoleInputTest.
 */
public class ConsoleInputTest {

    /**
     * test ask() in ConsoleInput class.
     */
    @Test
    public void whenSelectTwoThenReturnTwoInAsk() {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        final int[] range = new int[]{1, 2, 3, 4, 5};
        int actual = new ConsoleInput().ask("testQuestion", range);
        int expected = 2;
        assertThat(actual, is(expected));
    }

    /**
     * test ask() with MenuOutException.
     */
    @Test(expected = MenuOutException.class)
    public void whenSelectSevenThenThrowException() {
        ByteArrayInputStream in = new ByteArrayInputStream("7".getBytes());
        System.setIn(in);
        final int[] range = new int[]{1, 2, 3, 4, 5};
        new ConsoleInput().ask("testQuestion", range);
    }
}
