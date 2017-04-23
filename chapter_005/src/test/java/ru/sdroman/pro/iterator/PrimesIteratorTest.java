package ru.sdroman.pro.iterator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test PrimesIterator class.
 * @author sdroman
 * @since 04.17
 */
public class PrimesIteratorTest {

    /**
     * Test next method.
     */
    @Test
    public void whenNextCallThenIteratePrimeNumber() {
        final List<Integer> expected = Arrays.asList(3, 7);
        final List<Integer> actual = new ArrayList<>();
        final int[] elements = new int[]{3, 4, 7, 8};
        final Iterator pIt = new PrimesIterator(elements).iterator();

        while (pIt.hasNext()) {
            actual.add((Integer) pIt.next());
        }

        assertThat(actual, is(expected));
    }

    /**
     * Test next method.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextCallThenThrowsNoSuchElementException() {
        final int[] elements = new int[]{4, 7, 8};
        final Iterator eIt = new PrimesIterator(elements).iterator();
        eIt.next();
        eIt.next();
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenHasNextCallThenReturnTrue() {
        final int[] elements = new int[]{3, 4, 7, 8};
        final Iterator eIt = new PrimesIterator(elements).iterator();
        eIt.next();
        assertTrue(eIt.hasNext());
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenHasNextCallThenReturnFalse() {
        final int[] elements = new int[]{6, 3, 8};
        Iterator eIt = new PrimesIterator(elements).iterator();
        eIt.next();
        assertFalse(eIt.hasNext());
    }
}
