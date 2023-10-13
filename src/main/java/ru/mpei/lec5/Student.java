package ru.mpei.lec5;

import lombok.*;

import java.util.Objects;
import java.util.function.Consumer;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private int age;

}
