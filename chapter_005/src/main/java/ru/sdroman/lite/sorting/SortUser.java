package ru.sdroman.lite.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class SortUser.
 *
 * @author sdroman
 * @since 04.17
 */
public class SortUser {

    /**
     * Sort by age.
     *
     * @param list List<User>
     * @return TreeSet<User>
     */
    public Set<User> sort(List<User> list) {
        Set<User> treeSet = new TreeSet<>();
        for (User user : list) {
            treeSet.add(user);
        }
        return treeSet;
    }

    /**
     * Sort by hashcode.
     *
     * @param users List
     * @return List<User>
     */
    public List<User> sortHash(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return Integer.compare(user1.hashCode(), user2.hashCode());
            }
        });
        return users;
    }

    /**
     * Sort by length.
     *
     * @param users List
     * @return Set<User>
     */
    public List<User> sortLength(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return Integer.compare(user1.getName().length(), user2.getName().length());
            }
        });
        return users;
    }
}
