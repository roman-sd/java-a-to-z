package ru.sdroman.pro.list.queue;

import ru.sdroman.pro.list.linkedlist.LinkedListContainer;

/**
 * Class LinkedListQueue.
 * @param <E>
 * @author sdroman
 * @since 04.17
 */
public class LinkedListQueue<E> extends LinkedListContainer<E> implements Queue<E> {
    /**
     * Adds element to the list.
     *
     * @param e E
     */
    @Override
    public void offer(E e) {
        super.add(e);
    }

    /**
     * Return first element.
     *
     * @return E
     */
    @Override
    public E poll() {
        return removeFirst();
    }
}
