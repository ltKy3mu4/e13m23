package ru.mpei.lec4;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int denominator = 0;
//        try {
//            double res = Main.devide(10, denominator);
//            System.out.println("all ok");
//        } catch (RuntimeException ae){
//            ae.printStackTrace();
//        }
        System.out.println("im here");


//        int[] arr = {2,5,6,3};
//
//        for (int i=0; i < 5; i++){
//            System.out.println(arr[i]);
//        }

//        try {
//            callMe();
//            System.out.println("try");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println("catch");
//            throw new RuntimeException(e);
//        } finally {
//            System.out.println("finally");
//        }
//        Scanner s = null;
//        try {
//            s = new Scanner(new File("src/main/resources/cfg2.txt"));
//            while (s.hasNextLine()) {
//                String str = s.next();
//                System.out.println(str);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            if (s != null){
//                s.close();
//            }
//        }

        MoneyExchanger me = new MoneyExchanger(120, -5);
        me.setSocialRating(50);

        try {
            me.makeTransaction("hdashdahsd", 150);
        } catch (BankException e){
            e.printStackTrace();
        }



    }

    public static int devide(int num, int denom) {
        if (denom == 100){
            throw new NullPointerException("can not deived on 100");
        }
        return num/denom;
    }

    public static void callMe2() throws SQLException {
        Main.callMe();
    }

    public static void callMe() throws SQLException {
        throw new SQLException("Bad sql mfucka");
    }
}
