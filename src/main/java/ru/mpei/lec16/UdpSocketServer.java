package ru.mpei.lec16;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpSocketServer {
    private byte[] packetData = new byte[500];
    private Thread recThread;

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
                System.out.println("Server recevied: "+s);
            }
        });
        recThread.start();

    }

    public void stop(){

    }
}
