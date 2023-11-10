package ru.mpei.lec15;

import lombok.Data;
import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
//        System.out.println("Hello from Thread "+Thread.currentThread().getName());
////        MyCalculationThread t1 = new MyCalculationThread();
////        t1.start();
//        Count c = new Count();
//        Thread thread = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
////                if (c.sum > 0) {
////                    return;
////                }
//                System.err.println("Hello from Thread "+Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
////                    throw new RuntimeException(e);
//                    e.printStackTrace();
//                    System.err.println("Did not finish my task");
//                    return;
//                }
//            }
//        });
//        thread.setName("Dummy-thread");
//        thread.start();


//        Thread.sleep(2000);
//        c.sum = 20;
//        thread.interrupt();
//
//        System.out.println("FINISHED "+Thread.currentThread().getName());

        Count c = new Count();
        Thread thread = new Thread(() -> {
            for (int j = 0; j < 3; j++) {
//                c.setSum(c.getSum() + 1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                c.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int j = 0; j < 3; j++) {
                //                c.setSum(c.getSum() + 1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                c.increment();
            }
        });
        thread2.start();
        thread.start();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            long start = System.currentTimeMillis();
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis() - start);
            }
        }));


        // Synchronized by fields??
        // ДЗ по потокам
        // где main поток в VisualVM?
    }


}
