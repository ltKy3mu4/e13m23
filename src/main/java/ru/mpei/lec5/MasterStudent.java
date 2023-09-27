package ru.mpei.lec5;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class MasterStudent extends Student{

    public MasterStudent(String name, int age, String degree) {
        super(name, age);
        this.degree = degree;
    }

    private String degree;

}
