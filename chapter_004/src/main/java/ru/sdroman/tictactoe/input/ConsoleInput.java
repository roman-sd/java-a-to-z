package ru.sdroman.tictactoe.input;

import ru.sdroman.tictactoe.interfaces.Input;

import java.util.Scanner;

/**
 * Class ConsoleInput.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class ConsoleInput implements Input {

    /**
     * Scanner.
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * Asks question & return answer.
     *
     * @param question String
     * @return String
     */
    @Override
    public String read(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
}
