package ru.mpei.lec20;

import java.sql.SQLOutput;

public class Main {


    public static void main(String[] args) {
       printArea(new Rectangular(-2,-2));
       printArea(new Square(-2));
    }

    public static void printArea( Rectangular a){
        System.out.println(a.area());
    }
}
