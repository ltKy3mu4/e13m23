package ru.mpei.lec18.notification;

import ru.mpei.lec18.Order;

public interface Notyfier {
    void send(Order o);

    NotyType getType();
}
