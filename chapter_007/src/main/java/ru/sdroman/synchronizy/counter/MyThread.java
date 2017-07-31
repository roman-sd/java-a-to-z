package ru.sdroman.synchronizy.counter;

/**
 * @author sdroman
 * @since 07.2017
 */
public class MyThread implements Runnable {

    /**
     * Num.
     */
    private static final int N = 100000;

    /**
     * Counter.
     */
    private Counter counter;

    /**
     * Constructs a new MyThread object.
     * @param counter Counter
     */
    public MyThread(Counter counter) {
        this.counter = counter;
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
        for (int i = 0; i < N; i++) {
            counter.increment();
        }
    }

    /**
     * Main.
     * @param args String[]
     */
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread threadA = new Thread(new MyThread(counter));
        Thread threadB = new Thread(new MyThread(counter));
        threadA.start();
        threadB.start();
        try {
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCount());
    }
}
