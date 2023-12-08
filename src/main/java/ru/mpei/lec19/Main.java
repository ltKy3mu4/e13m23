package ru.mpei.lec19;

import ru.mpei.lec19.ini.BadClassExample;

public class Main {

    public static void main(String[] args) {
        BadClassExample bce = new BadClassExample();
        boolean report = bce.createReport(DataSource.GoodsType.application);
        if (report){
            System.out.println("Report successfully created");
        } else {
            System.out.println("Error!");

        }
    }
}
