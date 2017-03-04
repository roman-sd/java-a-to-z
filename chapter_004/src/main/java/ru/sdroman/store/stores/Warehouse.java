package ru.sdroman.store.stores;

import ru.sdroman.store.ExpiryDate.FoodExpiryDate;
import ru.sdroman.store.foods.Food;

/**
 * Class Warehouse.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class Warehouse extends Store {

    /**
     * Percentage of expiry.
     */
    private static final double HIGH_SHELF_LIFE = 0.75;

    /**
     * Percentage of expiry.
     */
    private double high;

    /**
     * Constructs new Warehouse object.
     *
     * @param warehouseName String
     * @param limit         int
     */
    public Warehouse(String warehouseName, int limit) {
        super(warehouseName, limit);
        this.high = HIGH_SHELF_LIFE;
    }

    /**
     * Constructs new Warehouse object.
     *
     * @param warehouseName String
     * @param foodLimit     int
     * @param high          double
     */
    public Warehouse(String warehouseName, int foodLimit, double high) {
        super(warehouseName, foodLimit);
        this.high = high;
    }

    /**
     * Check the quality of products.
     *
     * @param food Food
     * @return boolean
     */
    @Override
    public boolean checkQuality(Food food) {
        FoodExpiryDate date = new FoodExpiryDate();
        double expiryDate = date.expiryDatePercent(food.getCreateDate(), food.getExpireDate());
        boolean isQuality = false;
        if (expiryDate > 0 && expiryDate > high) {
            isQuality = true;
        }
        return isQuality;
    }
}
