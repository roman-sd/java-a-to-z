package ru.sdroman.pro.generic;

import java.util.Arrays;

/**
 * Class SimpleArray.
 *
 * @param <E>
 * @author sdroman
 * @since 04.17
 */
public class SimpleArray<E> {

    /**
     * Default capacity.
     */
    private static final int CAPACITY = 5;

    /**
     * Array of elements.
     */
    private Object[] elements;

    /**
     * array's size.
     */
    private int size;

    /**
     * Constructs a new empty array.
     */
    public SimpleArray() {
        this.elements = new Object[CAPACITY];
    }

    /**
     * Add element.
     *
     * @param value E
     */
    public void add(E value) {
        if (size == elements.length) {
            grow();
        }
        this.elements[size++] = value;
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
     * Remove element by position.
     *
     * @param position int
     * @return removed element
     */
    @SuppressWarnings("unchecked")
    public E remove(int position) {
        checkIndex(position);
        E temp = (E) elements[position];
        System.arraycopy(elements, position + 1, elements, position, size - position - 1);
        elements[--size] = null;
        return temp;
    }

    /**
     * Returns element by index.
     *
     * @param position int
     * @return E
     */
    @SuppressWarnings("unchecked")
    public E get(int position) {
        checkIndex(position);
        return (E) this.elements[position];
    }

    /**
     * Returns array.
     *
     * @return Object[]
     */
    public Object[] getElements() {
        return elements;
    }

    /**
     * Sets element by index to new value.
     *
     * @param position int
     * @param value    E
     * @return old value.
     */
    @SuppressWarnings("unchecked")
    public E update(int position, E value) {
        checkIndex(position);
        E tmp = (E) elements[position];
        elements[position] = value;
        return tmp;
    }

    /**
     * Checks array's index.
     *
     * @param position int
     */
    private void checkIndex(int position) {
        if (position < 0 || position > this.elements.length) {
            throw new ArrayIndexOutOfBoundsException("size: " + elements.length + ", index: " + position);
        }
    }

    /**
     * Grow.
     */
    private void grow() {
        final int newIndex = elements.length * 3 / 2 + 1;
        elements = Arrays.copyOf(elements, newIndex);
    }
}
