package ru.sdroman.store.stores;

import org.junit.Before;
import org.junit.Test;
import ru.sdroman.store.foods.Food;
import ru.sdroman.store.foods.Fruit;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Warehouse class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class WarehouseTest {

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
        store = new Warehouse("Warehouse", 1);
    }

    /**
     * init.
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
     * Test checkQuality in Warehouse.
     *
     * @throws Exception exception
     */
    @Test
    public void whenCheckQualityThenWarehouseTrue() throws Exception {
        final int createDays = 1;
        final int expiryDays = 30;
        init(createDays, expiryDays);
        boolean actual = store.checkQuality(food);
        assertThat(actual, is(true));
    }

    /**
     * Test checkQuality in Warehouse.
     *
     * @throws Exception exception
     */
    @Test
    public void whenCheckQualityThenWarehouseFalse() throws Exception {
        final int createDays = 1;
        final int expiryDays = 1;
        init(createDays, expiryDays);
        boolean actual = store.checkQuality(food);
        assertThat(actual, is(false));
    }
}