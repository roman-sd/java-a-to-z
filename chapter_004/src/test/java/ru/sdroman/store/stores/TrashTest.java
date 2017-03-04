package ru.sdroman.store.stores;

import org.junit.Before;
import org.junit.Test;
import ru.sdroman.store.exceptions.StoreIsFullException;
import ru.sdroman.store.foods.Food;
import ru.sdroman.store.foods.Fruit;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Trash class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class TrashTest {

    /**
     * Storage.
     */
    private Store store;

    /**
     * Date create.
     */
    private LocalDate createDate;

    /**
     * Date expiry.
     */
    private LocalDate expiryDate;

    /**
     * setUp.
     */
    @Before
    public void setUp() {
        store = new Trash("shop", 1);
    }

    /**
     * Sets dates.
     *
     * @param createDay int before
     * @param expiryDay int after
     */
    public void setDate(int createDay, int expiryDay) {
        LocalDate today = LocalDate.now();
        createDate = today.minusDays(createDay);
        expiryDate = today.plusDays(expiryDay);
    }

    /**
     * Test checkQuality in Trash.
     *
     * @throws Exception exception
     */
    @Test
    public void whenCheckQualityThenTrash() throws Exception {
        final int createDays = 15;
        final int expiryDays = -1;
        setDate(createDays, expiryDays);
        Food fruit = new Fruit("apple", createDate.toString(), expiryDate.toString());
        boolean actual = store.checkQuality(fruit);
        assertThat(actual, is(true));
    }

    /**
     * Test checkQuality in Trash.
     *
     * @throws StoreIsFullException exception
     */
    @Test
    public void whenCheckQualityThenReturnFalse() throws StoreIsFullException {
        final int createDays = 15;
        final int expiryDays = 15;
        setDate(createDays, expiryDays);
        Food fruit = new Fruit("apple", createDate.toString(), expiryDate.toString());
        boolean actual = store.checkQuality(fruit);
        assertThat(actual, is(false));
    }
}