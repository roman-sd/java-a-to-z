package ru.sdroman.synchronizy.collection;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author sdroman
 * @since 07.2017
 * @param <E> E
 */
@ThreadSafe
public class ThreadSafeDynamicArray<E> implements Container<E> {

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
    @GuardedBy("this")
    private Object[] container;

    /**
     * Constructs a new this object.
     */
    public ThreadSafeDynamicArray() {
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
        synchronized (this) {
            if (size == container.length) {
                grow();
            }
            container[size++] = e;
            modCount++;
        }
    }

    /**
     * Returns element by index.
     *
     * @param index int
     * @return E
     */
    @Override
    @SuppressWarnings("unchecked")
    public synchronized E get(int index) {
        if (index < 0 || index > container.length) {
            throw new ArrayIndexOutOfBoundsException(String.format("%s%s%7s%s", "size=", size, "index=", index));
        }
        return (E) container[index];
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

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
    }
}
