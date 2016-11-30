package ru.sdroman.start;

/**
 * class StartUI. Starts the program.
 */
public class StartUI {

    /**
     * input.
     */
    private Input input;

    /**
     * Create a new StartUI object.
     *
     * @param input Input
     */
    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Start program. method main().
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ValidateInput();
        new StartUI(input).init(tracker);
    }

    /**
     * Work with menu.
     *
     * @param tracker Tracker
     */
    public void init(Tracker tracker) {
        MenuTracker menu = new MenuTracker(this.input, tracker);
        final int[] range = new int[]{1, 2, 3, 4, 5, 6, 7};
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("select: ", range));
        } while (!"y".equals(this.input.ask("Exit? y/n ")));
    }
}
