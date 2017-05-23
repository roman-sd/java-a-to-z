package ru.sdroman.pro.tree.bst;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * Class BinarySearchTree.
 *
 * @param <E> type of elements
 * @author sdroman
 * @since 05.2017
 */
public class BinarySearchTree<E extends Comparable<E>> implements ITree<E> {

    /**
     * Size.
     */
    private int size;

    /**
     * Root element.
     */
    private Node<E> root;

    /**
     * Elements of tree.
     */
    private Deque<Node<E>> elements = new ArrayDeque<>();

    /**
     * Validates the node is an instance of supported {@link NodeImpl} type and casts to it.
     *
     * @param node node
     * @return casted {@link NodeImpl} node
     * @throws IllegalArgumentException exception
     */
    private NodeImpl<E> validate(Node<E> node) throws IllegalArgumentException {
        if (node == null || !(node instanceof NodeImpl)) {
            throw new IllegalArgumentException("Invalid Node");
        }
        return (NodeImpl<E>) node;
    }

    /**
     * @return the node of the root of the tree (or null if empty)
     */
    @Override
    public Node<E> root() {
        return this.root;
    }

    /**
     * Returns an iterable collection containing the children of <i>node</i>.
     *
     * @param node node
     * @return an iterable collection containing the children of <i>node</i>
     */
    @Override
    public Iterable<Node<E>> children(Node<E> node) {
        Deque<Node<E>> deque = new ArrayDeque<>();
        NodeImpl<E> parentNode = validate(node);
        if (parentNode.getLeft() != null) {
            deque.push(parentNode.getLeft());
        }
        if (parentNode.getRight() != null) {
            deque.push(parentNode.getRight());
        }
        return deque;
    }

    /**
     * Places element <i>e</i> at the root of an empty tree and returns its new {@link Node}.
     *
     * @param e element
     * @return created root
     */
    private Node<E> addRoot(E e) {
        this.root = new NodeImpl<>(e);
        this.size = 1;
        return this.root;
    }

    /**
     * Creates a new child of {@link Node} <i>current</i> storing element <i>e</i>.
     *
     * @param parent parent node
     * @param node   element
     * @return created node
     */
    private Node<E> add(Node<E> parent, Node<E> node) {
        if (parent == null) {
            return node;
        }
        if (node.getValue().compareTo(parent.getValue()) < 0) {
            validate(parent).left = add(validate(parent).getLeft(), node);
        } else {
            if (node.getValue().compareTo(parent.getValue()) >= 0) {
                validate(parent).right = add(validate(parent).getRight(), node);
            }
        }
        return parent;
    }

    /**
     * Creates a new element <i>e</i>.
     *
     * @param e element
     */
    @Override
    public Node<E> add(E e) {
        Node<E> newNode;
        if (this.root == null) {
            newNode = addRoot(e);
        } else {
            newNode = new NodeImpl<>(e);
            add(this.root, newNode);
            this.size++;
        }
        return newNode;
    }

    /**
     * Searches the node.
     *
     * @param e element
     * @return Found node.
     */
    public Node<E> search(E e) {
        Node<E> cur = this.root;
        while (cur != null) {
            int comp = e.compareTo(cur.getValue());
            if (comp < 0) {
                cur = validate(cur).getLeft();
            } else {
                if (comp > 0) {
                    cur = validate(cur).getRight();
                } else {
                    return cur;
                }
            }
        }
        return null;
    }

    /**
     * @return the number of nodes that are contained in the tree
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * @return true if the tree does not contain any nodes
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * An iterable collection of nodes of the tree in inorder.
     *
     * @param node Node
     */
    private void inOrder(Node<E> node) {
        if (node != null) {
            inOrder(validate(node).getLeft());
            this.elements.push(node);
            inOrder(validate(node).getRight());
        }
    }

    /**
     * @return an iterable collection of nodes of the tree in inorder
     */
    @Override
    public Iterable<Node<E>> inOrder() {
        if (this.root != null) {
            this.elements.clear();
            inOrder(root);
        }
        return this.elements;
    }

    /**
     * Iterator.
     *
     * @return an iterator for all elements in the tree
     */
    @Override
    public Iterator<E> iterator() {
        this.elements.clear();
        inOrder(this.root);
        Deque<E> nodes = new ArrayDeque<>();
        for (Node<E> node : this.elements) {
            nodes.push(node.getValue());
        }
        return nodes.iterator();
    }

    /**
     * Class NodeImpl.
     *
     * @param <T> type of elements.
     */
    class NodeImpl<T> implements Node<T> {

        /**
         * Element.
         */
        private T value;

        /**
         * Left node.
         */
        private Node<T> left;

        /**
         * Right node.
         */
        private Node<T> right;

        /**
         * Constructs a new NodeImpl object.
         *
         * @param value T
         */
        NodeImpl(T value) {
            this.value = value;
        }

        /**
         * @return the element stored at this node
         */
        @Override
        public T getValue() {
            return this.value;
        }

        /**
         * @return the element stored at this node
         */
        public Node<T> getLeft() {
            return this.left;
        }

        /**
         * @return the element stored at this node
         */
        public Node<T> getRight() {
            return this.right;
        }
    }
}
