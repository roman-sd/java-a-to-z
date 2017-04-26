package ru.sdroman.pro.list.stack;

/**
 * Interface Stack.
 *
 * @param <E>
 * @author sdroman
 * @since 04.17
 */
public interface Stack<E> {

    /**
     * Adds element.
     * @param e E
     */
    void push(E e);

    /**
     * Returns element.
     * @return E
     */
    E pop();
}
