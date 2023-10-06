package ru.mpei.lec10;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import ru.mpei.lec10.printers.Printer;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BeanAnnotationPostProcessor {

    public List<Printer> findBeans() throws Exception{
        List<Printer> printers = new ArrayList<>();
        Reflections r = new Reflections(Printer.class);
        Set<Class<?>> typesAnnotatedWith = r.getTypesAnnotatedWith(Bean.class);
        for (Class<?> clazz : typesAnnotatedWith) {
            if (!Printer.class.isAssignableFrom(clazz)){
                continue;
            }

            Bean annotation = clazz.getAnnotation(Bean.class);
            String name = annotation.name();

            Printer o = (Printer)clazz.getDeclaredConstructor().newInstance();
            printers.add(o);
        }
        return printers;
    }

}
