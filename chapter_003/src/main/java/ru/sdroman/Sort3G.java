package ru.sdroman;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Class Sort3G.
 *
 * @author sdroman
 * @version 1.0
 * @since 17.01.17
 */
class Sort3G {

    /**
     * Sorting method.
     *
     * @param source   File
     * @param distance File result
     * @throws IOException exception
     */
    void sort(File source, File distance) throws IOException {
        File firstFile = new File("firstFile.txt");
        File secondFile = new File("secondFile.txt");
        deleteTmpFiles(firstFile, secondFile);
        distance.delete();
        partition(source, firstFile, secondFile);
        merge(distance, firstFile, secondFile);
        while (secondFile.length() != 0) {
            deleteTmpFiles(firstFile, secondFile);
            partition(distance, firstFile, secondFile);
            distance.delete();
            merge(distance, firstFile, secondFile);
        }
        deleteTmpFiles(firstFile, secondFile);
    }

    /**
     * Read from readFile and write to writeFile.
     *
     * @param readFile  RandomAccessFile to read
     * @param writeFile RandomAccessFile to write
     * @param str       String
     * @return String
     * @throws IOException exception
     */
    private String writeAndRead(RandomAccessFile readFile, RandomAccessFile writeFile, String str) throws IOException {
        writeFile.writeBytes(String.format("%s\r\n", str));
        return readFile.readLine();
    }

    /**
     * Split source file on two temporary files.
     *
     * @param source File source
     * @param firstTmpFile File temporary file
     * @param secondTmpFile file temporary file
     * @throws IOException exception
     */
    void partition(File source, File firstTmpFile, File secondTmpFile) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(source, "r");
             RandomAccessFile rafFirst = new RandomAccessFile(firstTmpFile, "rw");
             RandomAccessFile rafSecond = new RandomAccessFile(secondTmpFile, "rw")) {

            String str = raf.readLine();
            int strLength;
            boolean flag = true;
            while (str != null) {
                if (flag) {
                    strLength = str.length();
                    str = writeAndRead(raf, rafFirst, str);
                    while (str != null && strLength <= str.length()) {
                        strLength = str.length();
                        str = writeAndRead(raf, rafFirst, str);
                    }
                    flag = false;
                } else {
                    strLength = str.length();
                    str = writeAndRead(raf, rafSecond, str);
                    while (str != null && strLength <= str.length()) {
                        strLength = str.length();
                        str = writeAndRead(raf, rafSecond, str);
                    }
                    flag = true;
                }
            }
        }
    }

    /**
     * Merge two files.
     *
     * @param source File source
     * @param firstTmpFile File temporary file
     * @param secondTmpFile File temporary file
     * @throws IOException exception
     */
    void merge(File source, File firstTmpFile, File secondTmpFile) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(source, "rw");
             RandomAccessFile rafFirst = new RandomAccessFile(firstTmpFile, "rw");
             RandomAccessFile rafSecond = new RandomAccessFile(secondTmpFile, "rw")) {

            String str1 = rafFirst.readLine();
            String str2 = rafSecond.readLine();
            while (str1 != null && str2 != null) {
                if (str1.length() < str2.length()) {
                    str1 = writeAndRead(rafFirst, raf, str1);
                } else {
                    str2 = writeAndRead(rafSecond, raf, str2);
                }
            }
            while (str1 != null) {
                str1 = writeAndRead(rafFirst, raf, str1);
            }
            while (str2 != null) {
                str2 = writeAndRead(rafSecond, raf, str2);
            }
        }
    }

    /**
     * Delete temporary files.
     *
     * @param firstTmpFile File temporary file
     * @param secondTmpFile File temporary file
     */
    private void deleteTmpFiles(File firstTmpFile, File secondTmpFile) {
        firstTmpFile.delete();
        secondTmpFile.delete();
    }
}

