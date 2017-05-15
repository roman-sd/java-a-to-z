package ru.sdroman.pro.map;

import java.util.Calendar;

/**
 * Class User.
 *
 * @author sdroman
 * @since 05.2017
 */
public class User {

    /**
     * User's name.
     */
    private String name;

    /**
     * User's children.
     */
    private int children;

    /**
     * User's birthday.
     */
    private Calendar birthday;

    /**
     * Constructs a new User object.
     *
     * @param name     String
     * @param children int
     * @param birthday Calendar
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * Returns name.
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Returns children.
     *
     * @return int
     */
    public int getChildren() {
        return children;
    }

    /**
     * Returns birthday.
     *
     * @return Calendar
     */
    public Calendar getBirthday() {
        return birthday;
    }
}
