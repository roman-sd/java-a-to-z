package ru.sdroman.pro.list.linkedlist;

import ru.sdroman.pro.list.arraylist.SimpleContainer;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Class LinkedListContainer.
 *
 * @param <E>
 * @author sdroman
 * @since 04.17
 */
public class LinkedListContainer<E> implements SimpleContainer<E> {

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
     * @param value E
     */
    @Override
    public void add(E value) {
        Node<E> e = new Node<E>(this.last, null, value);
        if (this.first == null) {
            this.first = e;
        } else {
            last.next = e;
            e.prev = last;
        }
        e.next = null;
        last = e;
        size++;
        modCount++;
    }

    /**
     * Adds an element to the top of the list.
     * @param value E
     */
    public void addFirst(E value) {
        Node<E> tmp = this.first;
        Node<E> current = new Node<>(null, tmp, value);
        this.first = current;
        if (tmp == null) {
            last = current;
        } else {
            tmp.prev = current;
        }
        this.size++;
        this.modCount++;
    }

    /**
     * Remove a first element.
     * @return E
     */
    public E removeFirst() {
        Node<E> toRemove = first;
        if (first == null) {
            throw new NoSuchElementException();
        }
        this.first = this.first.next;
        this.size--;
        modCount++;
        return toRemove.value;
    }

    /**
     * Returns element by index.
     *
     * @param index int
     * @return E
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> tmp;
        E result;
        if (index < size / 2) {
            tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            result = tmp.value;
        } else {
            tmp = last;
            for (int i = size - 1; i > index; i--) {
                tmp = tmp.prev;
            }
            result = tmp.value;
        }
        return result;
    }

    /**
     * Returns size.
     *
     * @return int
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {

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
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (current == null) {
                    current = first;
                }
                Node<E> toReturn = current;
                current = current.next;
                nextIndex++;
                return toReturn.value;
            }
        };
        return iterator;
    }

    /**
     * Class Node.
     *
     * @param <E>
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
         * Constructs a new Node.
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
