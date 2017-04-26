package ru.sdroman.pro.list.queue;

/**
 * Interface Queue.
 *
 * @param <E>
 * @author sdroman
 * @since 04.17
 */
public interface Queue<E> {

    /**
     * Adds element to the list.
     * @param e E
     */
    void offer(E e);

    /**
     * Return last element.
     * @return E
     */
    E poll();
}
