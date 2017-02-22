package ru.sdroman.calculator;

/**
 * Interface Input.
 *
 * @author sdroman
 * @version 0.1
 * @since 02.17
 */
public interface Input {

    /**
     * Ask the question and return answer.
     *
     * @param question String
     * @return String
     */
    String ask(String question);
}
