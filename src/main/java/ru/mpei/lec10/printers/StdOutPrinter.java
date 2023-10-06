package ru.mpei.lec10.printers;

import ru.mpei.lec10.Bean;

@Bean(name = "Out")
public class StdOutPrinter implements Printer{
    @Override
    public void print(String str) {
        System.out.println(str);
    }
}
