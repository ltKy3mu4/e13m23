package ru.mpei.lec5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> l = new ArrayList<>();

        l.add("First String");
        l.add("Second String");
        l.remove("Second String");
        boolean empty = l.isEmpty();
        boolean conts = l.contains("First String");
//        String s = l.get(1);
        int firstString = l.indexOf("First String");
        System.out.println();

        List<String> l2 = new LinkedList<>();
        l2.add("String1");
        l2.add("String2");
        l2.add("String3");
        l2.add("String4");

        l2.forEach( e -> System.out.println(e));

    }
}
