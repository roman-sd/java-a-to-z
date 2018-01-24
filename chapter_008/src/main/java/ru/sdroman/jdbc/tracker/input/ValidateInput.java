package ru.sdroman.jdbc.tracker.input;

import ru.sdroman.jdbc.tracker.exception.MenuOutException;

/**
 * Class ValidateInput.
 */
public class ValidateInput extends ConsoleInput {

    /**
     * Asks the question and returns a answer.
     *
     * @param question String
     * @param range    int[]
     * @return int
     * @throws MenuOutException exception
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException ex) {
                System.out.println("select key from menu");
            } catch (NumberFormatException e) {
                System.out.println("enter validate data again");
            }
        } while (invalid);
        return value;
    }
}
