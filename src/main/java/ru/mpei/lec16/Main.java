package ru.mpei.lec16;

import jade.core.AID;
import lombok.SneakyThrows;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        AID a = new AID("Agent_1", false);
//        UdpSocketServer s = new UdpSocketServer();
//        s.start(1200);
//        UdpSocketServer s2 = new UdpSocketServer();
//        s2.start(1200);
//
        RawUdpSocketServer rawServer = new RawUdpSocketServer();
        rawServer.start(1200);

        UdpSocketClient c = new UdpSocketClient();
        c.initialize(1200);
        int counter = 0;
        while (true){
            c.send("hello "+counter++);
            Thread.sleep(1000);
        }




    }
}
