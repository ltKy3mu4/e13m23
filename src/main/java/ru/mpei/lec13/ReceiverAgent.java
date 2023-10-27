package ru.mpei.lec13;

import jade.core.Agent;

public class ReceiverAgent extends Agent {


    @Override
    protected void setup() {
        this.addBehaviour(new ParallelBeh());
    }
}
