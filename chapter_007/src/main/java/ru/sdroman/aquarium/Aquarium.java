package ru.sdroman.aquarium;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author sdroman
 * @since 10.2017
 */
public class Aquarium {

    /**
     * Queue.
     */
    private BlockingQueue<Fish> queue = new LinkedBlockingQueue<>();

    /**
     * Main.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        new Aquarium().start();
    }

    /**
     * Start.
     */
    private void start() {
        int num = 0;
        final int r = 10;
        ExecutorService executor = Executors.newCachedThreadPool();
        Random random = new Random();

        while (true) {
            try {
                for (int i = 0; i < random.nextInt(r); i++) {
                    executor.execute(new Producer(this.queue, num++));
                }
                 new Thread(new Consumer(this.queue)).start();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%s%2s", "population: ", queue.size()));
        }
    }
}
