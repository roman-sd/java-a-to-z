package ru.sdroman.pro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.lang.Math.sqrt;

/**
 * Class PrimesIterator.
 *
 * @author sdroman
 * @since 04.17
 */
public class PrimesIterator implements Iterable {

    /**
     * element's array.
     */
    private int[] elements;

    /**
     * Constructs a new PrimeIterator object.
     *
     * @param  elements int[]
     */
    public PrimesIterator(int[] elements) {
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
                if (index == -1) {
                    nextIndex();
                }
                int prev = elements[index];
                nextIndex();
                return prev;
            }

            /**
             * Increases index to the next prime element.
             */
            private void nextIndex() {
                index++;
                while (index < elements.length && !isPrime(elements[index])) {
                    index++;
                }
            }

            /**
             * isPrime.
             * @param element int
             * @return true if element is prime
             */
            private boolean isPrime(int element) {
                final int t = 4;
                if (element < t) {
                    return true;
                }
                boolean result = true;
                for (int i = 2; i <= sqrt(element); i++) {
                    if (element % i == 0) {
                        result = false;
                        break;
                    }
                }
                return result;
            }
        };
        return it;
    }
}
