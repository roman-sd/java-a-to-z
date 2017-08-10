package ru.sdroman.waitnotifynotifyall.threadpool;

import java.util.LinkedList;

/**
 * @author sdroman
 * @since 08.2017
 */
public class ThreadPool {

    /**
     * Number of threads.
     */
    private final int nThreads = Runtime.getRuntime().availableProcessors();

    /**
     * Task queue.
     */
    private final LinkedList queue;

    /**
     * Threads array.
     */
    private PoolWorker[] threads;

    /**
     * Constructs a new ThreadPool object.
     */
    public ThreadPool() {
        this.queue = new LinkedList();
        this.threads = new PoolWorker[nThreads];
        start();
    }

    /**
     * Init & start.
     */
    private void start() {
        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    /**
     * Adds new task to the queue.
     *
     * @param runnable Runnable
     */
    @SuppressWarnings("unchecked")
    public synchronized void add(Runnable runnable) {
        queue.addLast(runnable);
        queue.notifyAll();
    }

    /**
     * Class PoolWorker.
     */
    private class PoolWorker extends Thread {
        /**
         * If this thread was constructed using a separate
         * <code>Runnable</code> run object, then that
         * <code>Runnable</code> object's <code>run</code> method is called;
         * otherwise, this method does nothing and returns.
         * <p>
         * Subclasses of <code>Thread</code> should override this method.
         *
         * @see #start()
         * @see #stop()
         */
        @Override
        public void run() {
            Runnable runnable;
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    runnable = (Runnable) queue.removeFirst();
                }
                try {
                    runnable.run();
                } catch (RuntimeException ex) {
                    ex.printStackTrace();
                    return;
                }
            }
        }
    }
}
