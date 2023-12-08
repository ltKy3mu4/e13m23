package ru.mpei.lec19.refactor;

import ru.mpei.lec19.model.Response;

import java.io.*;
import java.util.Optional;

public class FileDataManipulator {
    public boolean save(String data, String path){
        try (PrintWriter out = new PrintWriter(new FileWriter(path))){
            out.println(data);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    public Optional<String> read(String path){
        try (BufferedReader brr = new BufferedReader(new FileReader(path));){
            StringBuilder sb = new StringBuilder();
            String line = brr.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = brr.readLine();
            }
            return Optional.of(sb.toString());
        } catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }

}
