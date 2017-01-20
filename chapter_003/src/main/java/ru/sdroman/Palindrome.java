package ru.sdroman;

import java.util.Scanner;

/**
 * Class Palindrome.
 *
 * @author sdroman
 * @version 1.0
 * @since 20.01.17
 */
public class Palindrome {

    /**
     * Method for console input.
     *
     * @return String
     */
    private String inputString() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    /**
     * Palindrome or not.
     *
     * @param str String
     * @return boolean
     * @throws NotFiveLettersException exception
     */
    boolean isPalindrome(String str) throws NotFiveLettersException {
        final int STRINGLENGTH = 5;
        if (str.length() != STRINGLENGTH) {
            throw new NotFiveLettersException("should be five letters");
        }
        StringBuilder strBuilder = new StringBuilder(str);
        return strBuilder.toString().equalsIgnoreCase(strBuilder.reverse().toString());
    }
}
