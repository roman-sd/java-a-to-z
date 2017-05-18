package ru.sdroman.pro.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Class Tree.
 *
 * @param <E> E
 * @author sdroman
 * @since 05.2017
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    /**
     * Root element.
     */
    private Node<E> root;

    /**
     * Tree's elements.
     */
    private Deque<Node<E>> elements = new ArrayDeque<>();

    /**
     * Search element.
     *
     * @param rootNode   Node
     * @param nodeToFind Node
     * @return Node
     */
    private Node<E> search(Node<E> rootNode, Node<E> nodeToFind) {
        int comp = rootNode.value.compareTo(nodeToFind.value);
        if (comp == 0) {
            return rootNode;
        }
        Node<E> searchResult;
        for (Node<E> node : rootNode.children) {
            searchResult = search(node, nodeToFind);
            if (searchResult != null) {
                return searchResult;
            }
        }
        return null;
    }

    /**
     * Adds element to parent.
     *
     * @param parent E
     * @param child  E
     * @return {@code true} if successful
     */
    @Override
    public boolean add(E parent, E child) {
        boolean done = false;
        if (this.root == null) {
            this.root = new Node<>(child);
            done = true;
        } else {
            Node<E> parentNode = new Node<>(parent);
            Node<E> node = search(this.root, parentNode);
            if (node != null) {
                node.children.add(new Node<>(child));
                done = true;
            }
        }
        return done;
    }

    /**
     * isBinary.
     * @return boolean
     */
    public boolean isBinary() {
        final int childNumber = 2;
        this.elements.clear();
        preOrder(this.root);
        for (Node<E> node : this.elements) {
            if (node.children.size() > childNumber) {
                return false;
            }
        }
        return true;
    }

    /**
     * PreOrder.
     *
     * @param node Node
     */
    private void preOrder(Node<E> node) {
        if (node != null) {
            this.elements.push(node);
            for (Node<E> child : node.children) {
                preOrder(child);
            }
        }
    }

    /**
     * Returns an iterator over elements of type {@code E}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        this.elements.clear();
        preOrder(this.root);
        Deque<E> deque = new ArrayDeque<>();
        for (Node<E> node : this.elements) {
            deque.push(node.value);
        }
        return deque.iterator();
    }

    /**
     * Class Node.
     *
     * @param <T> T
     */
    class Node<T> {

        /**
         * Children.
         */
        List<Node<T>> children;

        /**
         * Value.
         */
        T value;

        /**
         * Constructs a new Node object.
         *
         * @param value T
         */
        Node(T value) {
            this.value = value;
            this.children = new ArrayList<>();
        }
    }
}
