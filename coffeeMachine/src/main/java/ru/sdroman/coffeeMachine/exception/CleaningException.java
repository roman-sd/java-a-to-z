package ru.sdroman.coffeeMachine.exception;

/**
 * Exception thrown if coffee machine needs to clean.
 *
 * @author sdroman
 * @since 09.2018
 */
public class CleaningException extends RuntimeException {
    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public CleaningException(String message) {
        super(message);
    }
}
