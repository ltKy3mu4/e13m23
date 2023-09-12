package ru.mpei.lec3;

public interface Walkable {
    double walk();

    default int getVersion(){
        return 42;
    }
}
