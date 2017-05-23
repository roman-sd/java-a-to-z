package ru.sdroman.pro.tree.bst;

import java.util.Iterator;

/**
 * Interface ITree.
 * @author sdroman
 * @since 05.2017
 * @param <E> element of a tree
 */
public interface ITree<E> extends Iterable<E> {

    /**
     * @return the node of the root of the tree (or null if empty)
     */
    Node<E> root();

    /**
     * Finds node.
     * @param e element
     * @return Found node.
     */
    Node<E> search(E e);

    /**
     * Returns an iterable collection containing the children of node <i>node</i> (if any).
     * @param n node
     * @return an iterable collection containing the children of node <i>node</i> (if any)
     */
    Iterable<Node<E>> children(Node<E> n);

    /**
     * Creates a new child of {@link Node} <i>p</i> storing element <i>e</i>.
     *
     * @param e element
     */
    Node<E> add(E e);

    /**
     *
     * @return the number of nodes (and hence elements) that are contained in the tree
     */
    int size();

    /**
     *
     * @return true if the tree does not contain any nodes (and thus no elements)
     */
    boolean isEmpty();

    /**
     * @return an iterable collection of nodes of the tree in inorder
     */
    Iterable<Node<E>> inOrder();

    /**
     * Iterator.
     * @return an iterator for all elements in the tree (so that the tree itself is {@link Iterable})
     */
    @Override
    Iterator<E> iterator();
}
