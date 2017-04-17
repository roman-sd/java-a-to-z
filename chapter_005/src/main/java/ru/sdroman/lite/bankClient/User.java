package ru.sdroman.lite.bankClient;

/**
 * Class User.
 *
 * @author sdroman
 * @since 04.17
 */
public class User {

    /**
     * Name.
     */
    private String name;

    /**
     * Passport.
     */
    private String passport;

    /**
     * Constructs a new User object.
     *
     * @param name     String
     * @param passport String
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * toString.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", passport='" + passport + '\''
                + '}';
    }
}
