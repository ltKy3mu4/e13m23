package ru.mpei.lec12;

import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class SearchBehaviour extends TickerBehaviour {
    public SearchBehaviour(Agent a, long period) {
        super(a, period);
    }

    @Override
    protected void onTick() {
        System.out.println("Where is all?");
    }
}
