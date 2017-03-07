package ru.sdroman.store.recyclingStorage.storage;

/**
 * Class FreezerWarehouse.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class FreezerWarehouse extends Storehouse {

    /**
     * Constructs new Warehouse object.
     *
     * @param warehouseName String
     * @param limit         int
     */
    public FreezerWarehouse(String warehouseName, int limit) {
        super(warehouseName, limit);
    }

    /**
     * Constructs new Warehouse object.
     *
     * @param warehouseName String
     * @param foodLimit     int
     * @param high          double
     */
    public FreezerWarehouse(String warehouseName, int foodLimit, double high) {
        super(warehouseName, foodLimit, high);
    }
}
