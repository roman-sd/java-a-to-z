package sdroman.model;

import java.sql.Timestamp;

/**
 * @author sdroman
 * @since 03.2018
 */
public class User {

    /**
     * User name.
     */
    private String name;

    /**
     * User login.
     */
    private String login;

    /**
     * User email.
     */
    private String email;

    /**
     * Creation date.
     */
    private Timestamp createDate;

    /**
     * Constructs a new User object.
     *
     * @param name       String
     * @param login      String
     * @param email      String
     * @param createDate Timestamp
     */
    public User(String name, String login, String email, Timestamp createDate) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
    }

    /**
     * Returns user name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns user login.
     *
     * @return login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Returns user email.
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns creation date.
     *
     * @return Timestamp date
     */
    public Timestamp getCreateDate() {
        return createDate;
    }
}
