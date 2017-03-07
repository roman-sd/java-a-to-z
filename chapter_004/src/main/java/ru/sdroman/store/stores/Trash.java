package ru.sdroman.store.stores;

import ru.sdroman.store.expiryDate.FoodExpiryDate;
import ru.sdroman.store.foods.Food;

/**
 * Class Trash.
 * @author sdroman
 * @since 03.17
 * @version 0.1
 */
public class Trash extends Store {

    /**
     * Constructs new Trash object.
     * @param trashName String
     * @param limit int
     */
    public Trash(String trashName, int limit) {
        super(trashName, limit);
    }

    /**
     * Check the quality of products.
     * @param food Food
     * @return boolean
     */
    @Override
    public boolean checkQuality(Food food) {
        FoodExpiryDate date = new FoodExpiryDate();
        double expiryDate = date.expiryDatePercent(food.getCreateDate(), food.getExpireDate());
        boolean isQuality = false;
        if (expiryDate < 0) {
            isQuality = true;
        }
        return isQuality;
    }
}
