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
     * max.
     */
    private int max;

    /**
     * Constructs a new PrimeIterator object.
     *
     * @param max int
     */
    public PrimesIterator(int max) {
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

            int prime = 0;

            /**
             * Returns {@code true} if the iteration has more even elements.
             * @return {@code true} if the iteration has more even elements
             */
            @Override
            public boolean hasNext() {
                return prime <= max;
            }

            /**
             * Returns the next even element in the iteration.
             * @return the next even element in the iteration
             */
            @Override
            public Object next() {
                int tmp = prime;
                nextPrime();
                if (tmp > max) {
                    throw new NoSuchElementException();
                }
                return tmp;
            }

            /**
             * Calculates next prime number.
             */
            private void nextPrime() {
                boolean isPrime = false;
                while (!isPrime) {
                    isPrime = true;
                    prime++;
                    for (int i = 2; i <= sqrt(prime); i++) {
                        if (prime % i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                }
            }
        };
        return it;
    }
}
