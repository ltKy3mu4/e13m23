package ru.mpei.lec10.printers;

import ru.mpei.lec10.Bean;

@Bean(name = "Err")
public class StdErrPrinter implements Printer{
    @Override
    public void print(String str) {
        System.err.println(str);
    }
}
