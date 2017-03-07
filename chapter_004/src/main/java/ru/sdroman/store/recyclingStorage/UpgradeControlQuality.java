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
 * Class UpgradeControlQuality class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class UpgradeControlQuality extends ControlQuality {

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
    public UpgradeControlQuality() {
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
     * @throws StoreIsFullException exception
     */
    public void foodTransfer(RVegetables vegan) throws StoreIsFullException {
        if (freezer.checkQuality(vegan)) {
            freezer.addFood(vegan);
        }
    }

   /* public static void main(String[] args) throws StoreIsFullException {
        UpgradeControlQuality control = new UpgradeControlQuality();

        RecyclingFood apple = new RFruit("apple", "2017-02-01", "2017-04-28", true);
        RecyclingFood banana = new RFruit("banana", "2017-02-01", "2017-02-28", false);
        RecyclingFood tomato = new RVegetables("tomato", "2017-03-01", "2017-04-28", true);
        RecyclingFood potato = new RVegetables("potato", "2017-03-01", "2017-04-28", false);
        RecyclingFood pineapple = new RFruit("pineapple", "2017-02-01", "2017-02-28", true);
        RVegetables vegetables = new RVegetables("vegan", "2017-03-01", "2017-05-01", true);

        control.foodTransfer(apple);
        control.foodTransfer(banana);
        control.foodTransfer(pineapple);
        control.foodTransfer(potato);
        control.foodTransfer(tomato);
        control.foodTransfer(vegetables);

        Store[] stores = control.getStores();
        Food[] foods;

        for (Store st : stores) {
            foods = st.getAllFoods();
            System.out.println(st.getStoreName());
            for (Food aFood : foods) {
                System.out.println(aFood);
            }
        }
    }*/
}
