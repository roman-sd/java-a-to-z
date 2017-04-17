package ru.sdroman.lite.bankClient.Exception;

/**
 * Class UserNotFoundException.
 * @author sdroman
 * @since 04.17
 */
public class UserNotFoundException extends Exception {

    /**
     * Constructs a new UserNotFoundException object.
     * @param msg String
     */
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
