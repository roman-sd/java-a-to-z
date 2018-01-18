package ru.sdroman.jdbc.tracker;

/**
 * Interface Input.
 */
public interface Input {

    /**
     * Asks the question and returns a answer.
     *
     * @param question String
     * @return String answer
     */
    String ask(String question);

    /**
     * Asks the question and returns a answer.
     *
     * @param question String
     * @param range    int[]
     * @return int
     */
    int ask(String question, int[] range);
}
