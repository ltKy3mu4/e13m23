package ru.mpei.lec18.notification;

import ru.mpei.lec18.Order;

public class SmsNoty implements Notyfier{


    @Override
    public void send(Order o) {
        //TODO:
    }

    @Override
    public NotyType getType() {
        return NotyType.SMS;
    }
}
