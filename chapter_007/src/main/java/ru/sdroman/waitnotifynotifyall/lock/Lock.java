package ru.sdroman.waitnotifynotifyall.lock;

/**
 * Class Lock.
 *
 * @author sdroman
 * @since 08.2017
 */
public class Lock {

    /**
     * isLocked.
     */
    private boolean isLocked;

    /**
     * Lock.
     */
    public synchronized void lock() {
        while (isLocked) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.isLocked = true;
    }

    /**
     * Unlock.
     */
    public synchronized void unlock() {
        this.isLocked = false;
        notifyAll();
    }
}
