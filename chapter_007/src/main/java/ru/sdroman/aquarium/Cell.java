package ru.sdroman.aquarium;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sdroman
 * @since 11.2017
 */
public class Cell {

    /**
     * Position.
     */
    private final Position position;
    /**
     * Fish id.
     */
    private int fishId;
    /**
     * Lock.
     */
    private ReentrantLock lock;

    /**
     * Constructs a new Cell object.
     *
     * @param id       int
     * @param position Position
     * @param lock     ReentrantLock
     */
    public Cell(int id, Position position, ReentrantLock lock) {
        this.fishId = id;
        this.position = position;
        this.lock = lock;
    }

    /**
     * Returns fishId.
     *
     * @return int
     */
    public int getFishId() {
        return fishId;
    }

    /**
     * Sets fishId.
     *
     * @param fishId int
     */
    public void setFishId(int fishId) {
        this.fishId = fishId;
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
     * @return ReentrantLock
     */
    public ReentrantLock getLock() {
        return lock;
    }
}
