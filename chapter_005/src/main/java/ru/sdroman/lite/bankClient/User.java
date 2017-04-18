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
     * equals.
     * @param obj Object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        User user = (User) obj;

        if (name != null ? !name.equals(user.name) : user.name != null) {
            return false;
        }
        return passport != null ? passport.equals(user.passport) : user.passport == null;
    }

    /**
     * hashCode.
     * @return int
     */
    @Override
    public int hashCode() {
        final int p = 31;
        int result = name != null ? name.hashCode() : 0;
        result = p * result + (passport != null ? passport.hashCode() : 0);
        return result;
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
