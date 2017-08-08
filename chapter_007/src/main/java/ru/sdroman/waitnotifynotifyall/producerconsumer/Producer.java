package ru.sdroman.waitnotifynotifyall.producerconsumer;

/**
 * Producer.
 * @author sdroman
 * @since 08.2017
 */
public class Producer implements Runnable {

    /**
     * Buffer.
     */
    private final Buffer buffer;

    /**
     * Element.
     */
    private Object elem;

    /**
     * Constructs a new Producer object.
     * @param buffer Buffer
     * @param elem Object
     */
    public Producer(Buffer buffer, Object elem) {
        this.buffer = buffer;
        this.elem = elem;
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
    @SuppressWarnings("unchecked")
    public void run() {
        final int sleepTime = 1000;
        while (true) {
            try {
                this.buffer.put(this.elem);
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
