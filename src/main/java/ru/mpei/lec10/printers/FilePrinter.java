package ru.mpei.lec10.printers;

import lombok.SneakyThrows;
import ru.mpei.lec10.Bean;

import java.io.PrintWriter;

@Bean(name = "File")
public class FilePrinter implements Printer{
    @Override
    @SneakyThrows
    public void print(String str) {
        PrintWriter out = new PrintWriter("filename.txt");
        out.print(str);
        out.close();
    }
}
