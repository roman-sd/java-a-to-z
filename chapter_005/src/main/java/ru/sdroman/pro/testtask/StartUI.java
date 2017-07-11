package ru.sdroman.pro.testtask;

import ru.sdroman.lite.testingPerformance.StopWatch;

import java.io.IOException;

/**
 * Class StartUI.
 * @author sdroman
 * @since 06.2017
 */
public class StartUI {

    /**
     * Main.
     * @param args arguments.
     * @throws IOException exception
     */
    public static void main(String[] args) throws IOException {
        Settings settings = new Settings("app.properties");
        String file = settings.getValue("orders");
        StopWatch time = new StopWatch();

        Splitter splitter = new Splitter();
        StAXParser stAXParser = new StAXParser();
        RegexParser regexParser = new RegexParser();

        Run runStAX = new Run();
        time.start();
        runStAX.distOrders(stAXParser.parse(file));
        System.out.println("StAXParser: " + time.getElapsedTime());

        Run runRegex = new Run();
        time.start();
        runRegex.distOrders(regexParser.parse(file));
        System.out.println("RegexParser: " + time.getElapsedTime());

        Run runSplit = new Run();
        time.start();
        runSplit.distOrders(splitter.parse(file));
        System.out.println("Splitter: " + time.getElapsedTime());
    }
}
