package ru.sdroman.pro.iterator;

import org.junit.Before;
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
 * Test IteratorOfIterators class.
 *
 * @author sdroman
 * @since 04.17
 */
public class IteratorOfIteratorsTest {

    /**
     * List1.
     */
    private final List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3));;

    /**
     * List2.
     */
    private final List<Integer> list2 = new ArrayList<>(Arrays.asList(4, 5, 6, 7));

    /**
     * List3.
     */
    private final List<Integer> list3 = new ArrayList<>(Arrays.asList(8, 9));

    /**
     * Iterator of iterators.
     */
    private List<Iterator<Integer>> iterators;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        iterators = new ArrayList<>(Arrays.asList(list1.iterator(), list2.iterator(), list3.iterator()));
    }

    /**
     * Test convert method.
     */
    @Test
    public void whenCallConvertThenReturnIterator() {
        final List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> actual = new ArrayList<>();

        Iterator<Integer> it = new IteratorOfIterators().convert(iterators.iterator());
        while (it.hasNext()) {
            actual.add(it.next());
        }

        assertThat(actual, is(expected));
    }

    /**
     * Test next method.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextCallThenThrowsNoSuchElementException() {
        Iterator<Integer> it = new IteratorOfIterators()
                .convert(Arrays.asList(list1.iterator(), list2.iterator(), list3.iterator()).iterator());

        while (it.hasNext()) {
            it.next();
        }
        it.next();
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenHasNextCallThenReturnsTrue() {
        Iterator<Integer> it = new IteratorOfIterators()
                .convert(Arrays.asList(list1.iterator(), list2.iterator(), list3.iterator()).iterator());

        assertTrue(it.hasNext());
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenHasNextCallThenReturnsFalse() {
        Iterator<Integer> it = new IteratorOfIterators()
                .convert(Arrays.asList(list1.iterator(), list2.iterator(), list3.iterator()).iterator());

        while (it.hasNext()) {
            it.next();
        }

        assertFalse(it.hasNext());
    }
}
