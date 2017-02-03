package ru.sdroman.netFileManager;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class ServerTest.
 * @author sdroman
 */
public class ServerTest {

    /**
     * separator.
     */
    private String separator = System.getProperty("line.separator");

    /**
     * Temporary file for test.
     */
    private File file;

    /**
     * SetUp.
     * @param command String
     * @throws IOException exception
     */
    private void setUp(String command) throws IOException {
        String propertiesFile = "appForTest.properties";
        Settings settings = new Settings(propertiesFile);
        String homePath = settings.getHomePath();
        file = new File(homePath + "testOut.txt");

        try (DataInputStream in = new DataInputStream(new ByteArrayInputStream("".getBytes()));
             DataOutputStream out = new DataOutputStream(new FileOutputStream(file))) {
            MenuFileManager menu = new MenuFileManager(in, out, propertiesFile);
            menu.fillActions();
            menu.select(command);
        }
    }

    /**
     * Actual.
     * @param file File
     * @return String
     * @throws IOException exception
     */
    private String actualResult(File file) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader brt = new BufferedReader(new FileReader(file))) {
            builder.append(brt.readLine().substring(2)).append(separator);
            String str;
            while ((str = brt.readLine()) != null) {
                builder.append(str).append(separator);
            }
        }
        return builder.toString();
    }

    /**
     * Test dir command in MenuFileManager class.
     * @throws IOException exception
     */
    @Test
    public void whenCommandIsDirThenReturnDirectories() throws IOException {
        String expected = "main" + separator + "test" + separator + "testOut.txt" + separator;
        setUp("dir");
        String actual = actualResult(file);
        assertThat(actual, is(expected));
        file.delete();
    }

    /**
     * Test cd command.
     * @throws IOException exception
     */
    @Test
    public void whenChangeDirThenReturnChangeDirectory() throws IOException {
        String expected = "java" + separator + "resources" + separator;
        setUp("cd main");
        String actual = actualResult(file);
        assertThat(actual, is(expected));
        file.delete();
    }

    /**
     * Test ls command.
     * @throws IOException exception
     */
    @Test
    public void whenCommandIsLsThenRootDirectory() throws IOException {
        String expected = "main" + separator + "test" + separator + "testOut.txt" + separator;
        setUp("ls");
        String actual = actualResult(file);
        assertThat(actual, is(expected));
        file.delete();
    }

    /**
     * Test help command.
     * @throws IOException exception
     */
    @Test
    public void whenCommandIsHelpThenShowCommands() throws IOException {
        String[] expectedArray = {String.format("%s\t%39s", "cd [path]", "change directory"),
                String.format("%s\t%28s", "download [fileName]", "download file"),
                String.format("%s\t%31s", "upload [path]//[filename]", "upload file in home path"),
                String.format("%s\t%45s", "ls", "home directory"),
                String.format("%s\t%40s", "help", "list commands"),
                String.format("%s\t%67s", "dir", "list of files and folders"),
                String.format("%s\t%31s", "exit", "quit")};
        StringBuilder builder = new StringBuilder();
        for (String line : expectedArray) {
            builder.append(line).append(separator);
        }
        setUp("help");
        String expected = builder.toString();
        String actual = actualResult(file);
        assertThat(actual, is(expected));
        file.delete();
    }
}
