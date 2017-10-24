package ru.sdroman.aquarium;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author sdroman
 * @since 10.2017
 */
public class Producer implements Runnable {

    /**
     * Random.
     */
    private static final Random gRandom = new Random(System.currentTimeMillis());
    /**
     * Number.
     */
    private int num;
    /**
     * Queue.
     */
    private BlockingQueue<Fish> queue;

    /**
     * Constructs a new Producer object.
     *
     * @param queue BlockingQueue
     * @param num   int
     */
    public Producer(BlockingQueue<Fish> queue, int num) {
        this.num = num;
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
        final int minLifeTime = 4000;
        final int maxLifeTime = 25000;
        Fish fish;
        long curTime = System.currentTimeMillis();
        int lifeTime = getRandomInt(minLifeTime, maxLifeTime);
        int gender = getRandomInt(0, 1);
        try {
            fish = new Fish(this.num, curTime + lifeTime, gender);
            this.queue.put(fish);
            System.out.println(String.format("%s%7s%12s", "fish №" + this.num, fish.getGender(), "starting.."));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Generates random int.
     *
     * @param min int
     * @param max int
     * @return int
     */
    public int getRandomInt(int min, int max) {
        return gRandom.nextInt(max - min + 1) + min;
    }
}
