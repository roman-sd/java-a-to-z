package ru.sdroman.start;

import ru.sdroman.models.Comment;
import ru.sdroman.models.Item;

import java.util.Date;

/**
 * class MenuTracker.
 */
public class MenuTracker {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 7;
    /**
     * input.
     */
    private Input input;
    /**
     * Tracker.
     */
    private Tracker tracker;
    /**
     * actions array.
     */
    private UserAction[] actions = new UserAction[DEFAULT_CAPACITY];

    /**
     *
     */
    private int key = 0;

    /**
     * create new MenuTracker object.
     *
     * @param input   Input
     * @param tracker Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * fill actions array.
     */
    public void fillActions() {
        int count = 0;
        this.actions[count++] = new AddItem();
        this.actions[count++] = new EditItem();
        this.actions[count++] = new RemoveItem();
        this.actions[count++] = new FindByName();
        this.actions[count++] = new FindById();
        this.actions[count++] = new AddCommentIntoItem();
        this.actions[count] = new GetAllItems();
    }

    /**
     * select menu key.
     *
     * @param key int
     */
    void select(int key) {
        this.actions[key - 1].execute(this.input, this.tracker);
    }

    /**
     * show menu.
     */
    public void show() {
        for (UserAction action : actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
        key = 0;
    }

    /**
     * Class AddItem.
     */
    private class AddItem implements UserAction {

        /**
         * return 1 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return ++key;
        }

        /**
         * add new item.
         *
         * @param input   Input
         * @param tracker Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            Item newItem = new Item(input.ask("Name: "), input.ask("Description: "));
            tracker.add(newItem);
        }

        /**
         * return menu info.
         *
         * @return String
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

    /**
     * class EditItem.
     */
    private class EditItem implements UserAction {

        /**
         * return 2 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return ++key;
        }

        /**
         * edit item.
         *
         * @param input   Input
         * @param tracker Tracker
         * @throws ItemNotFoundException Exception
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            try {
                Item oldItem = tracker.findByName(input.ask("name to edit : "));
                Item newItem = new Item(input.ask("new name : "), input.ask("new description : "));
                newItem.setId(oldItem.getId());
                tracker.edit(newItem);
            } catch (ItemNotFoundException inf) {
                System.err.println(inf.toString());
            }

        }

        /**
         * return menu info.
         *
         * @return String
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Edit item.");
        }
    }

    /**
     * class RemoveItem.
     */
    private class RemoveItem implements UserAction {

        /**
         * return 3 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return ++key;
        }

        /**
         * remove item.
         *
         * @param input   Input
         * @param tracker Tracker
         * @throws ItemNotFoundException Exception
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            try {
                Item removeItem = tracker.findByName(input.ask("name to remove : "));
                tracker.remove(removeItem);
            } catch (ItemNotFoundException inf) {
                System.err.println(inf.toString());
            }
        }

        /**
         * return menu info.
         *
         * @return String
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Remove item.");
        }
    }

    /**
     * class FindByName.
     */
    private class FindByName implements UserAction {

        /**
         * return 4 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return ++key;
        }

        /**
         * find by name.
         *
         * @param input   Input
         * @param tracker Tracker
         * @throws ItemNotFoundException Exception
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            try {
                Item nameItem = tracker.findByName(input.ask("name : "));
                System.out.println(String.format("%s  %s   %s",
                        nameItem.getName(), nameItem.getDescription(), nameItem.getTimeCreation().format(new Date())));
                for (Comment comment : nameItem.getComments()) {
                    if (comment != null) {
                        System.out.println(comment.getComment());
                    }
                }
            } catch (ItemNotFoundException inf) {
                System.err.println(inf.toString());
            }
        }

        /**
         * return menu info.
         *
         * @return String
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find by name.");
        }
    }

    /**
     * class FindById.
     */
    private class FindById implements UserAction {

        /**
         * return 5 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return ++key;
        }

        /**
         * find by id.
         *
         * @param input   Input
         * @param tracker Tracker
         * @throws ItemNotFoundException Exception
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            try {
                Item idItem = tracker.findById(input.ask("id : "));
                System.out.println(String.format("%s   %s   %s",
                        idItem.getName(), idItem.getDescription(), idItem.getTimeCreation().format(new Date())));
                for (Comment comment : idItem.getComments()) {
                    if (comment != null) {
                        System.out.println(comment.getComment());
                    }
                }
            } catch (ItemNotFoundException inf) {
                System.err.println(inf.toString());
            }
        }

        /**
         * return menu info.
         *
         * @return String
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find by id.");
        }
    }

    /**
     * class AddCommentIntoItem.
     */
    private class AddCommentIntoItem implements UserAction {

        /**
         * return 6 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return ++key;
        }

        /**
         * add comment.
         *
         * @param input   Input
         * @param tracker Tracker
         * @throws ItemNotFoundException Exception
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            try {
                Item item = tracker.findByName(input.ask("name: "));
                Comment comment = new Comment(input.ask("comment: "));
                tracker.addComment(comment, item.getId());
            } catch (ItemNotFoundException inf) {
                System.err.println(inf.toString());
            }
        }

        /**
         * return menu info.
         *
         * @return String
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add comment ");
        }
    }

    /**
     * class GetAllItem.
     */
    private class GetAllItems implements UserAction {

        /**
         * return 7 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return ++key;
        }

        /**
         * get all items.
         *
         * @param input   Input
         * @param tracker Tracker
         */
        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("%s   %s   %s",
                        item.getName(), item.getDescription(), item.getTimeCreation().format(new Date())));
            }
        }

        /**
         * return menu info.
         *
         * @return String
         */
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Get all Items.");
        }
    }
}
