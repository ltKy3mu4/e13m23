package ru.mpei.lec9;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.mpei.lec5.Student;

import java.util.function.Consumer;

@EqualsAndHashCode(callSuper = true)
@Data
public class ActiveStudent extends Student {

    public ActiveStudent(String name, int age) {
        super(name, age);
    }

    private Consumer<Student> action;

    public void doSomething(){
        action.accept(this);
    }
}
