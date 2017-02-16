package ru.sdroman.findFiles;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test Finder class.
 *
 * @author sdroman
 * @version 0.1
 * @since 13.02.17
 */
public class FinderTest {

    /**
     * Finder object.
     */
    private Finder finder;

    /**
     * Array of parameters.
     */
    private Param param;

    /**
     * SetUp.
     *
     * @param keyName String filename to found
     * @param keyFind String key
     * @throws IOException exception
     */
    private void setUp(String keyName, String keyFind) throws IOException {
        String path = new File(".").getAbsolutePath();
        String[] args = new String[]{"-d", path, "-n", keyName, keyFind, "-o", "log.log"};
        this.param = new Param(args);
        Pattern pattern = Pattern.compile(param.getName());
        finder = new Finder(pattern, param.getLogFile());
    }

    /**
     * Test find() by name.
     *
     * @throws IOException exception
     */
    @Test
    public void whenFindByNameThenFind() throws IOException {
        setUp("pom.xml", "-f");
        boolean actual = finder.isFound(this.param.getDir());
        assertThat(actual, is(true));
    }

    /**
     * Test find() by mask.
     *
     * @throws IOException exception
     */
    @Test
    public void whenFindByMaskThenFind() throws IOException {
        setUp(".*.xml", "-m");
        boolean actual = finder.isFound(this.param.getDir());
        assertThat(actual, is(true));
    }

    /**
     * Test find() by regex.
     *
     * @throws IOException exception
     */
    @Test
    public void whenFindByRegexThenFind() throws IOException {
        setUp(".+om.+", "-r");
        boolean actual = finder.isFound(this.param.getDir());
        assertThat(actual, is(true));
    }

    /**
     * File not found.
     *
     * @throws IOException exception
     */
    @Test
    public void whenNotFileThenReturnFileNotFound() throws IOException {
        setUp("ttttttttt.xxxxx", "-f");
        boolean actual = finder.isFound(this.param.getDir());
        assertThat(actual, is(false));
    }
}
