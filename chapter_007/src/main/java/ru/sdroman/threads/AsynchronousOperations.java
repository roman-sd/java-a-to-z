package ru.sdroman.threads;

/**
 * @author sdroman
 * @since 07.2017
 */
public class AsynchronousOperations {

    /**
     * Class SpaceCount.
     */
    public static final class SpaceCount implements Runnable {

        /**
         * Text.
         */
        private final String line;

        /**
         * Constructs the new SpaceCount object.
         *
         * @param line String
         */
        SpaceCount(final String line) {
            this.line = line;
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
            int count = 0;
            for (char symbol : this.line.toCharArray()) {
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }
                if (symbol == ' ') {
                    count++;
                }
            }
            System.out.println(String.format("%s%3s", "spaces:", count));
        }

    }
    /**
     * Class WordCount.
     */
    public static final class WordCount implements Runnable {

        /**
         * Text.
         */
        private final String line;

        /**
         * Constructs the new WordCount object.
         *
         * @param line String
         */
        WordCount(String line) {
            this.line = line;
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
            if (!Thread.currentThread().isInterrupted()) {
                System.out.println(String.format("%s%3s", "words: ", this.line.split(" +").length));
            }
        }
    }

    /**
     * Main.
     * @param args arguments
     */
    public static void main(String[] args) {
        final String str = "Now or never";
        final int t = 1000;
        System.out.println("Start");
        Thread wordCount = new Thread(new WordCount(str));
        Thread spaceCount = new Thread(new SpaceCount(str));
        wordCount.start();
        spaceCount.start();

        try {
            wordCount.join(t);
            spaceCount.join(t);

            wordCount.interrupt();
            spaceCount.interrupt();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("Finish");
    }
}
