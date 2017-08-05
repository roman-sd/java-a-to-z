package ru.sdroman.synchronizy.findtext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sdroman
 * @since 08.2017
 */
public class StartUI {

    /**
     * Main.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        String startDir = "e:\\";
        String textToFind = "thread";
        List<String> list = new ArrayList<>();
        list.add(".*.txt");
        list.add(".*.log");
        list.add(".*.xml");

        ParallelSearch controller = new ParallelSearch(startDir, textToFind, list);
        controller.start();
    }
}
