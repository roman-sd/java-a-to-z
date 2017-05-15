package ru.sdroman.pro.map;

import java.util.Calendar;

/**
 * @author sdroman
 * @since 05.2017
 */
public class UserOverrideEquals extends User {

    /**
     * Constructs a new User object.
     *
     * @param name     String
     * @param children int
     * @param birthday Calendar
     */
    public UserOverrideEquals(String name, int children, Calendar birthday) {
        super(name, children, birthday);
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        UserOverrideEquals other = (UserOverrideEquals) obj;

        if (!getName().equals(other.getName())) {
            return false;
        }
        if (getChildren() != other.getChildren()) {
            return false;
        }
        if (!getBirthday().equals(other.getBirthday())) {
            return false;
        }
        return true;
    }
}
