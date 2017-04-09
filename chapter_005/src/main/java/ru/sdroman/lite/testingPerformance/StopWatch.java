package ru.sdroman.lite.testingPerformance;

/**
 * Class StopWatch.
 *
 * @author sdroman
 * @version 0.1
 * @since 04.17
 */
public class StopWatch {

    /**
     * Time.
     */
    private long time;

    /**
     * Start.
     *
     * @return long
     */
    public long start() {
        time = System.currentTimeMillis();
        return time;
    }

    /**
     * Gets elapsed time.
     *
     * @return long
     */
    public long getElapsedTime() {
        return System.currentTimeMillis() - time;
    }
}
