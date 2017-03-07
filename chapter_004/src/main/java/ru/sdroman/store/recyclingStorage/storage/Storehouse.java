package ru.sdroman.store.recyclingStorage.storage;

import ru.sdroman.store.foods.Food;
import ru.sdroman.store.stores.Warehouse;

/**
 * Class Storehouse.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class Storehouse extends Warehouse {

    /**
     * Constructs new Warehouse object.
     *
     * @param warehouseName String
     * @param limit         int
     */
    public Storehouse(String warehouseName, int limit) {
        super(warehouseName, limit);
    }

    /**
     * Constructs new Warehouse object.
     *
     * @param warehouseName String
     * @param foodLimit     int
     * @param high          double
     */
    public Storehouse(String warehouseName, int foodLimit, double high) {
        super(warehouseName, foodLimit, high);
    }

    /**
     * Check the quality of products.
     *
     * @param food Food
     * @return boolean
     */
    @Override
    public boolean checkQuality(Food food) {
        return super.checkQuality(food);
    }
}
