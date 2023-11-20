package ru.mpei.lec18;

public interface DataExchanger {


    boolean send(Order o);
    Order receive();

}
