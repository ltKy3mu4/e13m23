package ru.mpei.lec7;

import ru.mpei.lec5.Student;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Map<String, Student> map = new HashMap<>();

        map.put("Id1", new Student("name1",1));
        map.put("Id2", new Student("name1",2));
        map.put("Id3", new Student("name1",3));
        map.put("Id4", new Student("name1",4));

        Student id3 = map.get("Id3");
        Student id5 = map.get("Id5");

        String key = "Id3";
        if ( map.containsKey(key)) {
            map.get(key);
        }

        Student remove = map.remove(key);

        for (Map.Entry<String, Student> entry : map.entrySet()) {
            Student value = entry.getValue();
            String key1 = entry.getKey();
        }

        Fruit fruit1 = new Fruit("apple", 2, "Antonovka");
        Fruit fruit2 = new Fruit("apple", 4, "GranySmith");
        Fruit fruit3 = new Fruit("pineapple", 1, "African");
        Fruit fruit4 = new Fruit("tomato", 5, "kumato");
        Fruit fruit5 = new Fruit("tomato", 2, "cherry");

        int i1 = fruit1.hashCode();
        int i2 = fruit2.hashCode();

        List<Fruit> fruits = List.of(fruit1, fruit2, fruit3, fruit4, fruit5, fruit5);

        List<Fruit> tomatos = new ArrayList<>();
        for (Fruit fruit : fruits) {
            if (fruit.getName().equals("tomato")){
                tomatos.add(fruit);
            }
        }

        double sumAge = 0;
        for (Fruit tomato : tomatos) {
            sumAge += tomato.getAge();
        }
        sumAge /= tomatos.size();

        tomatos.stream()
                .filter(fruit -> fruit.getName().equals("tomato"))
                .mapToDouble(e -> e.getAge())
                .forEach(System.out::println);

        System.out.println();

    }

}
