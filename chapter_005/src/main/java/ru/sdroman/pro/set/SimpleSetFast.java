package ru.sdroman.pro.set;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.lang.Math.abs;

/**
 * Class SimpleSetFast.
 *
 * @param <E>
 * @author sdroman
 * @since 05.17
 */
public class SimpleSetFast<E> implements SimpleSet<E> {

    /**
     * Default capacity.
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * Array of entries.
     */
    private Entry<E>[] table;

    /**
     * Size.
     */
    private int size;

    /**
     * Constructs a new SimpleSetFast object.
     */
    @SuppressWarnings("unchecked")
    public SimpleSetFast() {
        table = new Entry[DEFAULT_CAPACITY];
    }

    /**
     * Adds elements.
     *
     * @param e E
     */
    @Override
    public void add(E e) {
        int hash = hash(e);
        Entry<E> newEntry = new Entry<E>(e, null, hash);
        if (table[hash] == null) {
            table[hash] = newEntry;
            size++;
        } else {
            Entry<E> current = table[hash];
            if (current.hash == hash && (current.value != e || !e.equals(current.value))) {
                table[hash] = newEntry;
                newEntry.next = current;
            }
        }

        if (this.size == table.length) {
            resize(table.length * 2);
        }
    }

    /**
     * Returns hash code of e.
     *
     * @param e E
     * @return int
     */
    private int hash(E e) {
        return abs(e.hashCode()) % table.length;
    }

    /**
     * Rehash.
     *
     * @param newCapacity int
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        Entry<E>[] oldTable = table;
        table = new Entry[newCapacity];
        for (Entry<E> entry : oldTable) {
            while (entry != null) {
                Entry<E> next = entry.next;
                int hash = (entry.value == null) ? 0 : hash(entry.value);
                entry.hash = hash;
                entry.next = table[hash];
                table[hash] = entry;
                entry = next;
            }
        }
    }

    /**
     * ToString.
     * @return String
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Entry basket : table) {
            if (basket != null) {
                Entry entry = basket;
                while (entry != null) {
                    sb.append(entry.value).append(" ");
                    entry = entry.next;
                }
                sb.append(System.getProperty("line.separator"));
            }
        }
        return sb.toString();
    }

    /**
     * Iterator.
     *
     * @return iterator
     */
    public Iterator iterator() {
        return new IteratorImpl<E>();
    }

    /**
     * Class Entry.
     *
     * @param <T>
     * @author sdroman
     * @since 05.17
     */
    private static class Entry<T> {

        /**
         * Value.
         */
        T value;

        /**
         * Next.
         */
        Entry<T> next;

        /**
         * Hash code.
         */
        int hash;

        /**
         * Constructs a new Entry object.
         *
         * @param value T
         * @param next  Entry
         * @param hash  int
         */
        Entry(T value, Entry<T> next, int hash) {
            this.value = value;
            this.next = next;
            this.hash = hash;
        }
    }

    /**
     * Class IteratorImpl.
     *
     * @param <T>
     */
    private class IteratorImpl<T> implements Iterator<T> {

        /**
         * The number of elements remaining to be returned by next().
         */
        int cursor = table.length;

        /**
         * Current index in table.
         */
        int count = size;

        /**
         * The last element returned by a next() call.
         */
        Entry<T> last;

        /**
         * Next element.
         */
        Entry<T> next;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return count > 0;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (count == 0) {
                throw new NoSuchElementException();
            }

            Entry<T> e = next;
            while (e == null) {
                e = (Entry<T>) table[--cursor];
            }
            next = e.next;
            last = e;
            if (next == null) {
                count--;
            }
            return (T) e.value;
        }
    }
}
