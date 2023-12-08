package ru.mpei.lec19.tcpsocket;

import lombok.SneakyThrows;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPSocketClient {
    private PrintWriter pw;

    @SneakyThrows
   public void connect(String address, int port){
       Socket client = new Socket(address, port);
       var outputStream = client.getOutputStream();
       pw = new PrintWriter(outputStream);
   }

   @SneakyThrows
   public void send(String data){
       pw.println(data);
       pw.flush();
   }

}
