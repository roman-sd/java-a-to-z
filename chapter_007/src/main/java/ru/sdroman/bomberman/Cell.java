package ru.sdroman.bomberman;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sdroman
 * @since 09.2017
 */
public class Cell {

    /**
     * Lock.
     */
    private final Lock lock;
    /**
     * Current position.
     */
    private final Position position;

    /**
     * Constructs a new Cell object.
     *
     * @param position Position
     */
    public Cell(final Position position) {
        this.position = position;
        this.lock = new ReentrantLock();
    }

    /**
     * Returns position.
     *
     * @return Position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Returns lock.
     *
     * @return Lock
     */
    public Lock getLock() {
        return this.lock;
    }

}
