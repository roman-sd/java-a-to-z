package ru.sdroman.start;

import ru.sdroman.models.Comment;
import ru.sdroman.models.Item;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * class MenuTracker.
 */
public class MenuTracker {

    /**
     * input.
     */
    private Input input;

    /**
     * Tracker.
     */
    private Tracker tracker;

    /**
     * action's arrayList.
     */
    private List<UserAction> actionsList = new ArrayList<>();

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
        this.actionsList.add(new AddItem("Add the new item."));
        this.actionsList.add(new EditItem("Edit item."));
        this.actionsList.add(new RemoveItem("Remove item."));
        this.actionsList.add(new FindByName("Find by name."));
        this.actionsList.add(new FindById("Find by id."));
        this.actionsList.add(new AddCommentIntoItem("Add comment."));
        this.actionsList.add(new GetAllItems("Get all Items."));
    }

    /**
     * select menu key.
     *
     * @param key int
     */
    void select(int key) {
        this.actionsList.get(key - 1).execute(this.input, this.tracker);
    }

    /**
     * show menu.
     */
    public void show() {
        for (UserAction action : this.actionsList) {
            System.out.println(action.key() + "." + action.info());
        }
    }

    /**
     * Class AddItem.
     */
    private class AddItem extends BaseAction {

        /**
         * Constructs new AddItem action.
         *
         * @param name String
         */
        AddItem(String name) {
            super(name);
        }

        /**
         * return 1 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return actionsList.indexOf(this) + 1;
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
    }

    /**
     * class EditItem.
     */
    private class EditItem extends BaseAction {

        /**
         * Constructs new EditItem action.
         *
         * @param name String
         */
        EditItem(String name) {
            super(name);
        }

        /**
         * return 2 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return actionsList.indexOf(this) + 1;
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
                tracker.edit(oldItem.getId(), newItem);
            } catch (ItemNotFoundException inf) {
                System.err.println(inf.toString());
            }
        }
    }

    /**
     * class RemoveItem.
     */
    private class RemoveItem extends BaseAction {

        /**
         * Constructs new RemoveItem action.
         *
         * @param name String
         */
        RemoveItem(String name) {
            super(name);
        }

        /**
         * return 3 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return actionsList.indexOf(this) + 1;
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
    }

    /**
     * class FindByName.
     */
    private class FindByName extends BaseAction {

        /**
         * Constructs new FindByName action.
         *
         * @param name String
         */
        FindByName(String name) {
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
    }

    /**
     * class FindById.
     */
    private class FindById extends BaseAction {

        /**
         * Constructs new FindById action.
         *
         * @param name String
         */
        FindById(String name) {
            super(name);
        }

        /**
         * return 5 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return actionsList.indexOf(this) + 1;
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
    }

    /**
     * class AddCommentIntoItem.
     */
    private class AddCommentIntoItem extends BaseAction {

        /**
         * Constructs new AddCommentIntoItem action.
         *
         * @param name String
         */
        AddCommentIntoItem(String name) {
            super(name);
        }

        /**
         * return 6 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return actionsList.indexOf(this) + 1;
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
    }

    /**
     * class GetAllItem.
     */
    private class GetAllItems extends BaseAction {

        /**
         * Constructs new GetAllItems action.
         *
         * @param name String
         */
        GetAllItems(String name) {
            super(name);
        }

        /**
         * return 7 in menu.
         *
         * @return int
         */
        @Override
        public int key() {
            return actionsList.indexOf(this) + 1;
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
    }
}
