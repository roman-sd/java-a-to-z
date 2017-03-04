package ru.sdroman.store.stores;

import org.junit.Before;
import org.junit.Test;
import ru.sdroman.store.exceptions.StoreIsFullException;
import ru.sdroman.store.foods.Fruit;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Store class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class ShopTest {

    /**
     * Storage.
     */
    private Store store;

    /**
     * Fruit.
     */
    private Fruit apple;

    /**
     * Date create.
     */
    private LocalDate createDate;

    /**
     * Date expiry.
     */
    private LocalDate expiryDate;

    /**
     * SetUp.
     */
    @Before
    public void setUp() {
        store = new Shop("shop", 1);
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
     * Test checkQuality() method.
     *
     * @throws StoreIsFullException exception
     */
    @Test
    public void whenCheckQualityThenReturnTrue() throws StoreIsFullException {
        final int createDays = 15;
        final int expiryDays = 15;
        setDate(createDays, expiryDays);
        apple = new Fruit("apple", createDate.toString(), expiryDate.toString());
        boolean actual = store.checkQuality(apple);
        store.addFood(apple);
        assertThat(actual, is(true));
    }

    /**
     * Test checkQuality() method.
     *
     * @throws Exception exception
     */
    @Test
    public void whenCheckQualityThenSetDiscount() throws Exception {
        final int createDays = 25;
        final int expiryDays = 1;
        final double price = 100;
        final double expected = 70;
        setDate(createDays, expiryDays);
        apple = new Fruit("apple", createDate.toString(), expiryDate.toString());
        apple.setPrice(price);
        store.checkQuality(apple);
        assertThat(apple.getPrice(), is(expected));
    }
}