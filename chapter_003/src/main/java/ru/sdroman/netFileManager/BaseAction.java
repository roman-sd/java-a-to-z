package ru.sdroman.netFileManager;

import java.io.IOException;

/**
 * abstract Class BaseAction.
 * @author sdroma
 *
 */
abstract class BaseAction implements UserAction {

    /**
     * Action name.
     */
    private String name;

    /**
     * Constructs new BaseAction object.
     * @param name String
     */
    BaseAction(String name) {
        this.name = name;
    }

    /**
     * execute.
     * @param line String
     * @throws IOException exception
      */
    public abstract void execute(String line) throws IOException;

    /**
     * Info about action.
     * @return String
     */
    public String info() {
        return String.format("%s", this.name);
    }
}
