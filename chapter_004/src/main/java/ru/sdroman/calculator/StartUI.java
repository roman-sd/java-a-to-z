package ru.sdroman.calculator;

/**
 * Class StartUI.
 *
 * @author sdroman
 * @version 0.2
 * @since 02.17
 */
public class StartUI {

    /**
     * main.
     *
     * @param args String
     */
    public static void main(String[] args) {
        Calculator calculator = new EngineerCalculator();
        new Menu(new ConsoleInput(), new StubOutput(), calculator).run();
    }
}

