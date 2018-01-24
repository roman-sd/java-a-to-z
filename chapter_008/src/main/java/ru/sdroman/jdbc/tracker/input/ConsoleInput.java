package ru.sdroman.jdbc.tracker.input;

import ru.sdroman.jdbc.tracker.exception.MenuOutException;

import java.util.Scanner;

/**
 * Class for console input.
 */
public class ConsoleInput implements Input {

    /**
     * Scanner.
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

    /**
     * Asks the question and returns a answer.
     *
     * @param question String
     * @param range    int[]
     * @return int
     * @throws MenuOutException exception
     */
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}
