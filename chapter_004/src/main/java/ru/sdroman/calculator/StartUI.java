package ru.sdroman.calculator;

/**
 * Class StartUI.
 *
 * @author sdroman
 * @version 0.1
 * @since 02.17
 */
public class StartUI {

    /**
     * main.
     *
     * @param args String
     */
    public static void main(String[] args) {
        new InteractCalculator(new ConsoleInput(), new StubOutput(), new Calculator()).action();
    }
}

