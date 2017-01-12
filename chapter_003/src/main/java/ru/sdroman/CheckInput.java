package ru.sdroman;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Class CheckInput.
 *
 * @author sdroman
 * @version 1.0
 * @since 11.01.17
 */
class CheckInput {

    /**
     * Even or odd.
     *
     * @param in InputStream
     * @return boolean
     */
    boolean isNumber(InputStream in) {
        boolean result = false;
        try (Scanner scanner = new Scanner(in)) {
            int num = scanner.nextInt();
            if (num != 0 && num % 2 == 0) {
                result = true;
            }
            return result;
        } catch (InputMismatchException ime) {
            System.err.println(ime + ".");
            return false;
        }
    }
}
