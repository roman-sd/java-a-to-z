package ru.sdroman.store.recyclingStorage.foods;

/**
 * Class RVegetables.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class RVegetables extends RecyclingFood {

    /**
     * Constructs new Food object.
     *
     * @param name         String
     * @param createDate   String
     * @param expiryDate   String
     * @param canReproduct boolean
     */
    public RVegetables(String name, String createDate, String expiryDate, boolean canReproduct) {
        super(name, createDate, expiryDate, canReproduct);
    }
}
