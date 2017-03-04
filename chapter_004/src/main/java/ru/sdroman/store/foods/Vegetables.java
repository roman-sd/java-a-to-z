package ru.sdroman.store.foods;

/**
 * Class Vegetables.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class Vegetables extends Food {

    /**
     * Constructs new Vegetable objects.
     *
     * @param name       String
     * @param expireDate String
     * @param createDate String
     */
    public Vegetables(String name, String createDate, String expireDate) {
        super(name, createDate, expireDate);
    }
}
