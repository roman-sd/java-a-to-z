package ru.sdroman.pro.map;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import static java.lang.Math.abs;

/**
 * Class Catalog.
 *
 * @param <T> T
 * @param <V> V
 * @author sdroman
 * @since 05.2017
 */
public class Catalog<T, V> implements Iterable<V> {

    /**
     * Default capacity.
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * Array of Entry.
     */
    private Entry<T, V>[] table;

    /**
     * Constructs a new Catalog object.
     */
    @SuppressWarnings("unchecked")
    public Catalog() {
        table = new Entry[DEFAULT_CAPACITY];
    }

    /**
     * Returns hash code of key.
     *
     * @param key T
     * @return int
     */
    private int hash(T key) {
        return abs(key.hashCode()) % table.length;
    }

    /**
     * Adds element to table.
     *
     * @param key   T
     * @param value V
     * @return {@code true}, if success.
     */
    public boolean insert(T key, V value) {
        if (key == null) {
            return insertForNullKey(value);
        }
        int hash = hash(key);
        if (table[hash] == null) {
            table[hash] = new Entry<>(key, value, hash);
        } else {
            return false;
        }
        return true;
    }

    /**
     * Adds element with null key.
     *
     * @param value V
     * @return true, if success.
     */
    private boolean insertForNullKey(V value) {
        if (table[0] != null) {
            return false;
        }
        table[0] = new Entry<T, V>(null, value, 0);
        return true;
    }

    /**
     * Returns the value to which the specified key is mapped.
     *
     * @param key T
     * @return V
     */
    public V get(T key) {
        int hash = key == null ? 0 : hash(key);
        return table[hash].value;
    }

    /**
     * Removes the mapping for the specified key from this map if present.
     *
     * @param key T
     * @return {@code true} if success.
     */
    public boolean delete(T key) {
        int hash = key == null ? 0 : hash(key);
        if (table[hash] == null) {
            return false;
        }
        table[hash] = null;
        return true;
    }

    /**
     * Value's iterator.
     *
     * @return Iterator.
     */
    @Override
    public Iterator<V> iterator() {
        Deque<V> elements = new ArrayDeque<>();
        for (Entry<T, V> entry : table) {
            if (entry != null) {
                elements.push(entry.value);
            }
        }
        return elements.iterator();
    }

    /**
     * Class Entry.
     *
     * @param <T> key
     * @param <V> value
     */
    private static class Entry<T, V> {

        /**
         * Key.
         */
        private final T key;

        /**
         * Value.
         */
        private V value;

        /**
         * HashCode.
         */
        private int hash;

        /**
         * Constructs a new Entry object.
         *
         * @param key   K
         * @param value V
         * @param hash  int
         */
        Entry(T key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }

        /**
         * ToString.
         *
         * @return String
         */
        @Override
        public String toString() {
            return "Entry{"
                    + "key=" + key
                    + ", value=" + value
                    + ", hash=" + hash
                    + '}';
        }
    }
}
