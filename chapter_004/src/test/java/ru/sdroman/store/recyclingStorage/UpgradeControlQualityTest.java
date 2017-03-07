package ru.sdroman.store.recyclingStorage;

import org.junit.Before;
import org.junit.Test;
import ru.sdroman.store.exceptions.StoreIsFullException;
import ru.sdroman.store.foods.Food;
import ru.sdroman.store.foods.Fruit;
import ru.sdroman.store.recyclingStorage.foods.RVegetables;
import ru.sdroman.store.recyclingStorage.foods.RecyclingFood;
import ru.sdroman.store.stores.Store;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test UpgradeControlQuality class.
 * @author sdroman
 * @since 03.2017
 * @version 0.1
 */
public class UpgradeControlQualityTest {

    /**
     * UpgradeControlQuality.
     */
    private UpgradeControlQuality control;

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
     * @throws StoreIsFullException exception
     */
    @Before
    public void setUp() throws StoreIsFullException {
        control = new UpgradeControlQuality();
    }

    /**
     * Sets date.
     */
    private void initDate() {
        final int createDays = 15;
        final int expiryDays = -1;
        LocalDate today = LocalDate.now();
        createDate = today.minusDays(createDays);
        expiryDate = today.plusDays(expiryDays);
    }

    /**
     * Test foodTransfer() method in UpgradeControlQuality class.
     * @throws StoreIsFullException exception
     */
    @Test
    public void whenAddRecyclingFoodThenTransferUpgradeControlQuality() throws StoreIsFullException {
        initDate();
        final int storePosition = 4;
        RecyclingFood fruit = new RecyclingFood("apple", createDate.toString(), expiryDate.toString(), true);
        control.foodTransfer(fruit);
        Store[] stores = control.getStores();
        Food actualFood = stores[storePosition].getAllFoods()[0];
        assertThat(actualFood, is(fruit));
    }

    /**
     * Test foodTransfer() method in UpgradeControlQuality class.
     * @throws StoreIsFullException exception
     */
    @Test
    public void whenAddFoodThenTransferTrash() throws StoreIsFullException {
        initDate();
        final int storePosition = 2;
        Food food = new Fruit("apple", createDate.toString(), expiryDate.toString());
        control.foodTransfer(food);
        Store[] stores = control.getStores();
        Food actualFood = stores[storePosition].getAllFoods()[0];
        assertThat(actualFood, is(food));
    }

    /**
     * Test foodTransfer() method in UpgradeControlQuality class.
     */
    @Test
    public void whenAddFoodThenTransferShop() {
        final int storeIndex = 4;
        Store[] stores = control.getStores();
        assertThat(stores[storeIndex].getStoreName(), is("reStorage"));
    }

    /**
     * Test foodTransfer() method in UpgradeControlQuality class.
     */
    @Test
    public void whenAddVegetablesThenAddFreezerWarehouse() {
        final int storeIndex = 5;
        Store[] stores = control.getStores();
        assertThat(stores[storeIndex].getStoreName(), is("Freezer"));
    }

    /**
     * Test foodTransfer method for Vegetables.
     * @throws StoreIsFullException exception
     */
    @Test
    public void whenAddVegetablesThenAddFoodInFreezerWarehouse() throws StoreIsFullException {
        final int freezerIndex = 5;
        final int createDays = 1;
        final int expiryDays = 50;
        LocalDate today = LocalDate.now();
        LocalDate createDate = today.plusDays(createDays);
        LocalDate expiryDate = today.minusDays(expiryDays);
        RVegetables vegetables = new RVegetables("veg", createDate.toString(), expiryDate.toString(), true);
        control.foodTransfer(vegetables);
        Store[] stores = control.getStores();
        assertThat(stores[freezerIndex].getAllFoods()[0], is(vegetables));
    }

}