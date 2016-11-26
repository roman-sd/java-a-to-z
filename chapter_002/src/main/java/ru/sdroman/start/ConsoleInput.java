package ru.sdroman.start;

import java.util.Scanner;

/**
 * Class for console input.
 */
public class ConsoleInput implements Input {

    /**
     * new Scanner object.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Asks the question and returns a answer.
     *
     * @param question String
     * @return String answer
     */
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
