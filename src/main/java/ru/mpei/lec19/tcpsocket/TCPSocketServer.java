package ru.mpei.lec19.tcpsocket;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketServer {
    private boolean run = false;

    @SneakyThrows
    public void start(int port){
        run = true;
        ServerSocket serverSocket = new ServerSocket(port);

        Socket clientConnection = serverSocket.accept();

        InputStream inputStream = clientConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        while (run){
            String s = bufferedReader.readLine();
            System.out.println(s);
        }
        serverSocket.close();
    }


}
