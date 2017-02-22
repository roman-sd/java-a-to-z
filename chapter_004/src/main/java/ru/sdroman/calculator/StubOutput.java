package ru.sdroman.calculator;

/**
 * Class StubOutput.
 */
public class StubOutput implements Output {
    /**
     * Print line.
     *
     * @param line String
     */
    @Override
    public void print(String line) {
        System.out.print(line);
    }
}
