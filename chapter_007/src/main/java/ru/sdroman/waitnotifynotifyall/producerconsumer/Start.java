package ru.sdroman.waitnotifynotifyall.producerconsumer;

/**
 * @author sdroman
 * @since 08.2017
 */
public class Start {

    /**
     * Main.
     * @param args String[]
     */
    public static void main(String[] args) {
        final int bufCapacity = 5;
        final int countThread = 7;
        Buffer<Integer> buf = new Buffer<>(bufCapacity);

        for (int i = 0; i < countThread; i++) {
            new Thread(new Producer(buf, i)).start();
        }
        new Thread(new Consumer(buf)).start();
    }
}
