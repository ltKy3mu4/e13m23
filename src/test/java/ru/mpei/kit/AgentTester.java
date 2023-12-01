package ru.mpei.kit;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AgentTester extends Agent {

    @Override
    protected void setup() {
        log.info("i was started {} with {} behaviours", this.getLocalName(), this.getArguments().length);
        for (Object argument : getArguments()) {
            Behaviour behToAdd = (Behaviour)argument;
            this.addBehaviour(behToAdd);
        }


    }
}
