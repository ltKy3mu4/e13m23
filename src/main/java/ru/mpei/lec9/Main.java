package ru.mpei.lec9;

import ru.mpei.lec5.Student;
import ru.mpei.lec7.Fruit;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(List.of(-2, 5, 1, 10, -8, 6));
        l.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? 1 : o1 < o2 ? -1 : 0;
//                if (o1 > o2) {
//                    return 1;
//                } else if (o1 < o2) {
//                    return -1;
//                } else {
//                    return 0;
//                }
            }
        });
        System.out.println(l);

        int a = 2, b = 4, c;
        if (a > b) {
            c = 5;
        } else {
            c = 2;
        }
        c = a > b ? 5 : 2;

        List<Student> stL = new ArrayList<>(List.of(
                new Student("Jack", 20),
                new Student("Tom", 18),
                new Student("Carlos", 27),
                new Student("Betty", 6))
        );

        stL.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() > o2.getAge() ? -1 : 1;
            }
        });

        System.out.println(stL);

        stL.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(stL);

        ActiveStudent s = new ActiveStudent("Tom", 20);
        Fruit f = new Fruit("apple", 2, "sort");
        s.setAction(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                f.setAge(20);
                System.out.println(student.getName() + " i'm sleeping");
            }
        });

        s.doSomething();

        s.setAction(st -> System.out.println(st.getName() + " i'm studing" + f.getSort()));
        s.doSomething();

        Consumer<String> consumer = new Consumer<>() {

            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer<String> consumer2 = s1 -> {
            System.out.println(s1);
            System.out.println(f);
        };

        Supplier<Student> supplier = new Supplier<>() {

            @Override
            public Student get() {
                return s;
            }
        };


        Supplier<Student> supplier2 = () -> s;

        stL.sort((o1, o2) -> o1.getAge() > o2.getAge() ? -1 : 1);

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Jack", "Russel", "rzia", 5, Sex.Man),
                new Employee("Betty", "Simpleton", "tvn", 2, Sex.Woman),
                new Employee("Marry", "Bloody", "ees", 10, Sex.Woman),
                new Employee("Tom", "Kapinos", "rzia", 7, Sex.Man),
                new Employee("Crazy", "Bart", "rzia", 1, Sex.Man)
        ));

        List<Employee> employees1 = employees.stream()
                .filter(e -> e.getSurname().startsWith("B") && e.getSex() == Sex.Man)
                .toList();

        List<Employee> womenFromEEs = employees.stream()
                .filter(e -> e.getSex() == Sex.Woman && e.getDepartment().equals("ees"))
                .toList();



        System.out.println(employees1);
        System.out.println(womenFromEEs);


        Set<String> departments = employees.stream()
                .filter(e -> e.getExperience() > 3)
                .map(employee -> employee.getDepartment())
                .collect(Collectors.toSet());
        System.out.println(departments);

        double asDouble = employees.stream()
                .filter(e -> e.getSex() == Sex.Nonbinary)
                .mapToDouble(employee -> employee.getExperience())
                .average()
                .orElse(0.0);

        System.out.println(asDouble);

        double sum = employees.stream()
                .sorted((o1, o2) -> o1.getExperience() < o2.getExperience() ? -1 : 1)
                .limit(3)
                .mapToDouble(e -> e.getExperience())
                .sum();

        System.out.println(sum);

        Optional<Employee> any = employees.stream()
                .filter(e -> e.getSex() == Sex.Woman)
                .findAny();

        if (any.isPresent()){
            Employee anyWoman = any.get();
        } else {
            System.err.println("No woman no cry");
        }

        Optional<Employee> mostExperienced = employees.stream()
                .filter(e -> e.getSex() == Sex.Woman)
                .sorted((o1, o2) -> o1.getExperience() > o2.getExperience() ? -1 : 1)
                .findFirst();

        System.out.println(mostExperienced.get());

    }
}
