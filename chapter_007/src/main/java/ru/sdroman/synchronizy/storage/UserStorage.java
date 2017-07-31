package ru.sdroman.synchronizy.storage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sdroman
 * @since 07.2017
 */
@ThreadSafe
public class UserStorage {

    /**
     * Map.
     */
    @GuardedBy("this")
    private Map<Integer, User> map;

    /**
     * Constructs the new UserStorage object.
     */
    public UserStorage() {
        this.map = new HashMap<>();
    }

    /**
     * Add new User.
     * @param user User
     */
    public synchronized void add(User user) {
        this.map.put(user.getId(), user);
    }

    /**
     * Update amount.
     * @param user User
     * @param newAmount int
     */
    public synchronized void update(User user, int newAmount) {
        this.map.get(user.getId()).setAmount(newAmount);
    }

    /**
     * Remove user.
     * @param user User
     */
    public synchronized void delete(User user) {
        this.map.remove(user.getId());
    }

    /**
     * Transfer amount.
     * @param fromId int
     * @param toId int
     * @param amount int
     * @return true, if success
     */
    public boolean transfer(int fromId, int toId, int amount) {
        boolean result = false;
        synchronized (this) {
            int fromUserAmount = this.map.get(fromId).getAmount();
            int toUserAmount = this.map.get(toId).getAmount();
            if (fromUserAmount > amount) {
                this.map.get(fromId).setAmount(fromUserAmount - amount);
                this.map.get(toId).setAmount(toUserAmount + amount);
                result = true;
            }
        }
        return result;
    }
}
