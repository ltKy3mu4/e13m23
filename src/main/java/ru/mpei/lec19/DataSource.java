package ru.mpei.lec19;

import lombok.SneakyThrows;
import ru.mpei.lec11.JsonUtils;
import ru.mpei.lec19.model.Request;
import ru.mpei.lec19.model.Response;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Optional;

public class DataSource {

    @SneakyThrows
    public void ss(int port) {
        Thread mainTread = new Thread(() -> {
            ServerSocket server = null;
            try {
                server = new ServerSocket(port);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            while (true) {
                try {
                    Socket clientConnection = server.accept();
                    new Thread(() -> handleConnection(clientConnection)).start();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Started");
            }
        }
        );

        mainTread.setName("SocketServerThread");
        mainTread.start();
        mainTread.join();

    }

    @SneakyThrows
    private void handleConnection(Socket clientSocket) {

        InputStream inputStream = clientSocket.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        OutputStream outputStream = clientSocket.getOutputStream();
        PrintWriter out = new PrintWriter(outputStream, true);
        while (true) {
            String message;
            try {
                message = in.readLine();
            } catch (Exception e) {
                e.printStackTrace();
                in.close();
                out.close();
                return;
            }
            Optional<Request> req = JsonUtils.decode(message, Request.class);
            if (req.isEmpty()) {
                continue;
            }
            double price = choosePrice(req.get().getType());
            out.println(JsonUtils.code(new Response(price)));
            out.flush();
        }
    }

    private double choosePrice(GoodsType t) {
        double price = -1;
        switch (t) {
            case flower -> price = 10.0;
            case toy -> price = 15.0;
            case computer -> price = 100.5;
            case application -> price = 100500;
        }
        return price;
    }


    public enum GoodsType {
        toy, computer, flower, application
    }
}
