package ru.mpei.lec19.refactor;

import ru.mpei.lec11.JsonUtils;
import ru.mpei.lec19.DataSource;
import ru.mpei.lec19.model.Response;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

public class RefactoredClassExample {
    private SocketTCPClient client;
    private FileDataManipulator fileWorker = new FileDataManipulator();
    private String responseFilepath;

    private OperationSystemProcessesManipulator processWorker;

    public RefactoredClassExample(String address, int port) {
        client = new SocketTCPClient(address, port);
    }

    public boolean createReport(DataSource.GoodsType gType) {
        boolean connect = client.connect();
        boolean send = client.send(gType);
        Optional<String> answer = client.receive();

        Optional<Response> priceResponse = JsonUtils.decode(answer.get(), Response.class);
        if (priceResponse.isEmpty()){
            return false;
        }

        fileWorker.save(priceResponse.get().getPrice()+"", responseFilepath);

        processWorker.runJar("src\\main\\resources\\FakeStat-1.0-jar-with-dependencies.jar", List.of(responseFilepath));

        Optional<String> read = fileWorker.read("result.txt");
        String stringValue = read.get();
        double v = Double.parseDouble(stringValue);
        return  v > 100;


    }
}
