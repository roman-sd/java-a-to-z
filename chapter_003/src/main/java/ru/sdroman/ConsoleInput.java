package ru.sdroman;

import java.util.Scanner;

/**
 * Class ConsoleInput.
 */
public class ConsoleInput implements Input {

    /**
     * new Scanner object.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Asks the question and returns a answer.
     * @return String
     */
    @Override
    public String ask() {
        return scanner.nextLine();
    }
}
