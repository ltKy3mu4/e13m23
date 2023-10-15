package ru.mpei.lec11;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Optional;

public class XmlUtils {
    private XmlUtils() {}

    public static <T> Optional<T> parse(String path, Class<T> clazz){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Object obj = jaxbUnmarshaller.unmarshal(new File(path));
            T res = (T) obj;
            return  Optional.of(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static void marshal(Object object, String path){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(object, new File(path));
        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
