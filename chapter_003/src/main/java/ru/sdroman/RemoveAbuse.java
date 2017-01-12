package ru.sdroman;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * class RemoveAbuse.
 * @author sdroman
 * @since 11.10.17
 * @version 1.0
 */
public class RemoveAbuse {

    /**
     * Remove abuse.
     * @param in InputStream
     * @param out OutputStream
     * @param abuse String[]
     */
    public void dropAbuse(InputStream in, OutputStream out, String[] abuse) {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(in))) {
            String string;

            while ((string = input.readLine()) != null) {
                for (String word : abuse) {
                    if (string.contains(word)) {
                        string = string.replace(word, "");
                    }
                }
                out.write(string.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
