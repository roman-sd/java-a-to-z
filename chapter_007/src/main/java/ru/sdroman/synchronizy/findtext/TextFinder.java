package ru.sdroman.synchronizy.findtext;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * Class TextFinder.
 *
 * @author sdroman
 * @since 08.2017
 */
public class TextFinder implements Runnable {

    /**
     * Blocking queue.
     */
    private final BlockingQueue<String> queue;

    /**
     * Result list.
     */
    private List<String> resultList = new ArrayList<>();

    /**
     * Text to find.
     */
    private String textToFind;

    /**
     * Constructs a new TextFinder object.
     *
     * @param textToFind String
     * @param queue      BlockingQueue
     * @param resultList List
     */
    public TextFinder(String textToFind, final BlockingQueue<String> queue, List<String> resultList) {
        this.textToFind = textToFind;
        this.queue = queue;
        this.resultList = resultList;
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
        while (!Thread.currentThread().isInterrupted()) {

            String line = this.queue.poll();
            if (line == null && !ParallelSearch.isProducersAlive()) {
                return;
            }
            if (line != null) {
                try {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(new FileInputStream(line), "utf-8"));
                    String str;
                    while ((str = reader.readLine()) != null) {
                        if (str.toLowerCase().contains(this.textToFind.toLowerCase())) {
                            this.resultList.add(line);
                            break;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
