package ru.sdroman.synchronizy.counter;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * @author sdroman
 * @since 07.2017
 */
@ThreadSafe
public class Counter {

    /**
     * Safe count.
     */
    @GuardedBy("this")
    private int count = 0;

    /**
     * Count increment.
     */
    public synchronized void increment() {
        count++;
    }

    /**
     * Return count.
     * @return int
     */
    public int getCount() {
        return count;
    }
}