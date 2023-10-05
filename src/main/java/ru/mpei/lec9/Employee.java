package ru.mpei.lec9;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String name;
    private String surname;
    private String department;
    private int experience;
    private Sex sex;

}
