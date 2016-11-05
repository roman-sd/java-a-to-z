package ru.sdroman;

public class MaxLength {

    public double max(double... sides) {
        double maxLen = sides[0];
        for (double side : sides) {
            if (side > maxLen) {
                maxLen = side;
            }
        }
        return maxLen;
    }
}