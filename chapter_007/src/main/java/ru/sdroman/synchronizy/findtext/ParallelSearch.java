package ru.sdroman.synchronizy.findtext;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Class ParallelSearch.
 *
 * @author sdroman
 * @since 08.2017
 */
public class ParallelSearch {

    /**
     * List of producer threads.
     */
    private static List<Thread> threadProducerList = new ArrayList<>();
    /**
     * Blocking queue.
     */
    private final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    /**
     * Root directory.
     */
    private String rootDir;
    /**
     * Text to search.
     */
    private String textToFind;

    /**
     * List of file extensions.
     */
    private List<String> extensions = new ArrayList<>();

    /**
     * List of all threads.
     */
    private List<Thread> threadList = new ArrayList<>();

    /**
     * List of search result.
     */
    private List<String> resultList = new ArrayList<>();

    /**
     * Constructs a new ParallelSearcher object.
     *
     * @param rootDir    String
     * @param textToFind String
     * @param extensions List<String>
     */
    public ParallelSearch(String rootDir, String textToFind, List<String> extensions) {
        this.rootDir = rootDir;
        this.textToFind = textToFind;
        this.extensions = extensions;
    }

    /**
     * Returns true if at least one producer thread is alive.
     *
     * @return boolean
     */
    public static boolean isProducersAlive() {
        for (Thread t : threadProducerList) {
            if (t.isAlive()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Start search.
     */
    public void start() {
        System.out.println("Start searching...");
        createProducer();
        createConsumer();

        for (Thread thread : this.threadList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (String s : this.resultList) {
            System.out.println(s);
        }
        System.out.println(String.format("%s%2s%7s", "found", this.resultList.size(), "files."));
    }

    /**
     * Creates fileFinder threads.
     */
    private void createProducer() {
        for (String extension : this.extensions) {
            Thread producer = new Thread(new FileFinder(this.rootDir, extension, this.queue));
            threadProducerList.add(producer);
            threadList.addAll(threadProducerList);
            producer.start();
        }
    }

    /**
     * Creates textFinder threads.
     */
    private void createConsumer() {
        int numProcessor = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < numProcessor; i++) {
            Thread consumerThread = new Thread(new TextFinder(this.textToFind, this.queue, this.resultList));
            this.threadList.add(consumerThread);
            consumerThread.start();
        }
    }
}
