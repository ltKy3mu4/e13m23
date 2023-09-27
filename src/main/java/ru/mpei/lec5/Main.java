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

        List l3 = new ArrayList();
        l3.add("dsad");
        l3.add(1);
        l3.add(new Student("name", 2));
        l3.add(3);
        int sum = 0;
        for (int i = 0; i < l3.size(); i++) {
            if (l3.get(i) instanceof Integer){
               sum += (int)l3.get(i);
            }
        }
        System.out.println("Sum = "+sum);

        List<Integer> ints = new ArrayList<>();
//        ints.add("1");

        MyOptional<String> strVal = new MyOptional<>();
        boolean empty2 = strVal.isEmpty();
        //empty2 == true
        strVal.set("newValue");
        //empty2 == false

        String s = strVal.get();

        MyOptional<Student> studentVal = new MyOptional<>();
        studentVal.set(new Student("St", 2));

        Student student = studentVal.get();



//        MyLinkedList<String> myList = new MyLinkedList<>();
//        myList.add("Str1");
//        myList.add("Str2");
//        myList.add("Str3");
//        myList.add("Str4");
//        myList.add("Str5");
//        myList.add("Str6");
//        int size = myList.size();
//        System.out.println("Size="+ size);
//
//        printAll(myList);

        List<Student> sts = new MyLinkedList<>();
        sts.add(new Student("St1", 1));
        sts.add(new Student("St2", 2));
        printAll(sts);

        List<MasterStudent> msts= new MyLinkedList<>();
        msts.add(new MasterStudent("Name1", 20, "deg"));
        msts.add(new MasterStudent("Name2", 12, "deg"));
        msts.add(new MasterStudent("Name3", 16, "deg"));
        printAll(msts);

        sortStudent(msts);
        printAll(msts);

    }

    public static void printAll(List<? extends Student> list){
        System.out.println("---------------------------");
        double averageAge = 0;
        for (int i=0; i < list.size(); i++){
            System.out.println(list.get(i));
            Student student = list.get(i);
            averageAge += student.getAge();
        }
        averageAge /= list.size();
        System.out.println("average age"+averageAge);
    }

    public static void sortStudent(List<? extends Student> list){
        sort(list);
    }

    public static<T extends Student> void sort(List<T> list){
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(j).getAge() < list.get(i).getAge()){
                    T s = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, s);
                }
            }
        }
    }


}
