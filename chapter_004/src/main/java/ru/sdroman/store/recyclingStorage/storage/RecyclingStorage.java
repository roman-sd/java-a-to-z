package ru.sdroman.store.recyclingStorage.storage;

import ru.sdroman.store.recyclingStorage.foods.RecyclingFood;
import ru.sdroman.store.stores.Trash;

/**
 * Class RecyclingStorage.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class RecyclingStorage extends Trash {

    /**
     * Constructs new ProcessingFoodStorage object.
     *
     * @param trashName String
     * @param limit     int
     */
    public RecyclingStorage(String trashName, int limit) {
        super(trashName, limit);
    }


    /**
     * Returns true if food processing is enabled.
     *
     * @param rFood AdvanceFood
     * @return boolean
     */
    public boolean checkQuality(RecyclingFood rFood) {
        return rFood.getCanReproduct() && super.checkQuality(rFood);
    }
}
