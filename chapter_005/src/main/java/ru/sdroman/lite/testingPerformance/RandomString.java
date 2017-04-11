package ru.sdroman.lite.testingPerformance;

import java.util.Random;

/**
 * Class RandomString.
 * @author sdroman
 * @since 04.17
 * @version 0.1
 */
public class RandomString {

    /**
     * Creates new random string.
     * @param length int
     * @return String
     */
    public String createString(int length) {
        final String valid = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        Random rn = new Random();
        String line = "";
        while (length-- > 0) {
            line += valid.charAt(rn.nextInt(valid.length()));
        }
        return line;
    }
}
