package ru.sdroman.pro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Test EvenIterator class.
 * @author sdroman
 * @since 04.17
 */
public class EvenIterator implements Iterable {

    /**
     * Array of values.
     */
    private int max;

    /**
     * Constructs a new EvenIterator object.
     * @param max int
     */
    public EvenIterator(int max) {
        this.max = max;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {

        Iterator it = new Iterator() {

            static final int TWO = 2;
            int current = 0;

            /**
             * Returns {@code true} if the iteration has more even elements.
             * @return {@code true} if the iteration has more even elements
             */
            @Override
            public boolean hasNext() {
                return TWO * current <= max;
            }

            /**
             * Returns the next even element in the iteration.
             * @return the next even element in the iteration
             */
            @Override
            public Object next() {
                if (hasNext()) {
                    return TWO * current++;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
        return it;
    }
}
