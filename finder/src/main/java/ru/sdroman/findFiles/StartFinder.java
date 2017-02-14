package ru.sdroman.findFiles;

import java.io.IOException;

/**
 * Class StartFinder.
 *
 * @author sdroman
 * @version 0.1
 * @since 13.02.2017
 */
public class StartFinder {

    /**
     * Run Finder.
     *
     * @param args String
     * @throws IOException exception
     */
    public static void main(String[] args) throws IOException {
        new Menu(args).find();
    }
}
