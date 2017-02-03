package ru.sdroman.netFileManager;

/**
 * Class Command.
 * @author sdroman
 */
public class Command {

    /**
     * command.
     */
    private String action;

    /**
     * parameter.
     */
    private String param;

    /**
     * Constructs new Command object.
     * @param msg String
     */
    public Command(String msg) {
        String[] res = msg.trim().split("\\s+");
        int count = 0;
        this.action = res[count++];
        this.param = res.length > 1 ? res[count] : "";
    }

    /**
     * Gets command.
     * @return String
     */
    public String getAction() {
        return this.action;
    }

    /**
     * Gets parameter.
     * @return String
     */
    public String getParam() {
        return this.param;
    }
}
