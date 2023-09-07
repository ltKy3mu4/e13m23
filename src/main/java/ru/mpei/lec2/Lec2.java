package ru.mpei.lec2;

public class Lec2 {
    public static void main(String[] args) {
        Car car1 = new Car();
        String info = car1.shortInfo();
        System.out.println(info);
        car1.setModel("Lada");
        System.out.println(car1.shortInfo());

        Car car2 = new Car();
        car1.setModel("Mazda");
        System.out.println(car2.shortInfo());

        car2.model = "WV";
        car2.model = null;

        Car car3 = new Car("VW", 10);
        System.out.println(car3.shortInfo());
        int f = car3.getAge()+1;
        car3.setAge(f);

        WheelType wt = new WheelType("Nokian", 18, true);
        car3.setWheelType(wt);
        System.out.println(car3);
//        System.out.println(car2);
//
//        car3.toString();

        Student st1 = new Student("Ivanov", 10);
        st1.setGroup("e-13m-23");
        Student st2 = new Student("Ivanov", 10);
        st2.setGroup("e-13m-22");
        System.out.println(st1.equals(st2));

        System.out.println(st2.hashCode());
        System.out.println(st1.hashCode());

        Student st3 = st2;

        Class<?> aClass = st2.getClass();

    }
}
