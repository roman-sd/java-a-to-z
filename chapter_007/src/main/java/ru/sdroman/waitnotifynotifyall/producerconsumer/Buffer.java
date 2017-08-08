package ru.sdroman.waitnotifynotifyall.producerconsumer;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Buffer.
 * @author sdroman
 * @since 08.2017
 * @param <E> E
 */
public class Buffer<E> {

    /**
     * Capacity.
     */
    private final int capacity;

    /**
     * Blocking queue.
     */
    private final Queue<E> buffer;

    /**
     * Constructs a new Buffer object.
     * @param capacity int
     */
    public Buffer(final int capacity) {
        this.capacity = capacity;
        this.buffer = new ArrayDeque<>(this.capacity);
    }

    /**
     * Puts element to queue.
     * @param element Object
     * @throws InterruptedException exception
     */
    public synchronized void put(E element) throws InterruptedException {
        while (this.isFull()) {
            this.wait();
        }
        this.buffer.add(element);
        System.out.println(String.format("%s%8s", "put", element));
        this.notifyAll();
    }

    /**
     * Returns an element from the queue.
     * @return E
     * @throws InterruptedException exception
     */
    public synchronized E get()throws InterruptedException {
        while (this.buffer.isEmpty()) {
            this.wait();
        }
        E result = this.buffer.poll();
        System.out.println(String.format("%s%7s", "take", result));
        this.notifyAll();
        return result;
    }

    /**
     * Returns true if the queue is full.
     * @return boolean
     */
    private synchronized boolean isFull() {
        return this.buffer.size() == this.capacity;
    }
}
