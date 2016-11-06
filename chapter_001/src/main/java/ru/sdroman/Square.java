package ru.sdroman;

public class Square {
    private int a;
    private int b;
    private int c;

    public Square(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;         
    }
    public float calculate(int x) {
        return a * x * x + b * x + c;
    }

    public void show(int start, int finish, int step) {
        for (int i = start; i <= finish; i += step) {
            System.out.println(calculate(i));
        }
    }
}