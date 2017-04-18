package ru.sdroman.pro.iterator;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThat;

/**
 * Class TwoDimensionalArrayIterator.
 *
 * @author sdroman
 * @since 04.17
 */
public class TwoDimensionalArrayIteratorTest {

    /**
     * Test next method.
     */
    @Test
    public void whenGetNextCallThenPointerForward() {
        final int expected = 3;
        final int[][] values = new int[][]{{1, 2}, {3, 4}};
        TwoDimensionalArrayIterator arrayIterator = new TwoDimensionalArrayIterator(values);
        Iterator it = arrayIterator.iterator();
        it.next();
        it.next();
        int actual = (int) it.next();
        assertThat(actual, is(expected));
    }

    /**
     * Test next method.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenGetNextCallThenNoSuchElementException() {
        final int[][] values = new int[][]{{1}, {3}};
        TwoDimensionalArrayIterator arrayIterator = new TwoDimensionalArrayIterator(values);
        Iterator it = arrayIterator.iterator();
        it.next();
        it.next();
        it.next();
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenCheckNextPositionThenReturnTrue() {
        final int[][] values = new int[][]{{1, 2}, {3, 4}};
        TwoDimensionalArrayIterator arrayIterator = new TwoDimensionalArrayIterator(values);
        Iterator it = arrayIterator.iterator();
        it.next();
        assertTrue(it.hasNext());
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenCheckNextPositionThenReturnFalse() {
        final int[][] values = new int[][]{{1}};
        TwoDimensionalArrayIterator arrayIterator = new TwoDimensionalArrayIterator(values);
        Iterator it = arrayIterator.iterator();
        it.next();
        assertFalse(it.hasNext());
    }
}