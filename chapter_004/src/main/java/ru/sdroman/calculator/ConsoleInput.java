package ru.sdroman.calculator;

import java.util.Scanner;

/**
 * Class ConsoleInput.
 *
 * @author sdroman
 * @version 0.1
 * @since 02.17
 */
public class ConsoleInput implements Input {

    /**
     * Scanner.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Ask the question and return answer.
     *
     * @param question String
     * @return String
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
