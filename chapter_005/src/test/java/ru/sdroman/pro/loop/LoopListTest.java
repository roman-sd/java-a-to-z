package ru.sdroman.pro.loop;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test LoopList class.
 */
public class LoopListTest {

    /**
     * Test hasCycle method.
     */
    @Test
    public void hasCycleTest() {
        LoopList list = new LoopList();
        LoopList.Node<Integer> first = new LoopList.Node<>(1);
        LoopList.Node<Integer> two = new LoopList.Node<>(2);
        LoopList.Node<Integer> third = new LoopList.Node<>(3);
        LoopList.Node<Integer> four = new LoopList.Node<>(4);

        first.setNext(two);
        first.setNext(third);
        first.setNext(four);
        first.setNext(first);

        assertTrue(list.hasCycle(first));
    }

}