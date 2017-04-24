package ru.sdroman.pro.generic;

/**
 * Interface Store.
 *
 * @param <T>
 * @author sdroman
 * @since 04.17
 */
public interface Store<T extends Base> {

    /**
     * Add new element.
     *
     * @param value T
     */
    void add(T value);

    /**
     * Remove element by id.
     *
     * @param id String
     * @return removed element
     * @throws ElementNotFoundException exception
     */
    T remove(String id) throws ElementNotFoundException;

    /**
     * Returns element by id.
     *
     * @param id String
     * @return T
     * @throws ElementNotFoundException exception
     */
    T get(String id) throws ElementNotFoundException;

    /**
     * Update element.
     *
     * @param id    String
     * @param value T
     * @return T
     * @throws ElementNotFoundException exception
     */
    T update(String id, T value) throws ElementNotFoundException;
}
