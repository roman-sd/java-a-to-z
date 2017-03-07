package ru.sdroman.store.recyclingStorage.storage;

import org.junit.Before;
import org.junit.Test;
import ru.sdroman.store.exceptions.StoreIsFullException;
import ru.sdroman.store.foods.Food;
import ru.sdroman.store.foods.Fruit;
import ru.sdroman.store.stores.Store;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Storehouse class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */

public class StorehouseTest {

    /**
     * Storage.
     */
    private Store store;

    /**
     * Food.
     */
    private Food food;

    /**
     * SetUp.
     *
     * @throws Exception exception
     */
    @Before
    public void setUp() throws Exception {
        store = new Storehouse("Warehouse", 1);
    }

    /**
     * init.
     *
     * @param createDay int
     * @param expiryDay int
     */
    private void init(int createDay, int expiryDay) {
        LocalDate today = LocalDate.now();
        LocalDate createDate = today.minusDays(createDay);
        LocalDate expiryDate = today.plusDays(expiryDay);
        food = new Fruit("apple", createDate.toString(), expiryDate.toString());
    }

    /**
     * Test checkQuality() method.
     * @throws StoreIsFullException exception
     */
    @Test
    public void checkQuality() throws StoreIsFullException {
        final int createDays = 5;
        final int expiryDays = 30;
        init(createDays, expiryDays);
        boolean actual = store.checkQuality(food);
        assertThat(actual, is(true));
    }

}