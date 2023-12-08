package ru.mpei.lec19.refactor;

import ru.mpei.lec11.JsonUtils;
import ru.mpei.lec19.DataSource;
import ru.mpei.lec19.model.Request;

import java.io.*;
import java.net.Socket;
import java.util.Optional;

public class SocketTCPClient {

    private final String address;
    private final int port;

    private Socket tcpSocketClient;

    public SocketTCPClient(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public boolean connect(){
        try {
            tcpSocketClient = new Socket(address, port);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean send(DataSource.GoodsType gType){
        try {
            PrintWriter printWriter = new PrintWriter(tcpSocketClient.getOutputStream(), true);
            String data = JsonUtils.code(new Request(gType));
            printWriter.println(data);
            printWriter.flush();
            return true;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }

    public Optional<String> receive(){
        /**  wait response */
        String answer ="";
        try {
            InputStream inputStream = tcpSocketClient.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            answer = in.readLine();
            in.close();
            return Optional.of(answer);
        }catch (IOException e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
