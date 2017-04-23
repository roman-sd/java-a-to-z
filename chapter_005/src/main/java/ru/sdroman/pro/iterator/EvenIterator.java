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
    private int[] elements;

    /**
     * Constructs a new EvenIterator object.
     * @param elements int[]
     */
    public EvenIterator(int[] elements) {
        this.elements = elements;


    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {

        Iterator it = new Iterator() {


            int index = -1;

            /**
             * Returns {@code true} if the iteration has more even elements.
             * @return {@code true} if the iteration has more even elements
             */
            @Override
            public boolean hasNext() {
                if (index == -1) {
                    nextIndex();
                }
                return index < elements.length;
            }

            /**
             * Returns the next even element in the iteration.
             * @return the next even element in the iteration
             */
            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int prev = elements[index];
                nextIndex();
                return prev;
            }

            /**
             * Increases index to the next even element.
             */
            private void nextIndex() {
                index++;
                while (index < elements.length && elements[index] % 2 == 1) {
                    index++;
                }
            }
        };
        return it;
    }
}
