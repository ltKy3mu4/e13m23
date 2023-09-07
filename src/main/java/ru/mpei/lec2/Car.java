package ru.mpei.lec2;

public class Car {
    public String model;
    private int age;

    private WheelType wheelType;

    public Car() {}

    public Car(String model, int age){
        this.model = model;
        this.age = age;
    }

    public String shortInfo(){
        return model+" age: "+age+"; radius: ";
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public WheelType getWheelType() {
        return wheelType;
    }

    public void setWheelType(WheelType wheelType) {
        this.wheelType = wheelType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", age=" + age +
                ", wheelType=" + wheelType.toString() +
                '}';
    }
}
