package ru.sdroman.store.stores;

import org.junit.Before;
import org.junit.Test;
import ru.sdroman.store.exceptions.StoreIsFullException;
import ru.sdroman.store.foods.Food;
import ru.sdroman.store.foods.Fruit;
import ru.sdroman.store.foods.Vegetables;

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
public class StoreTest {

    /**
     * Store.
     */
    private Store store;

    /**
     * Food.
     */
    private Food apple;

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
     *
     * @throws Exception exception
     */
    @Before
    public void setUp() throws Exception {
        store = new Shop("shop", 1);
        final int createDays = 15;
        final int expiryDays = 15;
        LocalDate today = LocalDate.now();
        createDate = today.minusDays(createDays);
        expiryDate = today.plusDays(expiryDays);
        apple = new Fruit("apple", createDate.toString(), expiryDate.toString());
    }

    /**
     * Test getStoreName().
     */
    @Test
    public void whenGetStoreNameThenReturnName() {
        String expected = "shop";
        assertThat(store.getStoreName(), is(expected));
    }

    /**
     * Test AddFood() method.
     *
     * @throws StoreIsFullException exception
     */
    @Test
    public void whenAddThenAddFood() throws StoreIsFullException {
        store.addFood(apple);
        assertThat(store.getAllFoods()[0], is(apple));
    }

    /**
     * Test StoreIsFullException.
     *
     * @throws StoreIsFullException exception
     */
    @Test(expected = StoreIsFullException.class)
    public void whenAddThenException() throws StoreIsFullException {
        store.addFood(apple);
        Vegetables tomato = new Vegetables("tomato", createDate.toString(), expiryDate.toString());
        store.addFood(tomato);
    }

    /**
     * Test isFull() method.
     *
     * @throws StoreIsFullException exception
     */
    @Test
    public void whenStoreIsFullThenReturnTrue() throws StoreIsFullException {
        store.addFood(apple);
        assertThat(store.isFull(), is(true));
    }
}