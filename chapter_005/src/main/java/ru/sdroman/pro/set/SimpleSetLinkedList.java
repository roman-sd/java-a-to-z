package ru.sdroman.pro.set;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Class SimpleSetLinkedList.
 *
 * @param <E>
 * @author sdroman
 * @since 05.17
 */
public class SimpleSetLinkedList<E> implements SimpleSet<E> {

    /**
     * List. of elements.
     */
    private List<E> list;

    /**
     * Constructs a new SimpleSetLinkedList object.
     */
    public SimpleSetLinkedList() {
        list = new LinkedList<>();
    }

    /**
     * Adds elements.
     *
     * @param e E
     */
    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.add(e);
        }
    }

    /**
     * Returns an iterator over elements of type {@code E}.
     *
     * @return Iterator
     */
    public Iterator iterator() {
        return list.iterator();
    }
}
