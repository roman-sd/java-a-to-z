package ru.sdroman.store;

import org.junit.Before;
import org.junit.Test;
import ru.sdroman.store.exceptions.StoreIsFullException;
import ru.sdroman.store.foods.Food;
import ru.sdroman.store.foods.Fruit;
import ru.sdroman.store.foods.Vegetables;
import ru.sdroman.store.stores.Shop;
import ru.sdroman.store.stores.Store;
import ru.sdroman.store.stores.Trash;
import ru.sdroman.store.stores.Warehouse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test ControlQuality class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class ControlQualityTest {

    /**
     * ControlQuality.
     */
    private ControlQuality controlQuality;

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
        controlQuality = new ControlQuality();
    }

    /**
     * Test addStore() method.
     */
    @Test
    public void whenAddThenAddNewStore() {
        final int foodLimit = 3;
        controlQuality.fillDefaultStore();
        Shop testStore = new Shop("testShop", foodLimit);
        controlQuality.addStore(testStore);
        Store[] actual = controlQuality.getStores();
        final int index = 3;
        assertThat(actual[index], is(testStore));
    }

    /**
     * Run tests.
     *
     * @param store Store
     * @param food  food
     * @throws StoreIsFullException exception
     */
    private void run(Store store, Food food) throws StoreIsFullException {
        controlQuality.addStore(store);
        controlQuality.foodTransfer(food);
        Store[] stores = controlQuality.getStores();
        Food actualFood = stores[0].getFoods().iterator().next();
        assertThat(actualFood, is(food));
    }

    /**
     * Sets date.
     * @param createDay int
     * @param expiryDay int
     */
    private void init(int createDay, int expiryDay) {
        LocalDate today = LocalDate.now();
        createDate = today.minusDays(createDay);
        expiryDate = today.plusDays(expiryDay);
    }

    /**
     * Test add to Shop.
     *
     * @throws StoreIsFullException exception
     */
    @Test
    public void whenAddFoodThenTransferAtShop() throws StoreIsFullException {
        final int createDays = 15;
        final int expiryDays = 15;
        init(createDays, expiryDays);
        Fruit apple = new Fruit("apple", createDate.toString(), expiryDate.toString());
        Store shop = new Shop("shop", 1);
        run(shop, apple);
    }

    /**
     * Test add to Warehouse.
     *
     * @throws StoreIsFullException exception
     */
    @Test
    public void whenAddFoodThenTransferWarehouse() throws StoreIsFullException {
        final int createDays = 1;
        final int expiryDays = 15;
        init(createDays, expiryDays);
        Food tomato = new Vegetables("tomato", createDate.toString(), expiryDate.toString());
        Store warehouse = new Warehouse("warehouse", 1);
        run(warehouse, tomato);
    }

    /**
     * Test add to Trash.
     *
     * @throws StoreIsFullException exception
     */
    @Test
    public void whenAddFoodThenTransferTrash() throws StoreIsFullException {
        final int createDays = 15;
        final int expiryDays = -1;
        init(createDays, expiryDays);
        Food tomato = new Vegetables("tomato", createDate.toString(), expiryDate.toString());
        Store trash = new Trash("Trash", 1);
        run(trash, tomato);
    }

    /**
     * Test grow() method.
     */
    @Test
    public void whenAddStoreThenArrayGrowth() {
        controlQuality.fillDefaultStore();
        int lengthBeforeAdd = controlQuality.getStores().length;
        controlQuality.addStore(new Shop("testShop", 1));
        int lengthAfterAdd = controlQuality.getStores().length;
        assertThat(lengthBeforeAdd + 1, is(lengthAfterAdd));
    }

    /**
     * Test StoreIsFullException.
     *
     * @throws StoreIsFullException exception
     */
    @Test(expected = StoreIsFullException.class)
    public void whenStoreIsFullThenException() throws StoreIsFullException {
        final int createDays = 15;
        final int expiryDays = 15;
        init(createDays, expiryDays);
        controlQuality.addStore(new Shop("Shop", 1));
        Fruit apple = new Fruit("apple", createDate.toString(), expiryDate.toString());
        Vegetables tomato = new Vegetables("tomato", createDate.toString(), expiryDate.toString());
        controlQuality.foodTransfer(apple);
        controlQuality.foodTransfer(tomato);
    }

    /**
     * Test resort() method.
     * @throws StoreIsFullException exception
     */
    @Test
    public void whenResortThenResort() throws StoreIsFullException {
        final int createDays = 15;
        final int expiryDays = 15;
        final int storeIndex = 2;
        init(createDays, expiryDays);
        Food apple = new Fruit("apple", createDate.toString(), expiryDate.toString());
        controlQuality.fillDefaultStore();
        controlQuality.foodTransfer(apple);
        apple.setExpiryDate((LocalDate.now().minusDays(1)).toString());
        controlQuality.resort();
        List<Food> expected = new ArrayList<>();
        expected.add(apple);
        assertThat(controlQuality.getStores()[storeIndex].getFoods(), is(expected));
    }
}
