package ru.sdroman.start;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * class ValidateInputTest.
 */
public class ValidateInputTest {

    /**
     * test ask() in ValidateInput class.
     */
    @Test
    public void whenSelectTwoThenReturnTwoInAsk() {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);
        final int[] range = new int[]{1, 2, 3};
        int actual = new ValidateInput().ask("testQuestion", range);
        int expected = 2;
        assertThat(actual, is(expected));
    }
}
