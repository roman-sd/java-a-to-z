package ru.sdroman.synchronizy.findtext;

import java.io.File;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Pattern;

/**
 * Class FileFinder.
 *
 * @author sdroman
 * @since 08.2017
 */
public class FileFinder implements Runnable {

    /**
     * Directory to search.
     */
    private String rootPath;

    /**
     * Blocking queue.
     */
    private final BlockingQueue<String> queue;

    /**
     * Pattern.
     */
    private String pattern;

    /**
     * Constructs a new FileFinder object.
     *
     * @param rootPath String
     * @param pattern  String
     * @param queue    BlockingQueue
     */
    public FileFinder(String rootPath, String pattern, final BlockingQueue<String> queue) {
        this.rootPath = rootPath;
        this.pattern = pattern;
        this.queue = queue;
    }

    /**
     * Recursive search.
     *
     * @param path String
     */
    private void findFile(String path) {
        File dir = new File(path);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (Pattern.matches(this.pattern, file.getName()) && !file.isDirectory()) {
                        try {
                            this.queue.put(file.getAbsolutePath());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (file.isDirectory()) {
                        findFile(file.getPath());
                    }
                }
            }
        }
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
        findFile(this.rootPath);
    }
}
