package ru.mpei.lec11;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

public class JsonUtils {

    private static ObjectMapper mapper = new ObjectMapper();


    public static <T> Optional<T> decode(String s, Class<T> cl) {
        T t;
        try {
            t = mapper.readValue(s, cl);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return Optional.empty();
        }
        return Optional.of(t);
    }

    public static String code(Object o){
        String s = null;
        try {
            s = mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }
        return s;
    }



}
