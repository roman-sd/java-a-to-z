package ru.sdroman.pro.tree;

/**
 * Interface SimpleTree.
 *
 * @param <E> E
 * @author sdroman
 * @since 05.2017
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {

    /**
     * Adds element to parent.
     *
     * @param parent E
     * @param child  E
     * @return {@code true} if successful
     */
    boolean add(E parent, E child);
}