package ru.sdroman.synchronizy.storage;

/**
 * @author sdroman
 * @since 07.2017
 */
public class User {
    /**
     * Id.
     */
    private int id;

    /**
     * Amount.
     */
    private int amount;

    /***
     * Constructs the new User object.
     * @param id int
     * @param amount int
     */
    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    /**
     * Sets amount.
     * @param amount int
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Return id.
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Return amount.
     * @return int
     */
    public int getAmount() {
        return amount;
    }
}
