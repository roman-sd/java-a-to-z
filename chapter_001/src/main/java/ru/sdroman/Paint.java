package ru.sdroman;

public class Paint {

    public String pyramid(int h) {
        StringBuilder result = new StringBuilder();
        int space = 0;
        int chr = 0;
        for (int i = 0; i <= h - 1; i++) {
            while (space < h) {
                result.append(" ");
                space++;
            }
            while (chr <= i) {
                result.append("^").append(" ");
                chr++;
            }
            result.append("\n");
            space = i + 1;
            chr = 0;
        }
        return result.toString();
    }
}
