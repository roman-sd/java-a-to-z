package ru.sdroman.lite.generic;

import java.util.HashMap;
import java.util.List;

/**
 * Class UserConvert.
 *
 * @author sdroman
 * @version 0.1
 * @since 04.17
 */
public class UserConvert {

    /**
     * Converts List<User> to HashMap<Integer, User>.
     *
     * @param list List<User>
     * @return HashMap
     */
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        for (User element : list) {
            map.put(element.getId(), element);
        }
        return map;
    }
}
