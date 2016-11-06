package ru.sdroman;

public class Factorial {

    public long calculateFactorial(int n) {
        long fact = 1;
        for(int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}