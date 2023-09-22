package ru.mpei.lec5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private List<Student> students = new ArrayList<>();

    @Test
    void listTestAdd1(){
        Assertions.assertEquals(10, students.size());
    }

    @Test
    void listTestAdd2(){
        Assertions.assertTrue(students.contains(new Student("StName2", 2)));
        Assertions.assertFalse(students.contains(new Student("StName10", 10)));
    }

    @Test
    void listTestAdd3(){

        Assertions.assertTrue(students.remove(new Student("StName9",9)));
        Assertions.assertFalse(students.remove(new Student("StName11",11)));

        Assertions.assertEquals(new Student("StName2",2), students.get(2));
    }

    @Test
    void exceptionThrowTest1(){
        Assertions.assertThrows(IndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                students.get(11);
            }
        });
    }

    @BeforeEach
    void refreshList(){
        students.clear();
        for (int i =0; i < 10; i++){
            students.add(new Student("StName"+i, i));
        }
    }



}