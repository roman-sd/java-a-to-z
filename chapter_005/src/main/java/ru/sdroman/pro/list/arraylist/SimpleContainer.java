package ru.sdroman.pro.list.arraylist;

/**
 * Interface SimpleContainer.
 *
 * @param <E>
 */
public interface SimpleContainer<E> extends Iterable<E> {

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
