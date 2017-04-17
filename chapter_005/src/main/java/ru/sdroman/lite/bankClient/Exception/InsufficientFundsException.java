package ru.sdroman.lite.bankClient.Exception;

/**
 * Class InsufficientFundsException.
 *
 * @author sdroman
 * @since 04.17
 */
public class InsufficientFundsException extends Exception {

    /**
     * Constructs a new InsufficientFundsException object.
     *
     * @param msg String
     */
    public InsufficientFundsException(String msg) {
        super(msg);
    }
}
