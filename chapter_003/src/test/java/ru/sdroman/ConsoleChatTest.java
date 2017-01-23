package ru.sdroman;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test ConsoleChat.
 * @author sdroman
 * @since 23.01.17
 * @version 0.1
 */
public class ConsoleChatTest {

    /**
     * Path to botPhrase.txt file.
     */
    private static final String BOT_PHRASES_FILE_PATH = "src\\test\\java\\ru\\sdroman\\resources\\botPhrases.txt";
    /**
     * Path to logFile.txt file.
     */
    private static final String LOG_FILE_PATH = "src\\test\\java\\ru\\sdroman\\resources\\logFile.txt";

    /**
     * Test numberOfLines() method in ConsoleChat class.
     *
     * @throws IOException exception
     */
    @Test
    public void whenGiveThreeLinesInFileThenReturnThree() throws IOException {
        File testFile = new File(BOT_PHRASES_FILE_PATH);
        ConsoleChat consoleChat = new ConsoleChat(testFile, new File(LOG_FILE_PATH), new ConsoleInput());
        String[] lines = new String[]{"firstLine", "secondLine", "thirdLine"};
        writeBotPhrasesFile(lines, testFile);
        final int expected = 3;
        assertThat(consoleChat.numbersOfLines(testFile), is(expected));
        testFile.delete();
    }

    /**
     * Test botPhrases() method in ConsoleChat class.
     *
     * @throws IOException exception
     */
    @Test
    public void whenGiveBotPhrasesFileThenReturnRandomBotPhrase() throws IOException {
        File botPhrasesFile = new File(BOT_PHRASES_FILE_PATH);
        String firstPhrase = "firstBotPhrase";
        String secondPhrase = "secondBotPhrase";
        String thirdPhrase = "thirdBotPhrase";
        String[] botPhrases = new String[]{firstPhrase, secondPhrase, thirdPhrase};
        writeBotPhrasesFile(botPhrases, botPhrasesFile);
        ConsoleChat consoleChat = new ConsoleChat(botPhrasesFile, new File(LOG_FILE_PATH), new ConsoleInput());
        String actualPhrase = consoleChat.botPhrase();
        StringBuilder strBuilder = new StringBuilder(firstPhrase).append(secondPhrase).append(thirdPhrase);
        assertThat(strBuilder.toString().contains(actualPhrase), is(true));
        botPhrasesFile.delete();
    }

    /**
     * Test writeLogFile() method in ConsoleChat class.
     *
     * @throws IOException exception
     */
    @Test
    public void whenCallingWriteLogFileThenWriteLogFile() throws IOException {
        File logFile = new File(LOG_FILE_PATH);
        ConsoleChat consoleChat = new ConsoleChat(new File(BOT_PHRASES_FILE_PATH), logFile, new ConsoleInput());
        consoleChat.writeLogFile("testLine", "testUser: ");
        String actual;
        try (BufferedReader br = new BufferedReader(new FileReader(LOG_FILE_PATH))) {
            actual = br.readLine();
        }
        assertThat(actual, is("testUser: testLine"));
        logFile.delete();
    }

    /**
     * Test chat() method in ConsoleChat class.
     *
     * @throws IOException exception
     */
    @Test
    public void whenCallingChatThenChat() throws IOException {
        File botPhrasesFile = new File(BOT_PHRASES_FILE_PATH);
        File logFile = new File(LOG_FILE_PATH);
        String[] botPhrases = {"BotPhrase"};
        String[] userPhrases = {"firstUserPhrase", "стоп", "secondUserPhrase", "продолжить", "закончить"};
        ConsoleChat consoleChat = new ConsoleChat(botPhrasesFile, logFile, new StubInput(userPhrases));
        writeBotPhrasesFile(botPhrases, botPhrasesFile);
        consoleChat.chat();
        String expected = "user: firstUserPhrase" + "bot: BotPhrase" + "user: стоп"
                + "user: secondUserPhrase" + "user: продолжить" + "bot: BotPhrase" + "user: закончить";
        String tmpLine;
        StringBuilder actual = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(logFile), "UTF-8"))) {
            while ((tmpLine = br.readLine()) != null) {
                actual.append(tmpLine);
            }
        }
        assertThat(actual.toString(), is(expected));
        botPhrasesFile.delete();
        logFile.delete();
    }

    /**
     * To write a bot phrases in the file.
     *
     * @param botPhrases     String[]
     * @param botPhrasesFile File
     * @throws IOException exception
     */
    private void writeBotPhrasesFile(String[] botPhrases, File botPhrasesFile) throws IOException {
        String separator = System.getProperty("line.separator");
        try (BufferedWriter bWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(botPhrasesFile)))) {
            for (String phrase : botPhrases) {
                bWriter.write(phrase);
                bWriter.write(separator);
            }
        }
    }
}
