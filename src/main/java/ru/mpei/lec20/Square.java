package ru.mpei.lec20;

public class Square extends Rectangular{
    public Square(double sideA) {
        super(sideA, sideA);
    }

    @Override
    public double area() {
        if (sideA < 0){
            throw new RuntimeException("Can not calculate");
        } else {
            return super.area();
        }
    }
}
