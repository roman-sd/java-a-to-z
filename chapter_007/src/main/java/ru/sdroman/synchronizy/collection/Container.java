package ru.sdroman.synchronizy.collection;

/**
 * @author sdroman
 * @since 07.2017
 *
 * @param <E>
 */
public interface Container<E> extends Iterable<E> {

    /**
     * Adds element.
     *
     * @param e E
     */
    void add(E e);

    /**
     * Returns element by index.
     *
     * @param index int
     * @return E
     */
    E get(int index);
}
