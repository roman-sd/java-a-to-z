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

    /**
     * array version.
     * @param str String
     * @return boolean
     * @throws NotFiveLettersException exception
     */
    boolean isPalindromeArrayVersion(String str) throws NotFiveLettersException {
        final int strLength = 5;
        if (str.length() != strLength) {
            throw new NotFiveLettersException("should be five letters");
        }
        int count = 0;
        char[] line = str.toLowerCase().toCharArray();
        for (int i = 0; i < line.length / 2; i++) {
            if (line[i] == line[str.length() - i - 1]) {
                count++;
            }
        }
        return count == 2;
    }
}
