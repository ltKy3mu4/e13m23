package ru.mpei.lec20;

public class Rectangular {

    protected double sideA;
    protected double sideB;

    public Rectangular(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double area(){
        return sideA * sideB;
    }
}
