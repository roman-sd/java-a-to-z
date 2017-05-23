package ru.sdroman.pro.tree.bst;

/**
 * An abstraction for a node of a tree.
 *
 * @param <E> E
 * @author sdroman
 * @since 05.2017
 */
public interface Node<E> {

    /**
     * @return the element stored at this node
     */
    E getValue();

    Node<E> getLeft();

    Node<E> getRight();
}
