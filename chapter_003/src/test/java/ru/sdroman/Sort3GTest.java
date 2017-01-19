package ru.sdroman;

import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test class Sort3G.
 *
 * @author sdroman
 * @version 1.0
 * @since 19.01.17
 */
public class Sort3GTest {

    /**
     * Test partition() method in Sort3G class.
     *
     * @throws IOException exception
     */
    @Test
    public void whenGiveFileThenSplitTwoFiles() throws IOException {
        String separator = System.getProperty("line.separator");
        String expectedStrOne = "я" + separator + "не" + separator + "колбаса" + separator + "хипстер";
        String expectedStrTwo = "я" + separator + "поросёнок" + separator + "нет" + separator + "мочалка";
        File expectedTmpFirst = new File("src/test/java/ru/sdroman/resources/expectedFirstTmp.txt");
        File expectedTmpSecond = new File("src/test/java/ru/sdroman/resources/expectedSecondTmp.txt");

        try (BufferedWriter bwOne = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(expectedTmpFirst), "UTF8"));
             BufferedWriter bwTwo = new BufferedWriter(new OutputStreamWriter(
                     new FileOutputStream(expectedTmpSecond), "UTF8"))) {
            bwOne.write(expectedStrOne);
            bwTwo.write(expectedStrTwo);
        }
        File source = new File("src/test/java/ru/sdroman/resources/sourceFile.txt");
        File firstTmp = new File("src/test/java/ru/sdroman/resources/firstTmp.txt");
        File secondTmp = new File("src/test/java/ru/sdroman/resources/secondTmp.txt");
        Sort3G sort3G = new Sort3G();
        sort3G.partition(source, firstTmp, secondTmp);
        test(firstTmp, expectedTmpFirst);
        test(secondTmp, expectedTmpSecond);
        expectedTmpFirst.delete();
        expectedTmpSecond.delete();
        firstTmp.delete();
        secondTmp.delete();
    }

    /**
     * Test merge() method in Sort3G class.
     *
     * @throws IOException exception
     */
    @Test
    public void whenGiveTwoFilesThenMerge() throws IOException {
        String separator = System.getProperty("line.separator");
        String expectedStr = "я" + separator + "я" + separator + "не" + separator + "колбаса" + separator
                + "хипстер" + separator + "поросёнок" + separator + "нет" + separator + "мочалка";
        File expectedFile = new File("src/test/java/ru/sdroman/resources/expectedFile.txt");
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(expectedFile), "UTF8"))) {
            bw.write(expectedStr);
        }

        File source = new File("src/test/java/ru/sdroman/resources/sourceFile.txt");
        File firstTmp = new File("src/test/java/ru/sdroman/resources/firstTmp.txt");
        File secondTmp = new File("src/test/java/ru/sdroman/resources/secondTmp.txt");
        File distance = new File("src/test/java/ru/sdroman/resources/distanceFile.txt");
        Sort3G sort3G = new Sort3G();
        sort3G.partition(source, firstTmp, secondTmp);
        sort3G.merge(distance, firstTmp, secondTmp);
        test(distance, expectedFile);
        distance.delete();
        firstTmp.delete();
        secondTmp.delete();
        expectedFile.delete();
    }

    /**
     * Test Sort() method in Sort3G class.
     *
     * @throws IOException exception
     */
    @Test
    public void whenSortThenSorting() throws IOException {
        String separator = System.getProperty("line.separator");
        String expectedStr = "я" + separator + "я" + separator + "не" + separator + "нет" + separator
                + "мочалка" + separator + "колбаса" + separator + "хипстер" + separator + "поросёнок";
        File expectedFile = new File("src/test/java/ru/sdroman/resources/expectedFile.txt");
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(expectedFile), "UTF8"))) {
            bw.write(expectedStr);
        }
        Sort3G sortFile = new Sort3G();
        File source = new File("src/test/java/ru/sdroman/resources/sourceFile.txt");
        File distance = new File("src/test/java/ru/sdroman/resources/distanceFile.txt");
        sortFile.sort(source, distance);
        test(distance, expectedFile);
        expectedFile.delete();
    }

    /**
     * Test.
     *
     * @param actualFile File
     * @param expectedFile File
     * @throws IOException exception
     */
    private void test(File actualFile, File expectedFile) throws IOException {
        String actual = "";
        String expected = "";
        try (RandomAccessFile rafExpected = new RandomAccessFile(expectedFile, "r");
             RandomAccessFile rafDistance = new RandomAccessFile(actualFile, "r")) {

            while (actual != null || expected != null) {
                expected = rafExpected.readLine();
                actual = rafDistance.readLine();
                assertThat(expected, is(actual));
            }
        }
    }
}
