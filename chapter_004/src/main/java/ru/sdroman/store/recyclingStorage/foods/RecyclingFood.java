package ru.sdroman.store.recyclingStorage.foods;

import ru.sdroman.store.foods.Food;

/**
 * Class RecyclingFood.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class RecyclingFood extends Food {

    /**
     * CanReproduct.
     */
    private boolean canReproduct;

    /**
     * Constructs new Food object.
     *
     * @param name         String
     * @param createDate   String
     * @param expiryDate   String
     * @param canReproduct boolean
     */
    public RecyclingFood(String name, String createDate, String expiryDate, boolean canReproduct) {
        super(name, createDate, expiryDate);
        this.canReproduct = canReproduct;
    }

    /**
     * Gets canReproduct.
     *
     * @return boolean
     */
    public boolean getCanReproduct() {
        return canReproduct;
    }
}
