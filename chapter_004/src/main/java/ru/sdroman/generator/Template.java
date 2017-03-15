package ru.sdroman.generator;

import ru.sdroman.generator.exception.ExtraKeysException;
import ru.sdroman.generator.exception.KeyNotFoundException;

import java.util.Map;

/**
 * Interface Template.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public interface Template {

    /**
     * Replacing Template with keys.
     *
     * @param template String
     * @param data     Map<String, String>
     * @return String
     * @throws KeyNotFoundException exception
     * @throws ExtraKeysException   exception
     */
    String generate(String template, Map<String, String> data) throws KeyNotFoundException, ExtraKeysException;
}
