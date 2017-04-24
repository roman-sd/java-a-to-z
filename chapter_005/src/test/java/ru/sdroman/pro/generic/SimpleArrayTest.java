package ru.sdroman.pro.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test SimpleArray class.
 * @author sdroman
 * @since 04.17
 */
public class SimpleArrayTest {

    /**
     * SimpleArray instance.
     */
    private SimpleArray<Integer> array;

    /**
     * SetUp.
     */
    @Before
    public void setUp() {
        array = new SimpleArray<>();
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddCallThenAddsElement() {
        final int value = 5;
        array.add(value);
        assertThat(array.get(0), is(value));
    }

    /**
     * Test grow method in add.
     */
    @Test
    public void whenAddCallThenArrayGrows() {
        final int size = 5;
        final int value = 6;
        final int newSize = size * 3 / 2 + 1;
        for (int i = 0; i < size; i++) {
            array.add(i);
        }
        array.add(value);
        assertThat(array.getElements().length, is(newSize));
    }

    /**
     * Test remove method.
     */
    @Test
    public void whenRemoveCallThenRemovesElement() {
        final int size = 5;
        final Integer[] expected = new Integer[]{1, 2, 3, 4, null};
        for (int i = 0; i < size; i++) {
            array.add(i);
        }
        array.remove(0);
        assertThat(array.getElements(), is(expected));
    }

    /**
     * Test get method.
     */
    @Test
    public void whenGetCallThenReturnsElement() {
        final int size = 5;
        final int index = 3;
        final Integer expected = 3;
        for (int i = 0; i < size; i++) {
            array.add(i);
        }
        assertThat(array.get(index), is(expected));
    }

    /**
     * Test exception.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenGetCallThenThrowsException() {
        final int size = 5;
        final int index = 5;
        for (int i = 0; i < size; i++) {
            array.add(i);
        }
        array.get(index);
    }

    /**
     * Test update.
     */
    @Test
    public void whenUpdateCallThenSetElementToNewValue() {
        final int size = 5;
        final Integer newValue = 10;
        for (int i = 0; i < size; i++) {
            array.add(i);
        }
        array.update(0, newValue);
        assertThat(array.get(0), is(newValue));
    }
}
