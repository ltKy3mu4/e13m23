package ru.mpei.lec19.tcpsocket;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TCPSocketServerTest {

    @Test
    void tcpServerSocketTestRun(){
        var server = new TCPSocketServer();
        server.start(1500);

    }

    @Test
    @SneakyThrows
    void tcpClientTestSend(){
        var client = new TCPSocketClient();
        client.connect("127.0.0.1", 1500);
        for (int i = 0; i < 10; i++) {
            client.send("Data "+i);
            Thread.sleep(500);
        }
    }

}