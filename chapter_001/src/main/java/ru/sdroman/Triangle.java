package ru.sdroman;

import static java.lang.Math.*;

public class Triangle {
    public Point a;
    public Point b;
    public Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private boolean isExist(double sideA, double sideB, double sideC) {
        return ((sideB + sideC - sideA) > 0) && ((sideA + sideC - sideB) > 0) && ((sideA + sideB - sideC) > 0);
    }

    public double area() {
        double sideA = a.distanceTo(b);
        double sideB = b.distanceTo(c);
        double sideC = a.distanceTo(c);
        if (isExist(sideA, sideB, sideC)) {
            double p = (sideA + sideB + sideC) / 2;
            return sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
        } else {
            return -1;
        }
    }
}

