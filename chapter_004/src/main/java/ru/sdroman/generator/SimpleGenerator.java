package ru.sdroman.generator;

import ru.sdroman.generator.exception.ExtraKeysException;
import ru.sdroman.generator.exception.KeyNotFoundException;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class SimpleGenerator.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.2017
 */
public class SimpleGenerator implements Template {

    /**
     * Pattern.
     */
    private final Pattern pattern = Pattern.compile("\\$\\{(\\w+)}");

    /**
     * Replacing Template with keys.
     *
     * @param template String
     * @param data     Map<String, String>
     * @return String
     * @throws KeyNotFoundException exception
     * @throws ExtraKeysException   exception
     */
    @Override
    public String generate(String template, Map<String, String> data) throws KeyNotFoundException, ExtraKeysException {
        StringBuffer buffer = new StringBuffer();
        Matcher matcher = pattern.matcher(template);
        int count = 0;
        while (matcher.find()) {
            String value = data.get(matcher.group(1));
            if (value != null) {
                matcher.appendReplacement(buffer, value);
                count++;
            } else {
                throw new KeyNotFoundException("Keys not found.");
            }
        }
        if (count < data.size()) {
            throw new ExtraKeysException("Extra keys.");
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }
}
