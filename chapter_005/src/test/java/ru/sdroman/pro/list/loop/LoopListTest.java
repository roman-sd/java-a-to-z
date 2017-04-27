package ru.sdroman.pro.list.loop;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test LoopList class.
 * @author sdroman
 * @since 04.17
 */
public class LoopListTest {

    /**
     * Test hasCycle method.
     */
    @Test
    public void hasCycleTest() {
        LoopList list = new LoopList();
        final LoopList.Node<Integer> first = new LoopList.Node<>(1);
        final LoopList.Node<Integer> two = new LoopList.Node<>(2);
        final LoopList.Node<Integer> third = new LoopList.Node<>(3);
        final LoopList.Node<Integer> four = new LoopList.Node<>(4);

        first.setNext(two);
        first.setNext(third);
        first.setNext(four);
        first.setNext(first);

        assertTrue(list.hasCycle(first));
    }

}