package ru.mpei.lec18;

import lombok.SneakyThrows;

public class UDPExchanger {

    /**
     * Send order data to consumer
     * @param o - order that will be sent
     */
    public void send(Order o ){

    }

    @SneakyThrows
    public Order receive() {
        Thread.sleep(1000);
        return new Order();
    }
}
