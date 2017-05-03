package ru.sdroman.pro.set;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

/**
 * Test SimpleSet class.
 * @author sdroman
 * @since 05.17
 */
public class SimpleSetArrayTest {

    /**
     * SimpleSet instance.
     */
    private SimpleSetArray<Integer> set;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        set = new SimpleSetArray<>();
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddCallThenAddsUniqueElements() {
        set.add(0);
        set.add(0);
        set.add(1);
        Iterator it = set.iterator();

        assertThat(it.next(), is(0));
        assertThat(it.next(), is(1));
    }

    /**
     * Test hasNext method in iterator.
     */
    @Test
    public void whenHasNextCallThenReturnTrue() {
        set.add(0);
        set.add(1);
        Iterator it = set.iterator();
        assertTrue(it.hasNext());
    }

    /**
     * Test hasNext method in iterator.
     */
    @Test
    public void whenHasNextCallThenReturnFalse() {
        set.add(0);
        Iterator it = set.iterator();
        it.next();
        assertFalse(it.hasNext());
    }

    /**
     * Test next method.
     */
    @Test
    public void whenNextCallThenReturnNextElement() {
        set.add(0);
        set.add(1);
        Iterator it = set.iterator();
        assertThat(it.next(), is(0));
    }

    /**
     * Test next method.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorCallAndModifyContainerThenReturnException() {
        final int nextElement = 7;
        set.add(0);
        set.add(1);
        Iterator it = set.iterator();
        set.add(nextElement);
        it.next();
    }

    /**
     * Test next method.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextCallThenThrowsNoSuchElementException() {
        set.add(0);
        Iterator it = set.iterator();
        it.next();
        it.next();
    }
}