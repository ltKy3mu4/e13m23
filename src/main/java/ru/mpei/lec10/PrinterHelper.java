package ru.mpei.lec10;

import lombok.extern.slf4j.Slf4j;
import ru.mpei.lec10.printers.Printer;

import java.util.ArrayList;
import java.util.List;

public class PrinterHelper {
    static {
        try {
            printers = new BeanAnnotationPostProcessor().findBeans();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private static List<Printer> printers;

//    public PrinterHelper() {
//        try {
//            printers = new BeanAnnotationPostProcessor().findBeans();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void printALl(String s){
        for (Printer printer : printers) {
            printer.print(s);
        }
    }

}
