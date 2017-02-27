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
        Param param = new Param(this.args);
        boolean result = true;
        Pattern pattern;
        ValidateKey validator = new ValidateKey(this.args);

        if (validator.valid()) {
            if ("-f".equalsIgnoreCase(param.getFindKey())
                    || "-r".equalsIgnoreCase(param.getFindKey())) {
                pattern = Pattern.compile(param.getName());
                new Finder(pattern, param.getLogFile()).isFound(param.getDir());
            } else {
                if ("-m".equalsIgnoreCase(param.getFindKey())) {
                    String tmpStr = param.getName();
                    tmpStr = tmpStr.replace("?", ".?");
                    tmpStr = tmpStr.replace("*", ".*");
                    pattern = Pattern.compile(tmpStr);
                    new Finder(pattern, param.getLogFile()).isFound(param.getDir());
                }
            }
        } else {
            result = false;
        }
        return result;
    }
}
