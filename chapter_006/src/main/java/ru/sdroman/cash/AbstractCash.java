package ru.sdroman.cash;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * AbstractCash.
 *
 * @param <K> key
 * @param <V> value
 * @author sdroman
 * @since 11.2017
 */
public abstract class AbstractCash<K, V> {

    /**
     * Cash.
     */
    private final Map<K, SoftReference<V>> cash = new HashMap<>();

    /**
     * Puts value by key.
     *
     * @param key   K
     * @param value V
     */
    private void put(K key, V value) {
        cash.put(key, new SoftReference<>(value));
    }

    /**
     * Returns value from cash.
     *
     * @param key K
     * @return V
     */
    V get(K key) {
        V data;
        SoftReference<V> softReference = cash.get(key);
        if (softReference == null) {
            data = getData(key);
            this.put(key, data);
        } else {
            data = softReference.get();
        }

        return data;
    }

    /**
     * Load data into cash.
     *
     * @param key K
     * @return V
     */
    abstract V getData(K key);
}
