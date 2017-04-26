package ru.sdroman.pro.list.arraylist;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * Class ArrayContainer.
 *
 * @param <E>
 * @author sdroman
 * @since 04.17
 */
public class ArrayContainer<E> implements SimpleContainer<E> {

    /**
     * Default capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * array's size.
     */
    private int size;

    /**
     * Modification counter.
     */
    private int modCount = 0;

    /**
     * Object's array.
     */
    private Object[] container;

    /**
     * Constructs a new ArrayContainer object.
     */
    public ArrayContainer() {
        this.container = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Grow.
     */
    private void grow() {
        final int newIndex = container.length + container.length * 3 / 2 + 1;
        container = Arrays.copyOf(container, newIndex);
    }

    /**
     * Adds element.
     *
     * @param e E
     */
    @Override
    public void add(E e) {
        if (size == container.length) {
            grow();
        }
        container[size++] = e;
        modCount++;
    }

    /**
     * Returns element by index.
     *
     * @param index int
     * @return E
     */
    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("size: " + size + ", index: " + index);
        }
        return (E) container[index];
    }

    /**
     * Returns size.
     *
     * @return int
     */
    @Override
    public int getSize() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {

            int cursor;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return cursor != size;
            }

            @Override
            @SuppressWarnings("unchecked")
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (E) container[cursor++];
            }
        };
        return iterator;
    }
}
