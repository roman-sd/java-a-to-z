package ru.sdroman.jdbc.tracker;

/**
 * Abstract class BaseAction.
 */
public abstract class BaseAction implements UserAction {

    /**
     * Action's info.
     */
    private String name;

    /**
     * Constructs new action.
     *
     * @param name String
     */
    public BaseAction(String name) {
        this.name = name;
    }

    /**
     * Menu key.
     *
     * @return int
     */
    public abstract int key();

    /**
     * Execute.
     *
     * @param input   Input
     * @param tracker Tracker
     */
    public abstract void execute(Input input, Tracker tracker);

    /**
     * return menu info.
     *
     * @return String
     */
    public String info() {
        return String.format("%s", this.name);
    }
}
