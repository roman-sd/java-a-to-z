package ru.sdroman.findFiles;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Class Menu.
 *
 * @author sdroman
 * @version 0.1
 * @since 13.02.17
 */
public class Menu {

    /**
     * 1.
     */
    private static final int FIRST_KEY = 1;

    /**
     * 3.
     */
    private static final int THIRD_KEY = 3;

    /**
     * 4.
     */
    private static final int FOURTH_KEY = 4;

    /**
     * 6.
     */
    private static final int SIXTH_KEY = 6;

    /**
     * Array of keys.
     */
    private String[] args;

    /**
     * Constructs new Menu objects.
     *
     * @param args String
     */
    Menu(String[] args) {
        this.args = args;
    }

    /**
     * find.
     *
     * @return boolean
     * @throws IOException exception
     */
    public boolean find() throws IOException {
        boolean result = true;
        Pattern pattern;
        ValidateKey validator = new ValidateKey(this.args);
        if (validator.valid()) {
            if ("-f".equalsIgnoreCase(this.args[FOURTH_KEY])
                    || "-r".equalsIgnoreCase(this.args[FOURTH_KEY])) {
                pattern = Pattern.compile(this.args[THIRD_KEY]);
                new Finder(pattern, this.args[SIXTH_KEY]).isFound(this.args[FIRST_KEY]);
            } else {
                if ("-m".equalsIgnoreCase(this.args[FOURTH_KEY])) {
                    String tmpStr = this.args[THIRD_KEY];
                    tmpStr = tmpStr.replace("?", ".?");
                    tmpStr = tmpStr.replace("*", ".*");
                    pattern = Pattern.compile(tmpStr);
                    new Finder(pattern, this.args[SIXTH_KEY]).isFound(this.args[FIRST_KEY]);
                }
            }
        } else {
            result = false;
        }
        return result;
    }
}
