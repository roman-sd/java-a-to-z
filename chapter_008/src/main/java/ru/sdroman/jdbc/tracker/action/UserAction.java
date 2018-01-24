package ru.sdroman.jdbc.tracker.action;

import ru.sdroman.jdbc.tracker.Tracker;
import ru.sdroman.jdbc.tracker.input.Input;

/**
 * Interface UserAction.
 */
public interface UserAction {

    /**
     * Returns action key.
     *
     * @return int
     */
    int key();

    /**
     * Execute.
     *
     * @param input   Input
     * @param tracker Tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Menu info.
     *
     * @return String
     */
    String info();
}
