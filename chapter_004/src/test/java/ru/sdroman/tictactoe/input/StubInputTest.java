package ru.sdroman.tictactoe.input;

import org.junit.Test;
import ru.sdroman.tictactoe.Interfaces.Input;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test StubInput class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class StubInputTest {

    /**
     * Test read() method.
     */
    @Test
    public void read() {
        String firstItem = "0 0";
        String secondItem = "0 1";
        String[] testArray = {firstItem, secondItem};
        Input input = new StubInput(testArray);
        String actual = input.read("testString");
        assertThat(actual, is(firstItem));
        actual = input.read("testString");
        assertThat(actual, is(secondItem));
    }
}