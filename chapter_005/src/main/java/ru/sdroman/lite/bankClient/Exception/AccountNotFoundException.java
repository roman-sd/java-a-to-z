package ru.sdroman.lite.bankClient.Exception;

/**
 * Class AccountNotFoundException.
 *
 * @author sdroman
 * @since 04.17
 */
public class AccountNotFoundException extends Exception {

    /**
     * Constructs a new AccoutNotFoundException object.
     *
     * @param msg String
     */
    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
