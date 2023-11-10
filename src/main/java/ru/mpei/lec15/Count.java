package ru.mpei.lec15;

import lombok.Data;

@Data
public class Count{
    int sum = 0;

    public void test(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (this){
            sum++;
        }
    }

    public synchronized void increment(){
        System.out.println("THread "+ Thread.currentThread().getName()+" is working "+sum);

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        sum++;
    }

}