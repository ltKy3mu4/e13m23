package ru.mpei.lec12;

import jade.core.Agent;

public class Spammer extends Agent {
    @Override
    protected void setup() {
        this.addBehaviour(
                new DelayedMsgSendingBehaviour(this, 15000)
        );
    }
}
