package ru.mpei.lec18;

public class OderProcessor {

    private DataExchanger exchanger;

    public OderProcessor(DataExchanger exchanger) {
        this.exchanger = exchanger;
    }

    public void receive(Order o){
        Order receive = exchanger.receive();
        System.err.println(receive);
        //TODO:save
    }

    public void handle(Order o){

    }

    public void sendBack(Order o){
        boolean res = exchanger.send(o);
    }


}
