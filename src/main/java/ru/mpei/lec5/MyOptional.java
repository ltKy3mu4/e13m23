package ru.mpei.lec5;

public class MyOptional<T> {
    private T object = null;

    public T get() {
        return object;
    }

    public void set(T object) {
        this.object = object;
    }

    public boolean isEmpty(){
        return object == null;
    }

    public boolean isPresent(){
        return object != null;
    }
}
