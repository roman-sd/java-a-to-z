package ru.sdroman.lite.testingPerformance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class PerformanceTest.
 *
 * @author sdroman
 * @version 0.1
 * @since 04.17
 */
public class PerformanceTest {

    /**
     * Amount.
     */
    private static final int AMOUNT = 10_000_000;

    /**
     * CollectionPerformanceTest.
     */
    private CollectionPerformanceTest test;

    /**
     * LinkedList.
     */
    private List<String> linkedList;

    /**
     * ArrayList.
     */
    private List<String> arrayList;

    /**
     * TreeSet.
     */
    private Set<String> treeSet;

    /**
     * Constructs a new PerformanceTest object.
     */
    public PerformanceTest() {
        test = new CollectionPerformanceTest();
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();
        treeSet = new TreeSet<>();
    }

    /**
     * Main.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        PerformanceTest performanceTest = new PerformanceTest();
        performanceTest.testAdd();
        performanceTest.testRemove();
    }

    /**
     * Test add.
     */
    public void testAdd() {
        System.out.println("Test add:");
        String line = "testString.";
        System.out.println(String.format("%s%s", "LinkedList : ", test.add(linkedList, line, AMOUNT)));
        System.out.println(String.format("%s%4s", "ArrayList : ", test.add(arrayList, line, AMOUNT)));
        System.out.println(String.format("%s%6s", "TreeSet : ", test.add(treeSet, line, AMOUNT)));
    }

    /**
     * Test remove.
     */
    public void testRemove() {
        System.out.println("Test remove:");
        System.out.println(String.format("%s%s", "LinkedList : ", test.delete(linkedList, AMOUNT - 1)));
        System.out.println(String.format("%s%s", "ArrayList :  ", "-"));
        System.out.println(String.format("%s%4s", "TreeSet : ", test.delete(treeSet, AMOUNT - 1)));
    }
}
