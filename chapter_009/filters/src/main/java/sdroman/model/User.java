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
     * Password.
     */
    private String password;

    /**
     * User email.
     */
    private String email;

    /**
     * Creation date.
     */
    private Timestamp createDate;

    /**
     * Role.
     */
    private Role role;

    /**
     * Constructs a new User object.
     *
     * @param name       String
     * @param login      String
     * @param email      String
     * @param createDate Timestamp
     * @param role Role
     */
    public User(String name, String login, String password, String email, Timestamp createDate, Role role) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.createDate = createDate;
        this.role = role;
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
     * Returns password.
     *
     * @return password
     */
    public String getPassword() {
        return password;
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

    /**
     * Returns role.
     *
     * @return role
     */
    public Role getRole() {
        return role;
    }
}
