package ru.sdroman.store;

import ru.sdroman.store.exceptions.StoreIsFullException;
import ru.sdroman.store.foods.Food;
import ru.sdroman.store.stores.Shop;
import ru.sdroman.store.stores.Store;
import ru.sdroman.store.stores.Trash;
import ru.sdroman.store.stores.Warehouse;

/**
 * Class ControlQuality.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class ControlQuality {

    /**
     * Default capacity.
     */
    private static final int CAPACITY = 3;

    /**
     * Array of stores.
     */
    private Store[] stores;

    /**
     * Position in array.
     */
    private int position = 0;

    /**
     * Constructs new ControlQuality object.
     */
    public ControlQuality() {
        stores = new Store[CAPACITY];
    }

    /**
     * Fills array.
     */
    public void fillDefaultStore() {
        final int foodLimit = 3;
        addStore(new Shop("Shop", foodLimit));
        addStore(new Warehouse("Warehouse", foodLimit));
        addStore(new Trash("Trash", foodLimit));
    }

    /**
     * Array growth.
     */
    private void grow() {
        Store[] temp = new Store[this.position + 1];
        System.arraycopy(this.stores, 0, temp, 0, this.position);
        this.stores = temp;
    }

    /**
     * Adds new storage.
     *
     * @param store Store
     */
    public void addStore(Store store) {
        if (this.position == this.stores.length) {
            grow();
        }
        this.stores[this.position++] = store;
    }

    /**
     * Transfers products to stores.
     *
     * @param food Food
     * @throws StoreIsFullException exception
     */
    public void foodTransfer(Food food) throws StoreIsFullException {
        for (Store store : stores) {
            if (store != null && store.checkQuality(food)) {
                store.addFood(food);
                break;
            }
        }
    }

    /**
     * Returns array of stores.
     *
     * @return Store[]
     */
    public Store[] getStores() {
        return stores;
    }
}
