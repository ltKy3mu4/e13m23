package ru.mpei.lec21;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import ru.mpei.lec16.UdpSocketClient;

import java.util.function.Consumer;

class UdpSocketServerTest {

    @Test
    @SneakyThrows
    public void testUdpRec(){
        FIleAppender fa = new FIleAppender();
//        SteroidUdpSocketServer server = new SteroidUdpSocketServer();
//        server.start(2020);
        SteroidUdpSocketServer.getInstance().start(2020);
        SteroidUdpSocketServer.getInstance().addDataListener(s -> fa.save(s));

        UdpSocketClient client =new UdpSocketClient();
        client.initialize(2020);
        for (int i = 0; i < 4; i++) {
            Thread.sleep(1000);
            client.send("Hello"+i);
        }



    }

}