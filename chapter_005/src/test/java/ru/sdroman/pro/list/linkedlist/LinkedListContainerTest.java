package ru.sdroman.pro.list.linkedlist;

import org.junit.Before;
import org.junit.Test;
import ru.sdroman.pro.list.arraylist.SimpleContainer;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test LinkedListContainer class.
 */
public class LinkedListContainerTest {

    /**
     * Container.
     */
    private SimpleContainer<Integer> container;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        container = new LinkedListContainer<>();
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddCallThenAddsNewElementToContainer() {
        container.add(0);
        assertThat(container.get(0), is(0));
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddCallThenAddLast() {
        final int element = 5;
        container.add(0);
        container.add(element);
        assertThat(container.get(1), is(element));
    }

    /**
     * Test get method.
     */
    @Test
    public void whenGetCallThenSearchesIndexFromBeginOfList()  {
        final int element = 5;
        container.add(0);
        container.add(element);
        int actual = container.get(1);
        assertThat(actual, is(element));
    }

    /**
     * Test get method.
     */
    @Test
    public void whenGetCallThenSearchesIndexFromEndOfList() {
        final int len = 5;
        for (int i = 0; i < len; i++) {
            container.add(i);
        }
        final int index = 3;
        final int expected = 3;
        assertThat(container.get(index), is(expected));
    }

    /**
     * Test get method.
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetCallByIncorrectIndexThenThrowsException() {
        container.add(0);
        container.get(-1);
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenHasNextCallThenReturnTrue() {
        final int element = 7;
        container.add(0);
        container.add(element);
        Iterator<Integer> it = container.iterator();
        assertTrue(it.hasNext());
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenHasNextCallThenReturnFalse() {
        final int element = 7;
        container.add(0);
        container.add(element);
        Iterator<Integer> it = container.iterator();
        it.next();
        it.next();
        assertFalse(it.hasNext());
    }

    /**
     * Test next method.
     */
    @Test
    public void whenNextCallThenReturnNextElement() {
        final int element = 5;
        container.add(0);
        container.add(element);
        Iterator<Integer> it = container.iterator();
        assertThat(it.next(), is(0));
    }

    /**
     * Test next method.
     */
    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorCallAndModifyContainerThenReturnException() {
        final int element = 7;
        final int nextElement = 9;
        container.add(0);
        container.add(element);
        Iterator<Integer> it = container.iterator();
        container.add(nextElement);
        it.next();
    }

    /**
     * Test next method.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenIteratorCallAndHasNextFalseThenReturnException() {
        Iterator<Integer> it = container.iterator();
        it.next();
    }

}