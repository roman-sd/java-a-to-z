package ru.sdroman.waitnotifynotifyall.producerconsumer;

/**
 * Consumer.
 * @author sdroman
 * @since 08.2017
 */
public class Consumer implements Runnable {

    /**
     * Buffer.
     */
    private final Buffer buffer;

    /**
     * Constructs a new Consumer object.
     * @param buffer Buffer
     */
    public Consumer(final Buffer buffer) {
        this.buffer = buffer;
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
        final int sleepTime = 300;
        while (true) {
            try {
                Object elem = this.buffer.get();
                Thread.sleep(sleepTime);
                System.out.println(String.format("%s%3s", "element:", elem));
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
