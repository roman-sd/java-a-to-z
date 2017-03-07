package ru.sdroman.store.stores;

import ru.sdroman.store.expiryDate.FoodExpiryDate;
import ru.sdroman.store.foods.Food;

/**
 * Class Shop.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class Shop extends Store {

    /**
     * Percentage of expiry.
     */
    private static final double LOW_SHELF_LIFE = 0.25;

    /**
     * Percentage of expiry.
     */
    private static final double HIGH_SHELF_LIFE = 0.75;

    /**
     * Discount.
     */
    private static final double DISCOUNT = 0.3;

    /**
     * Percentage of expiry.
     */
    private double low;

    /**
     * Percentage of expiry.
     */
    private double high;

    /**
     * Discount.
     */
    private double discount;

    /**
     * Constructs new Shop object.
     *
     * @param shopName  String
     * @param foodLimit int
     */
    public Shop(String shopName, int foodLimit) {
        super(shopName, foodLimit);
        this.low = LOW_SHELF_LIFE;
        this.high = HIGH_SHELF_LIFE;
        this.discount = DISCOUNT;
    }

    /**
     * Constricts new Shop object.
     *
     * @param shopName  String
     * @param foodLimit int
     * @param low       double
     * @param high      double
     * @param discount  double
     */
    public Shop(String shopName, int foodLimit, double low, double high, double discount) {
        this(shopName, foodLimit);
        this.low = low;
        this.high = high;
        this.discount = discount;
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
        if (expiryDate >= low && expiryDate <= high) {
            isQuality = true;
        } else {
            if (expiryDate <= low && expiryDate > 0) {
                food.setDiscount(discount);
                isQuality = true;
            }
        }
        return isQuality;
    }
}
