package ru.sdroman.store.recyclingStorage;

import ru.sdroman.store.ControlQuality;
import ru.sdroman.store.exceptions.StoreIsFullException;
import ru.sdroman.store.recyclingStorage.foods.RVegetables;
import ru.sdroman.store.recyclingStorage.foods.RecyclingFood;
import ru.sdroman.store.recyclingStorage.storage.FreezerWarehouse;
import ru.sdroman.store.recyclingStorage.storage.RecyclingStorage;
import ru.sdroman.store.recyclingStorage.storage.Storehouse;
import ru.sdroman.store.stores.Store;

/**
 * Class UpdateControlQuality class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class UpdateControlQuality extends ControlQuality {

    /**
     * food limit.
     */
    private static final int LIMIT = 3;

    /**
     * RecyclingStorage.
     */
    private RecyclingStorage reStorage;

    /**
     * FreezerWarehouse.
     */
    private FreezerWarehouse freezer;

    /**
     * Constructs new UpgradeControlStorage object.
     */
    public UpdateControlQuality() {
        super();
        this.fillDefaultStore();
        this.addStore(new Storehouse("Storehouse", LIMIT));
        reStorage = new RecyclingStorage("reStorage", LIMIT);
        this.addStore(reStorage);
        freezer = new FreezerWarehouse("Freezer", LIMIT);
        this.addStore(freezer);
    }

    /**
     * Transfers products to stores.
     *
     * @param food RecyclingFood
     * @throws StoreIsFullException StoreFullException
     */
    public void foodTransfer(RecyclingFood food) throws StoreIsFullException {
        if (food.getCanReproduct() && reStorage.checkQuality(food)) {
            reStorage.addFood(food);
        } else {
            for (Store store : this.getStores()) {
                if (store != null && !store.isFull() && store.checkQuality(food)) {
                    store.addFood(food);
                    break;
                }
            }
        }
    }

    /**
     * FoodTransfer for vegetables.
     *
     * @param vegan RVegetables
     * @return boolean
     * @throws StoreIsFullException exception
     */
    public boolean foodTransfer(RVegetables vegan) throws StoreIsFullException {
        boolean done = false;
        if (freezer.checkQuality(vegan)) {
            done = true;
            freezer.addFood(vegan);
        }
        return done;
    }
}
