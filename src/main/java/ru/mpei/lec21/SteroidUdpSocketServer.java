package ru.mpei.lec21;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SteroidUdpSocketServer {

    private SteroidUdpSocketServer(){}

    private static SteroidUdpSocketServer INSTANCE ;

    public synchronized static SteroidUdpSocketServer getInstance(){
        if (INSTANCE == null){
            INSTANCE = new SteroidUdpSocketServer();
        }
        return INSTANCE;
    }

    private byte[] packetData = new byte[500];
    private Thread recThread;

    private List<Consumer<String>> dataConsumers = new ArrayList<>();

    public void start(int port){
        recThread = new Thread(() -> {
            DatagramSocket socket = null;
            try {
                socket = new DatagramSocket(port);
            } catch (SocketException e) {
                throw new RuntimeException(e);
            }
            DatagramPacket packet = new DatagramPacket(packetData, packetData.length);
            while (true){
                try {
                    socket.receive(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                byte[] data = packet.getData();
                String s = new String(data).replace("\000", "");
                dataConsumers.forEach(e -> e.accept(s));
            }
        });
        recThread.start();

    }

    public void addDataListener(Consumer<String> c){
        dataConsumers.add(c);
    }

    public void stop(){

    }
}
