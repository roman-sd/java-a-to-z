package ru.sdroman.store.stores;

import ru.sdroman.store.exceptions.StoreIsFullException;
import ru.sdroman.store.foods.Food;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class Store.
 */
public abstract class Store {

    /**
     * Products list.
     */
    private List<Food> foods;

    /**
     * Name.
     */
    private String storeName;

    /**
     * Products limit.
     */
    private int foodLimit;

    /**
     * Constructs new Store object.
     *
     * @param storeName String
     * @param foodLimit int
     */
    public Store(String storeName, int foodLimit) {
        this.foodLimit = foodLimit;
        this.storeName = storeName;
        this.foods = new ArrayList<>(foodLimit);
    }

    /**
     * Adds food in the store.
     *
     * @param food Food
     * @throws StoreIsFullException exception
     */
    public void addFood(Food food) throws StoreIsFullException {
        if (!this.isFull()) {
            this.foods.add(food);
        } else {
            throw new StoreIsFullException(getStoreName() + " is full");
        }
    }

    /**
     * Remove food from store.
     *
     * @param food Food
     * @return boolean
     */
    public boolean removeFood(Food food) {
        return this.foods.remove(food);
    }

    /**
     * Returns products list.
     *
     * @return Food[]
     */
    public List<Food> getFoods() {
        return this.foods;
    }

    /**
     * Returns name of store.
     *
     * @return String
     */
    public String getStoreName() {
        return this.storeName;
    }

    /**
     * isFull.
     *
     * @return boolean
     */
    public boolean isFull() {
        return this.foods.size() == this.foodLimit;
    }

    /**
     * Clear all products in the storage.
     */
    public void clear() {
        this.foods.clear();
    }

    /**
     * Check the quality of products.
     *
     * @param food Food
     * @return boolean
     */
    public abstract boolean checkQuality(Food food);
}
