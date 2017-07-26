package ru.sdroman.jmm;

/**
 * ThreadProblemExample.
 * @author sdroman
 * @since 07.2017
 */
public class ThreadProblemExample {

    /**
     * Main.
     * @param args String[]
     */
    public static void main(String[] args) {
        final int num = 100_000;
        RunnableIncrement inc = new RunnableIncrement(num);
        Thread thread1 = new Thread(inc);
        Thread thread2 = new Thread(inc);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("%s%7s", "expected:", 2 * num));
        System.out.println(String.format("%s%9s", "actual:", inc.getValue()));
    }
}
