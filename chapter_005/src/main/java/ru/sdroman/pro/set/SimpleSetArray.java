package ru.sdroman.pro.set;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class SimpleSetArray.
 *
 * @param <E>
 * @author sdroman
 * @since 05.17
 */
public class SimpleSetArray<E> implements SimpleSet<E> {

    /**
     * Default capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Array of elements.
     */
    private Object[] elements;

    /**
     * Size.
     */
    private int size;

    /**
     * Modification counter.
     */
    private int modCount = 0;

    /**
     * Constructs a new SimpleSet object.
     */
    public SimpleSetArray() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Grow.
     */
    private void grow() {
        final int newIndex = this.elements.length + this.elements.length * 3 / 2 + 1;
        this.elements = Arrays.copyOf(this.elements, newIndex);
    }

    /**
     * Returns true if the array already contains this element.
     *
     * @param e E
     * @return boolean
     */
    private boolean isContains(E e) {
        for (int i = 0; i < this.size; i++) {
            if (e.equals(this.elements[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds elements.
     *
     * @param e E
     */
    @Override
    public void add(E e) {
        if (this.size == this.elements.length) {
            grow();
        }
        if (!isContains(e)) {
            this.elements[size++] = e;
            modCount++;
        }
    }

    /**
     * Returns an iterator over elements of type {@code E}.
     *
     * @return Iterator.
     */
    public Iterator iterator() {
        return new IteratorImpl<E>();
    }

    /**
     * Class IteratorImpl.
     *
     * @param <T> T
     */
    private class IteratorImpl<T> implements Iterator<T> {

        /**
         * Index.
         */
        int cursor;

        /**
         * Iterator's modCount.
         */
        int expectedModCount = modCount;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return this.cursor != size;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException          if the iteration has no more elements
         * @throws ConcurrentModificationException if set was modified.
         */
        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (T) elements[cursor++];
        }
    }
}
