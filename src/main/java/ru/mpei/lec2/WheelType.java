package ru.mpei.lec2;

public class WheelType {
    private String label;
    private double radius;
    private boolean forWinter;

    public WheelType(String label, double radius, boolean forWinter) {
        this.label = label;
        this.radius = radius;
        this.forWinter = forWinter;
    }

    public WheelType() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean isForWinter() {
        return forWinter;
    }

    public void setForWinter(boolean forWinter) {
        this.forWinter = forWinter;
    }

    @Override
    public String toString() {
        return "WheelType{" +
                "label='" + label + '\'' +
                ", radius=" + radius +
                ", forWinter=" + forWinter +
                '}';
    }
}
