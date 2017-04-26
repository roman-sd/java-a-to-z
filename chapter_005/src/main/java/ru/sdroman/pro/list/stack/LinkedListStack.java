package ru.sdroman.pro.list.stack;

import ru.sdroman.pro.list.linkedlist.LinkedListContainer;

/**
 * Class LinkedListStack.
 * @param <E>
 * @author sdroman
 * @since 04.17
 */
public class LinkedListStack<E> extends LinkedListContainer<E> implements Stack<E> {

    /**
     * Adds an element to the top of the list.
     *
     * @param e E
     */
    @Override
    public void push(E e) {
        super.addFirst(e);
    }

    /**
     * Returns element.
     *
     * @return E
     */
    @Override
    public E pop() {
        return super.removeFirst();
    }
}
