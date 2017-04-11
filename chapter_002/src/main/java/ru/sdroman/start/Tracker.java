package ru.sdroman.start;

import ru.sdroman.models.Comment;
import ru.sdroman.models.Item;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class Tracker implements storage of items.
 */
public class Tracker {

    /**
     * random for generate id.
     */
    private static final Random RN = new Random();

    /**
     * ArrayList used for items.
     */
    private List<Item> items = new ArrayList<>();

    /**
     * add new item into the array items.
     *
     * @param item Item, item to add.
     * @return new item.
     */
    public Item add(Item item) {
        item.setTimeCreation(new SimpleDateFormat("dd/MM/yyyy HH:mm"));
        item.setId(generateId());
        this.items.add(item);
        return item;
    }

    /**
     * edit item into the array items.
     *
     * @param id   String
     * @param item Item, item to edit.
     * @throws ItemNotFoundException Exception
     */
    public void edit(String id, Item item) {
        boolean isEdit = false;
        for (Item current : this.items) {
            if (id.equals(current.getId())) {
                current.setName(item.getName());
                current.setDescription(item.getDescription());
                //current.setId(item.getId());
                current.addComments(item.getComments());
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
        if (!this.items.remove(item)) {
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
        for (Item item : this.items) {
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
        for (Item item : this.items) {
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
    public List<Item> getAll() {
        return this.items;
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
            Item item = findById(id);
            item.addComment(comment);
            return item;
        } catch (ItemNotFoundException inf) {
            throw new ItemNotFoundException("Item not found.");
        }
    }
}
