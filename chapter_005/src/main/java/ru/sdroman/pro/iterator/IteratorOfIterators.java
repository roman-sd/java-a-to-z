package ru.sdroman.pro.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class IteratorOfIterators.
 *
 * @author sdroman
 * @since 04.17
 */
public class IteratorOfIterators implements Iterator<Integer> {

    /**
     * Current iterator.
     */
    private Iterator<Integer> current;

    /**
     * Iterator of iterators.
     */
    private Iterator<Iterator<Integer>> iterators;

    /**
     * Converts iterator of iterators into iterator.
     *
     * @param it Iterator<Iterator<Integer>>
     * @return Iterator<Integer>
     */
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        iterators = it;
        current = it.next();
        return this;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        while (current == null || !current.hasNext()) {
            if (!iterators.hasNext()) {
                return false;
            }
            current = iterators.next();
        }
        return true;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Integer next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return current.next();
    }
}
