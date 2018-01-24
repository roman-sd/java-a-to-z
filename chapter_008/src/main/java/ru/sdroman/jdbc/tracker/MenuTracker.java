package ru.sdroman.jdbc.tracker;

import ru.sdroman.jdbc.tracker.action.BaseAction;
import ru.sdroman.jdbc.tracker.action.UserAction;
import ru.sdroman.jdbc.tracker.input.Input;
import ru.sdroman.jdbc.tracker.models.Comment;
import ru.sdroman.jdbc.tracker.models.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Class MenuTracker.
 */
public class MenuTracker {

    /**
     * Input.
     */
    private Input input;

    /**
     * Tracker.
     */
    private Tracker tracker;

    /**
     * Action's list.
     */
    private List<UserAction> actionsList = new ArrayList<>();

    /**
     * Constructs a new MenuTracker object.
     *
     * @param input   Input
     * @param tracker Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Fills actions list.
     */
    public void fillActions() {
        this.actionsList.add(new AddItem("Add item."));
        this.actionsList.add(new EditItem("Edit item."));
        this.actionsList.add(new RemoveItem("Remove item."));
        this.actionsList.add(new FindById("Find by id."));
        this.actionsList.add(new AddComment("Add comment."));
        this.actionsList.add(new GetItemsList("Get all Items."));
    }

    /**
     * Selects menu key.
     *
     * @param key int
     */
    void select(int key) {
        this.actionsList.get(key - 1).execute(this.input, this.tracker);
    }

    /**
     * Prints menu.
     */
    public void printMenu() {
        for (UserAction action : this.actionsList) {
            System.out.println(action.key() + "." + action.info());
        }
    }

    /**
     * Checks item for null.
     *
     * @param item Item
     * @return true, if item != null
     */
    private boolean checkItem(Item item) {
        boolean result = true;
        if (item == null) {
            System.out.println("id not found");
            result = false;
        }
        return result;
    }

    /**
     * Class AddItem.
     */
    private class AddItem extends BaseAction {

        /**
         * Constructs a new AddItem action.
         *
         * @param name String
         */
        AddItem(String name) {
            super(name);
        }

        /**
         * Returns 1 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return actionsList.indexOf(this) + 1;
        }

        /**
         * Adds new item.
         *
         * @param input   Input
         * @param tracker Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = new Item(input.ask("name: "), input.ask("description: "));
            tracker.addItem(item);
        }
    }

    /**
     * Class EditItem.
     */
    private class EditItem extends BaseAction {

        /**
         * Constructs a new EditItem action.
         *
         * @param name String
         */
        EditItem(String name) {
            super(name);
        }

        /**
         * Returns 2 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return actionsList.indexOf(this) + 1;
        }

        /**
         * Modifies an element.
         *
         * @param input   Input
         * @param tracker Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            Item oldItem = tracker.findById(input.ask("id to edit : "));
            if (checkItem(oldItem)) {
                Item newItem = new Item(input.ask("new name : "), input.ask("new description : "));
                tracker.updateItem(oldItem, newItem);
            }
        }
    }

    /**
     * Class RemoveItem.
     */
    private class RemoveItem extends BaseAction {

        /**
         * Constructs a new RemoveItem action.
         *
         * @param name String
         */
        RemoveItem(String name) {
            super(name);
        }

        /**
         * Returns 3 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return actionsList.indexOf(this) + 1;
        }

        /**
         * Removes item.
         *
         * @param input   Input
         * @param tracker Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("id to remove : "));
            if (checkItem(item)) {
                tracker.removeItem(item);
            }
        }
    }

    /**
     * Class FindById.
     */
    private class FindById extends BaseAction {

        /**
         * Constructs a new FindById action.
         *
         * @param name String
         */
        FindById(String name) {
            super(name);
        }

        /**
         * return 4 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return actionsList.indexOf(this) + 1;
        }

        /**
         * Finds item by id.
         *
         * @param input   Input
         * @param tracker Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("id: "));
            if (checkItem(item)) {
                System.out.println(item);
            }
        }
    }

    /**
     * Class AddComment.
     */
    private class AddComment extends BaseAction {

        /**
         * Constructs a new AddComment action.
         *
         * @param name String
         */
        AddComment(String name) {
            super(name);
        }

        /**
         * ReturnS 5 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return actionsList.indexOf(this) + 1;
        }

        /**
         * Adds comment.
         *
         * @param input   Input
         * @param tracker Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            Item item = tracker.findById(input.ask("id: "));
            if (checkItem(item)) {
                Comment comment = new Comment(input.ask("comment: "));
                tracker.addComment(comment, item);
            }
        }
    }

    /**
     * Class GetItemList.
     */
    private class GetItemsList extends BaseAction {

        /**
         * Constructs a new GetItemsList action.
         *
         * @param name String
         */
        GetItemsList(String name) {
            super(name);
        }

        /**
         * Returns 6 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return actionsList.indexOf(this) + 1;
        }

        /**
         * Gets all items.
         *
         * @param input   Input
         * @param tracker Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.itemsList()) {
                System.out.println(item);
            }
        }
    }
}
