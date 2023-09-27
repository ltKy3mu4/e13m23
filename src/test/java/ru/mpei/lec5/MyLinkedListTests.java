package ru.mpei.lec5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTests {

    @Test
    void removeTest(){
        List<String> list = new MyLinkedList<>();
        list.add("st1");
        list.add("st2");
        list.add("st3");

        Assertions.assertEquals(3, list.size());
        Assertions.assertTrue(list.remove("st2"));
        Assertions.assertEquals(2, list.size());
        Assertions.assertFalse(list.remove("st2"));
        Assertions.assertEquals(2, list.size());
    }

    @Test
    void addTest1(){
        List<String> list = new MyLinkedList<>();
        list.add("st1");
        list.add("st2");
        list.add("st3");

        Assertions.assertEquals("st3", list.get(2));
    }

    @Test
    void addTest2(){
        List<String> list = new MyLinkedList<>();
        list.add("st1");
        list.add("st2");
        list.add("st3");

        Assertions.assertThrows(IndexOutOfBoundsException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                list.get(4);
            }
        });
    }

    @Test
    void setTest2(){
        List<String> list = new MyLinkedList<>();
        list.add("st1");
        list.add("st2");
        list.add("st3");

        Assertions.assertEquals("st3", list.get(2));
        list.set(2, "STTTTT");
        Assertions.assertEquals("STTTTT", list.get(2));


    }

}