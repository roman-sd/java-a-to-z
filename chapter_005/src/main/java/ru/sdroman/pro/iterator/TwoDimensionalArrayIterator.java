package ru.sdroman.pro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class TwoDimensionalArrayIterator.
 *
 * @author sdroman
 * @since 04.17
 */
public class TwoDimensionalArrayIterator implements Iterable {

    /**
     * Array.
     */
    private int[][] values;

    /**
     * Constructs a new TwoDimensionalArrayIterator object.
     *
     * @param values int[][]
     */
    public TwoDimensionalArrayIterator(int[][] values) {
        this.values = values;
    }

    /**
     * Returns an iterator over elements of type.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator iterator() {

        Iterator iterator = new Iterator() {

            int size = values.length * values[0].length;

            int index = 0;

            int i = 0;

            int j = 0;

            /**
             * Returns {@code true} if the iteration has more elements.
             * @return {@code true} if the iteration has more elements
             */
            @Override
            public boolean hasNext() {
                return index < size;
            }

            /**
             * Returns the next element in the iteration.
             * @return the next element in the iteration
             */
            @Override
            public Object next() {
                if (hasNext()) {
                    int value = values[i][j];
                    j++;
                    index++;
                    if (j == values[i].length) {
                        j = 0;
                        i++;
                    }
                    return value;
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
        return iterator;
    }
}
