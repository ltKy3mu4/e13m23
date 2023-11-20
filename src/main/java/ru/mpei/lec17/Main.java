package ru.mpei.lec17;

import lombok.SneakyThrows;
import ru.mpei.lec15.Count;
import ru.mpei.lec16.RawUdpSocketCLient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
//        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
//
//        var server = new RawUdpSocketServerBasedOnExecutor(executorService);
//        server.start(1200);
//
//        var client = new RawUdpSocketClientScheduled(executorService);
//        client.initialize(1200);
//        byte[] testData = new byte[]{2, 0, 0, 0, 69, 0, 0, 35, 81, -73, 0, 0, -128, 17, 0, 0, -84, 20, 10, 9, -84, 20, 10, 9, -34, 46, 4, -80, 0, 15, 60, -60, 104, 101, 108, 108, 111, 32, 48};
//        client.periodicSend(testData, 1000);
//
//        Thread.sleep(5000);
////        client.stop();
//        server.stopServer();

        AtomicInteger ar = new AtomicInteger(0);


        new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
            ar.incrementAndGet();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10_000; i++) {
                ar.incrementAndGet();
            }
        }).start();

        Thread.sleep(1000);
        System.out.println(ar.get());




//        List<String> l = new CopyOnWriteArrayList<>();
        List<String> l = new ArrayList<>();

        new Thread(() -> {
            int count = 0;
            while (true){
                l.add(""+ count++);
            }
        }).start();

        new Thread(() -> {
            int count = 0;
            while (true){
                l.add(""+ count++);
            }
        }).start();

        new Thread(() -> {
            for (String s : l) {
                System.out.println(s);
                l.remove(s);
            }
            System.out.println(l);
        }).start();
    }
}
