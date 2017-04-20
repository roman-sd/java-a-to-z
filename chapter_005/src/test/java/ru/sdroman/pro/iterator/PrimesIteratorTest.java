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
        final int n = 10;
        final List<Integer> expected = Arrays.asList(0, 1, 2, 3, 5, 7);
        final List<Integer> actual = new ArrayList<>();
        Iterator pIt = new PrimesIterator(n).iterator();

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
        final int n = 2;
        Iterator eIt = new PrimesIterator(n).iterator();
        eIt.next();
        eIt.next();
        eIt.next();
        eIt.next();
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenHasNextCallThenReturnTrue() {
        final int n = 2;
        Iterator eIt = new PrimesIterator(n).iterator();
        assertTrue(eIt.hasNext());
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenHasNextCallThenReturnFalse() {
        final int n = 2;
        Iterator eIt = new PrimesIterator(n).iterator();
        eIt.next();
        eIt.next();
        eIt.next();
        assertFalse(eIt.hasNext());
    }

}