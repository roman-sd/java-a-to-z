package ru.sdroman.start;

/**
 * Interface UserAction.
 */
public interface UserAction {

    /**
     * return action key.
     *
     * @return int
     */
    int key();

    /**
     * execute.
     *
     * @param input   Input
     * @param tracker Tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * menu info.
     *
     * @return String
     */
    String info();
}
