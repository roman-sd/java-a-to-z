package ru.sdroman.aquarium;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;

/**
 * @author sdroman
 * @since 10.2017
 */
public class Consumer implements Runnable {

    /**
     * Queue.
     */
    private BlockingQueue<Fish> queue;

    /**
     * Constructs a new Consumer object.
     * @param queue BlockingQueue
     */
    public Consumer(BlockingQueue<Fish> queue) {
        this.queue = queue;
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
        Iterator<Fish> iterator = this.queue.iterator();
        long curTime = System.currentTimeMillis();
        while (iterator.hasNext()) {
            Fish fish = iterator.next();
            if (curTime - fish.getDeadTime()  >= 0) {
                System.out.println("fish №" + fish.getNum() + " died.");
                this.queue.remove(fish);
            }
        }
    }
}
