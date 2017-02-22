package ru.sdroman.calculator;

/**
 * Class Action.
 *
 * @author sdroman
 * @version 0.1
 * @since 02.17
 */
public interface Action {

    /**
     * Arithmetical operations.
     *
     * @return String
     */
    String operation();

    /**
     * Calculate.
     *
     * @param first  int
     * @param second int
     * @return int
     */
    int calculate(int first, int second);
}
