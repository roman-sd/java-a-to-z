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
        final int[] array = new int[]{5, 4, 6, 8, 9, 1, 7};
        final List<Integer> expected = Arrays.asList(4, 6, 8);
        final List<Integer> actual = new ArrayList<>();

        final Iterator eIt = new EvenIterator(array).iterator();

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
        final int[] elements = new int[]{1, 4, 3};
        final Iterator eIt = new EvenIterator(elements).iterator();
        eIt.next();
        eIt.next();
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenHasNextCallThenReturnTrue() {
        final int[] elements = new int[]{2, 5, 8};
        Iterator eIt = new EvenIterator(elements).iterator();
        eIt.next();
        assertTrue(eIt.hasNext());
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenHasNextCallThenReturnFalse() {
        final int[] elements = new int[]{1, 2, 5, 7};
        Iterator eIt = new EvenIterator(elements).iterator();
        eIt.next();
        assertFalse(eIt.hasNext());
    }
}