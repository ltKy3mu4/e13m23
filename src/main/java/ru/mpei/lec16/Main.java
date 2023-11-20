package ru.mpei.lec16;

import jade.core.AID;
import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
//        AID a = new AID("Agent_1", false);
//        UdpSocketServer s = new UdpSocketServer();
//        s.start(1200);
//        UdpSocketServer s2 = new UdpSocketServer();
//        s2.start(1200);
//
        RawUdpSocketServer rawServer = new RawUdpSocketServer();
        rawServer.start(1200);

//        UdpSocketClient c = new UdpSocketClient();
//        c.initialize(1200);
//        int counter = 0;
        RawUdpSocketCLient cLient = new RawUdpSocketCLient();
        cLient.initialize(1200);
        byte[] testData = new byte[]{2, 0, 0, 0, 69, 0, 0, 35, 81, -73, 0, 0, -128, 17, 0, 0, -84, 20, 10, 9, -84, 20, 10, 9, -34, 46, 4, -80, 0, 15, 60, -60, 104, 101, 108, 108, 111, 32, 48};

        while (true){
            cLient.send(testData);
//            c.send("hello "+counter++);
            Thread.sleep(1000);
        }







    }
}
