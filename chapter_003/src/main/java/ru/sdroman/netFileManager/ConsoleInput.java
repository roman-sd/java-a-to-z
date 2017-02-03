package ru.sdroman.netFileManager;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Class ConsoleInput.
 * @author sdroman
 * @version 0.1
 */
public class ConsoleInput implements Input {
    /**
     * Asks the question and returns a answer.
     *
     * @return String answer
     */
    @Override
    public String ask(String question, DataInputStream inStream, DataOutputStream outStream) throws IOException {
        outStream.writeUTF(question);
        return new Scanner(inStream.readUTF()).nextLine();
    }
}
