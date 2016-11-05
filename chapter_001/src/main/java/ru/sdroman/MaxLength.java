package ru.sdroman;

public class MaxLength {

    public double max(double sideA, double sideB, double sideC) {
        double maxLen = Math.max(sideA, sideB);
        maxLen = Math.max(maxLen, sideC);       
        return maxLen;
    }
}