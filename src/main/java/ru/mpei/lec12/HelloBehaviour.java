package ru.mpei.lec12;

import jade.core.behaviours.OneShotBehaviour;

public class HelloBehaviour extends OneShotBehaviour {
    @Override
    public void action() {
        System.out.println("Hello all, I'm "+this.myAgent.getLocalName());
    }
}
