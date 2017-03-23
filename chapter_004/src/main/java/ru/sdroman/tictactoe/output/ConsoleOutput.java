package ru.sdroman.tictactoe.output;

import ru.sdroman.tictactoe.Interfaces.Output;

/**
 * ConsoleOutput class.
 *
 * @author sdroman
 * @version 0.1
 * @since 03.17
 */
public class ConsoleOutput implements Output {

    /**
     * separator.
     */
    private static final String LN = System.getProperty("line.separator");

    /**
     * Print.
     *
     * @param field int[][]
     */
    @Override
    public void printField(int[][] field) {
        int count = 0;
        System.out.print("x\\y");
        for (int i = 0; i < field.length; i++) {
            System.out.print(String.format("%s%s%s", "  ", i, ":"));
        }
        System.out.print(LN);
        printDivider(field.length);
        for (int i = 0; i < field.length; i++) {
            System.out.print(count + ": | ");
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 0) {
                    System.out.print(" ");
                } else {

                    System.out.print(this.getSign(field[i][j]));
                }
                System.out.print(String.format("%s%s%s", " ", "|", " "));
            }
            System.out.print(LN);
            printDivider(field.length);
            count++;
        }
    }

    /**
     * Returns signs to string.
     *
     * @param sign int
     * @return String
     */
    private String getSign(int sign) {
        return sign == 1 ? "X" : "0";
    }

    /**
     * Print divider.
     * @param length int
     */
    private void printDivider(int length) {
        System.out.print("    ");
        for (int i = 0; i < length - 1; i++) {
            System.out.print("----");
        }
        System.out.println("---");
    }
}
