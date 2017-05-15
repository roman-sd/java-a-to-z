package ru.sdroman.pro.map;

import java.util.Calendar;

/**
 * @author sdroman
 * @since 05.2017
 */
public class UserOverrideHashCode extends User {

    /**
     * Constructs a new User object.
     *
     * @param name     String
     * @param children int
     * @param birthday Calendar
     */
    public UserOverrideHashCode(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getName().hashCode();
        result = prime * result + getChildren();
        result = prime * result + getBirthday().hashCode();
        return result;
    }
}
