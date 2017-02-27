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
     * @param first  double
     * @param second double
     * @return int
     */
    double calculate(double first, double second);
}
