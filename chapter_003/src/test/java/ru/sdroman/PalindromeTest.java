package ru.sdroman;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for Palindrome class.
 *
 * @author sdroman
 * @version 1.0
 * @since 20.01.17
 */
public class PalindromeTest {
    /**
     * Test isPalindrome() method with the word lowercase.
     *
     * @throws NotFiveLettersException exception
     */
    @Test
    public void whenGivePalindromeToLowerCaseThenReturnTrue() throws NotFiveLettersException {
        Palindrome palindrome = new Palindrome();
        String testString = "level";
        assertThat(palindrome.isPalindrome(testString), is(true));
    }

    /**
     * Test isPalindrome() method with the word uppercase.
     *
     * @throws NotFiveLettersException exception
     */
    @Test
    public void whenGivePalindromeToUpperCaseThenReturnTrue() throws NotFiveLettersException {
        Palindrome palindrome = new Palindrome();
        String testString = "MADAM";
        assertThat(palindrome.isPalindrome(testString), is(true));
    }

    /**
     * Test isPalindrome() method with word lowercase and uppercase.
     *
     * @throws NotFiveLettersException exception
     */
    @Test
    public void whenGivePalindromeToLowerAndUpperCaseThenReturnTrue() throws NotFiveLettersException {
        Palindrome palindrome = new Palindrome();
        String testString = "Stats";
        assertThat(palindrome.isPalindrome(testString), is(true));
    }

    /**
     * Test isPalindrome() method with not palindrome.
     *
     * @throws NotFiveLettersException exception
     */
    @Test
    public void whenGiveNotPalindromeThenReturnFalse() throws NotFiveLettersException {
        Palindrome palindrome = new Palindrome();
        String testString = "world";
        assertThat(palindrome.isPalindrome(testString), is(false));
    }

    /**
     * Test exception.
     *
     * @throws NotFiveLettersException exception
     */
    @Test(expected = NotFiveLettersException.class)
    public void whenGivePalindromeNoFiveLettersThenException() throws NotFiveLettersException {
        Palindrome palindrome = new Palindrome();
        String testString = "deified";
        palindrome.isPalindrome(testString);
    }

    /**
     * Test isPalindromeArrayVersion() method with the word lowercase.
     *
     * @throws NotFiveLettersException exception
     */
    @Test
    public void whenGivePalindromeToLowerCaseInArrayVersionThenReturnTrue() throws NotFiveLettersException {
        Palindrome palindrome = new Palindrome();
        String testString = "level";
        assertThat(palindrome.isPalindromeArrayVersion(testString), is(true));
    }

    /**
     * Test isPalindromeArrayVersion() method with the word uppercase.
     *
     * @throws NotFiveLettersException exception
     */
    @Test
    public void whenGivePalindromeToUpperCaseInArrayVersionThenReturnTrue() throws NotFiveLettersException {
        Palindrome palindrome = new Palindrome();
        String testString = "MADAM";
        assertThat(palindrome.isPalindromeArrayVersion(testString), is(true));
    }

    /**
     * Test isPalindromeArrayVersion() method with word lowercase and uppercase.
     *
     * @throws NotFiveLettersException exception
     */
    @Test
    public void whenGivePalindromeToLowerAndUpperCaseInArrayVersionThenReturnTrue() throws NotFiveLettersException {
        Palindrome palindrome = new Palindrome();
        String testString = "Stats";
        assertThat(palindrome.isPalindromeArrayVersion(testString), is(true));
    }

    /**
     * Test isPalindromeArrayVersion() method with not palindrome.
     *
     * @throws NotFiveLettersException exception
     */
    @Test
    public void whenGiveNotPalindromeArrayVersionThenReturnFalse() throws NotFiveLettersException {
        Palindrome palindrome = new Palindrome();
        String testString = "world";
        assertThat(palindrome.isPalindromeArrayVersion(testString), is(false));
    }

    /**
     * Test exception.
     *
     * @throws NotFiveLettersException exception
     */
    @Test(expected = NotFiveLettersException.class)
    public void whenGivePalindromeNoFiveLettersInArrayVersionThenException() throws NotFiveLettersException {
        Palindrome palindrome = new Palindrome();
        String testString = "deified";
        palindrome.isPalindromeArrayVersion(testString);
    }
}
