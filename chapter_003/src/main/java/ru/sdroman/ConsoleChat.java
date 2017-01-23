package ru.sdroman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 * Class ConsoleChat.
 *
 * @author sdroman
 * @version 0.1
 * @since 21.01.17
 */
public class ConsoleChat {

    /**
     * Input.
     */
    private Input input;

    /**
     * Log file.
     */
    private File logFile;

    /**
     * File for bot phrases.
     */
    private File botPhrasesFile;

    /**
     * Constructs a new ConsoleChat object.
     * @param botPhrasesFile File
     * @param logFile File
     * @param input Input
     */
    public ConsoleChat(File botPhrasesFile, File logFile, Input input) {
        this.botPhrasesFile = botPhrasesFile;
        this.logFile = logFile;
        this.input = input;
    }

    /**
     * Number of lines in file phrases for bot.
     *
     * @param file File
     * @return int
     * @throws IOException exception
     */
    int numbersOfLines(File file) throws IOException {
        int lineNumber = 0;
        try (LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file))) {
            while (lineNumberReader.readLine() != null) {
                lineNumber++;
            }
        }
        return lineNumber;
    }

    /**
     * Generate phrases for bot.
     *
     * @return String
     * @throws IOException exception
     */
    String botPhrase() throws IOException {
        String[] phrasesArray = new String[numbersOfLines(botPhrasesFile)];
        try (BufferedReader br = new BufferedReader(new FileReader(botPhrasesFile))) {

            String line = br.readLine();
            int count = 0;
            while (line != null) {
                phrasesArray[count++] = line;
                line = br.readLine();
            }
        }
        Random random = new Random();
        return phrasesArray[random.nextInt(phrasesArray.length)];
    }

    /**
     * Write in logfile.
     *
     * @param str      String
     * @param userName String
     * @throws IOException exception
     */
    void writeLogFile(String str, String userName) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(logFile, true), "UTF-8"))) {
            bw.write(userName);
            bw.write(str);
            bw.write(System.getProperty("line.separator"));
        }
    }

    /**
     * Check empty log file.
     *
     * @throws IOException exception
     */
    private void isEmptyLogFile() throws IOException {
        if (logFile.exists()) {
            logFile.delete();
            logFile.createNewFile();
        }
    }

    /**
     * Chat.
     *
     * @throws IOException exception
     */
    void chat() throws IOException {
        isEmptyLogFile();
        String user = "user: ";
        String bot = "bot: ";
        System.out.println("Chat");
        boolean isStop = false;
        System.out.print(user);
        String userStr = input.ask();
        writeLogFile(userStr, user);
        while (!userStr.equalsIgnoreCase("закончить")) {
            if (userStr.equalsIgnoreCase("стоп")) {
                isStop = true;
            }
            if (userStr.equalsIgnoreCase("продолжить")) {
                isStop = false;
            }

            if (!isStop) {
                System.out.print(bot);
                String botStr = botPhrase();
                System.out.println(botStr);
                writeLogFile(botStr, bot);
            }
            System.out.print(user);
            userStr = input.ask();
            writeLogFile(userStr, user);
        }
    }
}
