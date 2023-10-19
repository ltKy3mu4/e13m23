package ru.mpei.lec12;

import jade.core.Agent;

public class MyAgent extends Agent {

    @Override
    protected void setup() {
//        this.addBehaviour(new HelloBehaviour());
//        this.addBehaviour(new SearchBehaviour(this, 5000));
        this.addBehaviour(new ReceiveMsgBehaviour());
    }
}
