package ru.sdroman.findFiles;

/**
 * Class Param.
 * @author sdroman
 * @since 16.02.17
 * @version 0.2
 */
public class Param {

    /**
     * 0.
     */
    private static final int FIRST = 0;

    /**
     * 1.
     */
    private static final int SECOND = 1;

    /**
     * 2.
     */
    private static final int THIRD = 2;

    /**
     * 3.
     */
    private static final int FOURTH = 3;

    /**
     * 4.
     */
    private static final int FIFTH = 4;

    /**
     * 5.
     */
    private static final int SIXTH = 5;

    /**
     * 6.
     */
    private static final int SEVENTH = 6;

    /**
     * Error.
     */
    private static final String ERR = "err";

    /**
     * Array of parameters.
     */
    private String[] args;

    /**
     * Constructs the new Param object.
     * @param args String
     */
    Param(String[] args) {
        this.args = args;
    }

    /**
     * Gets length of array.
     * @return int
     */
    public int getLength() {
        return this.args.length;
    }

    /**
     * Gets first element of array: -d key.
     * @return String
     */
    public String getDirKey() {
        return this.args[FIRST] != null ? this.args[FIRST] : ERR;
    }

    /**
     * Gets second element of array: directory to find.
     * @return String
     */
    public String getDir() {
        return this.args[SECOND] != null ? this.args[SECOND] : ERR;
    }

    /**
     * Gets third element of array: -n key.
     * @return String
     */
    public String getFileNameKey() {
        return this.args[THIRD] != null ? this.args[THIRD] : ERR;
    }

    /**
     * Gets third element of array: filename, mask or regex.
     * @return String
     */
    public String getName() {
        return this.args[FOURTH] != null ? this.args[FOURTH] : ERR;
    }

    /**
     * Gets fifth element of array: -f, -m, -r keys.
     * @return String
     */
    public String getFindKey() {
        return this.args[FIFTH] != null ? this.args[FIFTH] : ERR;
    }

    /**
     * Gets sixth element of array: -o key.
     * @return String
     */
    public String getLogKey() {
        return this.args[SIXTH] != null ? this.args[SIXTH] : ERR;
    }

    /**
     * Gets seven element of array: logfile.
     * @return String
     */
    public String getLogFile() {
        return this.args[SEVENTH] != null ? this.args[SEVENTH] : ERR;
    }
}
