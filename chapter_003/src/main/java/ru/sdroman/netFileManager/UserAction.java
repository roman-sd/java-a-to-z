package ru.sdroman.netFileManager;

import java.io.IOException;

/**
 * Interface UserAction.
 * @author sdroman
 * @since 01.17
 * @version 0.1
 */
public interface UserAction {

    /**
     * some execute.
     * @param line String
     * @throws IOException exception
     */
    void execute(String line) throws IOException;

    /**
     * Menu info.
     * @return String
     */
    String info();


}
