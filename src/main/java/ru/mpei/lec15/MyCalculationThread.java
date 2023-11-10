package ru.mpei.lec15;

public class MyCalculationThread extends Thread{

    @Override
    public void run() {
        while (true) {
            System.out.println("Hello from Thread "+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
