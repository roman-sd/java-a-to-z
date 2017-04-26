package ru.sdroman.pro.list.stack;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test LinkedListStack class.
 * @author sdroman
 * @since 04.17
 */
public class LinkedListStackTest {

    /**
     * Stack.
     */
    private Stack<Integer> stack = new LinkedListStack<>();

    /**
     * Test push & pop methods.
     */
    @Test
    public void whenPushCallThenAddsToTheTop()  {
        stack.push(0);
        stack.push(1);
        final int actual = stack.pop();
        assertThat(actual, is(1));
    }
}
