package ru.sdroman.lite.testingPerformance;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

/**
 * Class CollectionPerformanceTest.
 *
 * @author sdroman
 * @version 0.1
 * @since 04.17
 */
public class CollectionPerformanceTest {

    /**
     * Add.
     *
     * @param collection Collection<String>
     * @param line       String
     * @param amount     int
     * @return long
     */
    public long add(Collection<String> collection, String line, int amount) {
        StopWatch time = new StopWatch();
        RandomString rs = new RandomString();
        final int lineLength = 10;
        Random rn = new Random();
        time.start();
        for (int i = 0; i < amount; i++) {
            collection.add(rs.createString(rn.nextInt(lineLength)));
        }
        return time.getElapsedTime();
    }

    /**
     * Remove.
     *
     * @param collection Collection<String>
     * @param amount     int
     * @return long
     */
    public long delete(Collection<String> collection, int amount) {
        StopWatch time = new StopWatch();
        Iterator<String> iterator = collection.iterator();
        int count = 0;
        time.start();
        while (iterator.hasNext() || amount == count) {
            iterator.next();
            iterator.remove();
            count++;
        }
        return time.getElapsedTime();
    }

}
