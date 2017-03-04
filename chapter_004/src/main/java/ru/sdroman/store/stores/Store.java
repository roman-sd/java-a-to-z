package ru.sdroman.store.stores;

import ru.sdroman.store.exceptions.StoreIsFullException;
import ru.sdroman.store.foods.Food;

/**
 * Abstract class Store.
 */
public abstract class Store {

    /**
     * Array of products.
     */
    private Food[] foods;

    /**
     * Position in array.
     */
    private int position = 0;

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
        this.foods = new Food[foodLimit];
    }

    /**
     * Adds food in the store.
     *
     * @param food Food
     * @throws StoreIsFullException exception
     */
    public void addFood(Food food) throws StoreIsFullException {
        if (!isFull()) {
            this.foods[position++] = food;
        } else {
            throw new StoreIsFullException(getStoreName() + " is full");
        }
    }

    /**
     * Returns array of products.
     *
     * @return Food[]
     */
    public Food[] getAllFoods() {
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
        return this.position == foodLimit;
    }

    /**
     * Clear all products in the storage.
     */
    public void clear() {
        this.foods = null;
        System.out.println();
    }

    /**
     * Check the quality of products.
     *
     * @param food Food
     * @return boolean
     */
    public abstract boolean checkQuality(Food food);
}
