package ru.sdroman.pro.list;

import org.junit.Before;
import org.junit.Test;
import ru.sdroman.pro.list.arraylist.ArrayContainer;
import ru.sdroman.pro.list.arraylist.SimpleContainer;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test ArrayContainer class.
 *
 * @author sdroman
 * @since 04.17
 */
public class ArrayContainerTest {

    /**
     * SimpleContainer instance.
     */
    private SimpleContainer<Integer> container;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        container = new ArrayContainer<>();
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddCallThenAddsElement() {
        container.add(0);
        assertThat(container.get(0), is(0));
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddCallThenGrowsContainer() {
        final int expected = 11;
        final int element = 15;
        final int len = 10;
        for (int i = 0; i < len; i++) {
            container.add(i);
        }
        container.add(element);
        assertThat(container.getSize(), is(expected));
    }

    /**
     * Test get method.
     */
    @Test
    public void whenGetCallThenReturnElementByIndex() {
        container.add(0);
        container.add(1);
        assertThat(container.get(1), is(1));
    }

    /**
     * Test get method.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenGetCallByIncorrectIndexThenThrowsException() {
        container.add(0);
        container.get(-1);
    }

    /**
     * Test hasNext method in iterator.
     */
    @Test
    public void whenHasNextCallThenReturnTrue() {
        final int element = 5;
        container.add(0);
        container.add(element);
        Iterator<Integer> it = container.iterator();
        assertTrue(it.hasNext());
    }

    /**
     * Test hasNext method in iterator.
     */
    @Test
    public void whenHasNextCallThenReturnFalse() {
        final int element = 5;
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
        final int element = 7;
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
        final int element = 5;
        final int nextElement = 7;
        container.add(0);
        container.add(element);
        Iterator<Integer> it = container.iterator();
        container.add(nextElement);
        it.next();
    }
}
