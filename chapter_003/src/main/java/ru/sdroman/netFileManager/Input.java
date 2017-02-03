package ru.sdroman.netFileManager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Interface Input.
 * @author sdroman
 * @since 01.17
 * @version 0.1
 */
public interface Input {

    /**
     * Asks the question and returns a answer.
     * @param question String
     * @param inputStream DataInputStream
     * @param outputStream DataOutputStream
     * @return String
     * @throws IOException exception
     */
    String ask(String question, DataInputStream inputStream, DataOutputStream outputStream) throws IOException;
}
