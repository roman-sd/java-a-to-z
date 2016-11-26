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
     * Work with menu.
     *
     * @param tracker Tracker
     */
    public void init(Tracker tracker) {
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("select : "));
            menu.select(key);
        } while (!"y".equals(this.input.ask("Exit? y/n ")));
    }

    /**
     * Start program. method main().
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        new StartUI(input).init(tracker);

    }
}
