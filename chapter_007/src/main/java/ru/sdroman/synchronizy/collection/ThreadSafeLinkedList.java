package ru.sdroman.synchronizy.collection;

import net.jcip.annotations.ThreadSafe;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * @author sdroman
 * @since 07.2017
 * @param <E> E
 */
@ThreadSafe
public class ThreadSafeLinkedList<E> implements Container<E> {

    /**
     * Size.
     */
    private int size;

    /**
     * First element.
     */
    private Node<E> first;

    /**
     * Last element.
     */
    private Node<E> last;

    /**
     * Modification counter.
     */
    private int modCount;

    /**
     * Adds element.
     *
     * @param e E
     */
    @Override
    public void add(E e) {
        synchronized (this) {
            Node<E> newElement = new Node<E>(this.last, null, e);
            if (first == null) {
                this.first = newElement;
            } else {
                newElement.prev = this.last;
                this.last.next = newElement;
            }
            this.last = newElement;
            this.size++;
            this.modCount++;
        }
    }

    /**
     * Returns element by index.
     *
     * @param index int
     * @return E
     */
    @Override
    public E get(int index) {
        Node<E> element;
        synchronized (this) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException(
                        String.format("%s%s%7s%s", "size=", this.size, "index=", index));
            }
            if (index < size / 2) {
                element = first;
                for (int i = 0; i < index; i++) {
                    element = element.next;
                }
            } else {
                element = last;
                for (int i = size - 1; i > index; i--) {
                    element = element.prev;
                }
            }
            return element.value;
        }
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            int nextIndex;

            int expectedModCount = modCount;

            Node<E> current;

            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (current == null) {
                    current = first;
                }
                E toRet = current.value;
                current = current.next;
                nextIndex++;
                return toRet;
            }
        };
    }

    /**
     * Class Node.
     * @param <E> E
     */
    private static class Node<E> {

        /**
         * Previous element.
         */
        Node<E> prev;

        /**
         * Next element.
         */
        Node<E> next;

        /**
         * Value.
         */
        E value;

        /**
         * Constructs a new Node object.
         *
         * @param prev  Node
         * @param next  Node
         * @param value E
         */
        Node(Node<E> prev, Node<E> next, E value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }
}
