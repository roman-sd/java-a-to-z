package ru.sdroman.jdbc.tracker;

import ru.sdroman.jdbc.tracker.input.Input;
import ru.sdroman.jdbc.tracker.input.ValidateInput;

/**
 * Class StartUI.
 */
public class StartUI {

    /**
     * Input.
     */
    private Input input;

    /**
     * Constructs a new StartUI object.
     *
     * @param input Input
     */
    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Main.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ValidateInput();
        new StartUI(input).init(tracker);
    }

    /**
     * Initializes menu.
     *
     * @param tracker Tracker
     */
    public void init(Tracker tracker) {
        if (tracker.getConnection()) {
            if (tracker.isEmpty()) {
                tracker.initDataBase();
            }
            MenuTracker menu = new MenuTracker(this.input, tracker);
            final int[] range = new int[]{1, 2, 3, 4, 5, 6, 7};
            menu.fillActions();
            do {
                menu.printMenu();
                menu.select(input.ask("select: ", range));
            } while (!"y".equals(this.input.ask("Exit? y/n ")));
            tracker.closeConnection();
        } else {
            System.out.println("getLogger");
        }
    }
}
