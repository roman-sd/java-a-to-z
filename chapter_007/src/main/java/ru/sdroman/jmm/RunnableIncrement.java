package ru.sdroman.jmm;

/**
 * Class RunnableIncrement.
 * @author sdroman
 * @since 07.2017
 */
public class RunnableIncrement implements Runnable {

    /**
     * Number.
     */
    private int num;

    /**
     * Value.
     */
    private int value = 0;

    /**
     * Constructs the new RunnableIncrement object.
     * @param num int
     */
    public RunnableIncrement(int num) {
        this.num = num;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            value++;
        }
    }

    /**
     * Returns value.
     * @return int
     */
    public int getValue() {
        return value;
    }
}
