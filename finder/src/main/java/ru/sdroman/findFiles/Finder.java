package ru.sdroman.findFiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class finder.
 *
 * @author sdroman
 * @version 0.1
 * @since 13.02.17
 */
public class Finder {

    /**
     * Pattern.
     */
    private Pattern pattern;

    /**
     * Count.
     */
    private int count = 0;

    /**
     * log file.
     */
    private File logFile;

    /**
     * Constructs new Finder objects.
     *
     * @param logFile String
     * @param pattern Pattern
     * @throws IOException exception
     */
    public Finder(Pattern pattern, String logFile) throws IOException {
        this.pattern = pattern;
        initLogFile(logFile);
    }

    /**
     * log file.
     *
     * @param name String
     * @throws IOException exception
     */
    private void initLogFile(String name) throws IOException {
        logFile = new File(name);
        logFile.delete();
    }

    /**
     * accept.
     *
     * @param name String
     * @return boolean
     */
    private boolean accept(String name) {
        if (pattern == null) {
            return true;
        }
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    /**
     * Search file in directories.
     *
     * @param searchPath String
     * @return int count
     * @throws IOException exception
     */
    private int searchFile(String searchPath) throws IOException {
        File dir = new File(searchPath);
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (accept(file.getName()) && !file.isDirectory()) {
                        writeLogFile(file.getAbsolutePath());
                        count++;
                    }
                    if (file.isDirectory()) {
                        searchFile(file.toString());
                    }
                }
            }
        }
        return count;
    }

    /**
     * isFound.
     *
     * @param searchPath String
     * @return boolean
     * @throws IOException exception
     */
    public boolean isFound(String searchPath) throws IOException {
        int count = searchFile(searchPath);
        if (count == 0) {
            writeLogFile("File not found");
            return false;
        }
        return true;
    }

    /**
     * Write to log file.
     *
     * @param str String
     * @throws IOException exception
     */
    private void writeLogFile(String str) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(logFile, true), "UTF-8"))) {
            bw.write(str);
            bw.write(System.getProperty("line.separator"));
        }
    }
}

