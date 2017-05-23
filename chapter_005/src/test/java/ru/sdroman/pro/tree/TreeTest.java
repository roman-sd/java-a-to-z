package ru.sdroman.pro.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Test Tree class.
 * @author sdroman
 * @since 05.2017
 */
public class TreeTest {

    /**
     * Tree.
     */
    private Tree<Integer> tree;

    /**
     * Setup.
     */
    @Before
    public void setUp() {
        tree = new Tree<>();
        tree.add(0, 0);
        tree.add(0, 1);
        tree.add(0, 2);
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddCallThenReturnTrue() {
        assertTrue(tree.add(2, 3));
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddCallThenReturnFalse() {
        assertFalse(tree.add(5, 7));
    }

    /**
     * Test add method.
     */
    @Test
    public void whenAddCallThenAddsElementToTree() {
        tree.add(2, 7);
        Iterator it = tree.iterator();
        it.next();
        it.next();
        it.next();
        assertThat(it.next(), is(7));
    }

    /**
     * Test iterator.
     */
    @Test
    public void whenIteratorCallThenIterateTree() {
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(2, 5);
        tree.add(2, 6);

        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(0);
        expectedList.add(1);
        expectedList.add(3);
        expectedList.add(4);
        expectedList.add(2);
        expectedList.add(5);
        expectedList.add(6);

        Iterator<Integer> it = tree.iterator();
        List<Integer> actualList = new ArrayList<>();
        while(it.hasNext()) {
            actualList.add(it.next());
        }

        assertThat(actualList, is(expectedList));
    }

    /**
     * Test isBinary method.
     */
    @Test
    public void testIsBinary() {
        tree.add(1, 3);
        tree.add(1, 4);

        assertTrue(tree.isBinary());
    }

    /**
     * Test isBinary method.
     */
    @Test
    public void whenIsBinaryCallThenReturnFalse() {
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(1, 5);

        assertFalse(tree.isBinary());
    }
}
