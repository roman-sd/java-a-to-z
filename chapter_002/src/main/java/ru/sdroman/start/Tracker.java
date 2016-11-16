package ru.sdroman.start;

import ru.sdroman.models.Item;
import java.util.Random;

/**
 * class Tracker implements storage of items.
 */
public class Tracker {

    /**
     * Default initial capacity.
      */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     *Empty array used for items.
     */
    private Item[] items = new Item[DEFAULT_CAPACITY];

    /**
     * item position in array.
     */
    private int position = 0;

    /**
     * random for generate id.
     */
    private static final Random RN = new Random();

    /**
     * add new item into the array items.
     *
     * @param item Item, item to add.
     * @return new item.
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * edit item into the array items.
     *
     * @param item Item, item to edit.
     * @return true if success.
     */
    public boolean edit(Item item) {
        boolean result = false;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && items[index].getId().equals(item.getId())) {
                items[index] = item;
                result = true;
            }
        }
        return result;
    }

    /**
     * generate new Id.
     *
     * @return String id.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * remove item into the array items.
     *
     * @param item Item, item to remove.
     * @return true if success.
     */
    public boolean remove(Item item) {
        for (int index = 0; index < position; index++) {
            if (item.equals(items[index])) {
                System.arraycopy(items, index + 1, items, index, position - index - 1);
                items[--position] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * find item by name in array items.
     *
     * @param name String, name to search.
     * @return item Item.
     */
    public Item findByName(String name) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getName().equals(name)) {
                result = item;
            }
        }

        return result;
    }

    /**
     * find item by id in array items.
     *
     * @param id String, id to search.
     * @return item Items.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
            }
        }
        return result;
    }

    /**
     * get array items.
     *
     * @return array.
     */
    public Item[] getAll() {

        Item[] result = new Item[position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
}
