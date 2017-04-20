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
 * Test EvenIterator class.
 * @author sdroman
 * @since 04.17
 */
public class EvenIteratorTest {

    /**
     * Test next method.
     */
    @Test
    public void whenNextCallThenIterateEvenNumbers() {
        final int n = 5;
        final List<Integer> expected = Arrays.asList(0, 2, 4);
        final List<Integer> actual = new ArrayList<>();
        Iterator eIt = new EvenIterator(n).iterator();

        while (eIt.hasNext()) {
            actual.add((Integer) eIt.next());
        }

        assertThat(actual, is(expected));
    }

    /**
     * Test next method.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextCallThenThrowsNoSuchElementException() {
        final int n = 2;
        Iterator eIt = new EvenIterator(n).iterator();
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
        Iterator eIt = new EvenIterator(n).iterator();
        assertTrue(eIt.hasNext());
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenHasNextCallThenReturnFalse() {
        final int n = 2;
        Iterator eIt = new EvenIterator(n).iterator();
        eIt.next();
        eIt.next();
        assertFalse(eIt.hasNext());
    }
}