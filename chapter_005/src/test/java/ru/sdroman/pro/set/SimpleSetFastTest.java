package ru.sdroman.pro.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test SimpleSetFast class.
 * @author sdroman
 * @since 05.17
 */
public class SimpleSetFastTest {

    /**
     * Separator.
     */
    private static final String LS = System.getProperty("line.separator");

    /**
     * SimpleSetFast instance.
     */
    private SimpleSetFast<String> set;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        set = new SimpleSetFast<>();
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddCallThenAddsElementsToSet() {
        String expected = "One " + LS + "Zero " + LS + "Two " + LS;
        set.add("Zero");
        set.add("One");
        set.add("Two");
        set.add("One");
        assertThat(set.toString(), is(expected));
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddCallThenAddsElement() {
        String expected = "11 " + "0 " + LS + "1 " + LS + "2 " + LS + "3 " + LS + "4 " + LS + "5 " + LS
                + "6 " + LS + "7 " + LS + "8 " + LS + "9 " + LS + "10 " + LS;
        final int num = 12;
        for (int i = 0; i < num; i++) {
            set.add(String.valueOf(i));
        }
        assertThat(set.toString(), is(expected));
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenHasNextCallThenReturnTrue() {
        set.add("zero");
        set.add("one");
        Iterator it = set.iterator();
        it.next();
        assertTrue(it.hasNext());
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenHasNextCallThenReturnFalse() {
        set.add("zero");
        Iterator it = set.iterator();
        it.next();
        assertFalse(it.hasNext());
    }

    /**
     * Test next method.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextCallThenThrowsNoSuchElementException() {
        Iterator it = set.iterator();
        set.add("zero");
        it.next();
        it.next();
    }

    /**
     * Test next method.
     */
    @Test
    public void whenNextCallThenReturnNextElement() {
        set.add("zero");
        Iterator it = set.iterator();
        assertThat(it.next(), is("zero"));
    }

    /**
     * Test next method.
     */
    @Test
    public void whenNextCallThenReturnNextElementInOneBasket() {
        final int num = 12;
        final int arrayLen = 10;
        for (int i = 0; i < num; i++) {
            set.add(String.valueOf(i));
        }
        Iterator it = set.iterator();
        int count = 0;
        while (it.hasNext() && count++ < arrayLen) {
            it.next();
        }
        final String actual = it.next() + " " + it.next();
        assertThat(actual, is("11 0"));
    }
}
