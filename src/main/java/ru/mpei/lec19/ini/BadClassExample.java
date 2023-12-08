package ru.mpei.lec19.ini;

import lombok.SneakyThrows;
import ru.mpei.lec11.JsonUtils;
import ru.mpei.lec18.TCPExchanger;
import ru.mpei.lec19.DataSource;
import ru.mpei.lec19.model.Request;
import ru.mpei.lec19.model.Response;

import java.io.*;
import java.net.Socket;
import java.util.Optional;

public class BadClassExample {
    private int port=4444;
    private String socketAddress = "127.0.0.1";
    private String statCalulcationUtilPath ="C:\\Users\\user\\IdeaProjects\\e13m23\\src\\main\\resources\\FakeStat-1.0-jar-with-dependencies.jar";
    private String reportPath="report.txt";

    public boolean createReport(DataSource.GoodsType gType){

        /**  send request to TCP sever to get DATA*/
        Socket tcpSocketClient;
        try {
            tcpSocketClient = new Socket(socketAddress, port);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        try {
            PrintWriter printWriter = new PrintWriter(tcpSocketClient.getOutputStream(), true);
            String data = JsonUtils.code(new Request(gType));
            printWriter.println(data);
            printWriter.flush();
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
        /**  wait response */
        String answer ="";
        try {
            InputStream inputStream = tcpSocketClient.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            answer = in.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }

        /**  decode DATA */
        Optional<Response> priceResponse = JsonUtils.decode(answer, Response.class);
        if (priceResponse.isEmpty()){
            return false;
        }

        /**  save data to file */
        Response response = priceResponse.get();
        try (PrintWriter out = new PrintWriter(new FileWriter(reportPath))){
            out.println(response.getPrice());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        /**  execute statistic utility */
        try {

            ProcessBuilder pb = new ProcessBuilder("java", "-jar", statCalulcationUtilPath, reportPath);

            Process start = pb.start();
            while (start.isAlive()){
                start.isAlive();
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        /**  read statistic  */
        Double dRes = null;
        try (BufferedReader brr = new BufferedReader(new FileReader("result.txt"));){
            StringBuilder sb = new StringBuilder();
            String line = brr.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = brr.readLine();
            }
            String result = sb.toString();
            dRes = Double.parseDouble(result);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
        if (dRes == null){
            return false;
        }
        /** asses statistic*/
        return dRes > 100;
    }


}
