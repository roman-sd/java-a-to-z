package ru.sdroman.start;

import ru.sdroman.models.Comment;
import ru.sdroman.models.Item;

import java.text.SimpleDateFormat;
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
     * random for generate id.
     */
    private static final Random RN = new Random();
    /**
     * Empty array used for items.
     */
    private Item[] items = new Item[DEFAULT_CAPACITY];
    /**
     * item position in array.
     */
    private int position = 0;

    /**
     * add new item into the array items.
     *
     * @param item Item, item to add.
     * @return new item.
     */
    public Item add(Item item) {
        item.setTimeCreation(new SimpleDateFormat("dd/MM/yyyy HH:mm"));
        item.setId(generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * edit item into the array items.
     *
     * @param item Item, item to edit.
     * @throws ItemNotFoundException Exception
     */
    public void edit(Item item) {
        boolean isEdit = false;
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && items[index].getId().equals(item.getId())) {
                item.addComments(items[index].getComments());
                item.setTimeCreation(items[index].getTimeCreation());
                items[index] = item;
                isEdit = true;
            }
        }
        if (!isEdit) {
            throw new ItemNotFoundException("Item not found.");
        }
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
     * @throws ItemNotFoundException Exception
     */
    public void remove(Item item) {
        boolean isRemove = false;
        for (int index = 0; index < position; index++) {
            if (item.equals(items[index])) {
                System.arraycopy(items, index + 1, items, index, position - index - 1);
                items[--position] = null;
                isRemove = true;
            }
        }
        if (!isRemove) {
            throw new ItemNotFoundException("Item not found.");
        }
    }

    /**
     * find item by name in array items.
     *
     * @param name String
     * @return Item
     * @throws ItemNotFoundException Exception
     */
    public Item findByName(String name) throws ItemNotFoundException {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getName().equals(name)) {
                result = item;
            }
        }
        if (result != null) {
            return result;
        } else {
            throw new ItemNotFoundException("Item not found.");
        }
    }

    /**
     * find item by id in array items.
     *
     * @param id int
     * @return Item
     * @throws ItemNotFoundException Exception
     */
    public Item findById(String id) throws ItemNotFoundException {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
            }
        }
        if (result != null) {
            return result;
        } else {
            throw new ItemNotFoundException("Item not found.");
        }
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

    /**
     * add comment to item.
     *
     * @param comment Comment
     * @param id      String
     * @return item
     * @throws ItemNotFoundException Exception
     */
    public Item addComment(Comment comment, String id) {
        try {
            Item item = this.findById(id);
            item.addComment(comment);
            return item;
        } catch (ItemNotFoundException inf) {
            throw new ItemNotFoundException("Item not found.");
        }
    }
}
