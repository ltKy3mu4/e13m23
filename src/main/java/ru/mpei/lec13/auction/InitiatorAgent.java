package ru.mpei.lec13.auction;

import jade.core.Agent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InitiatorAgent extends Agent {

    @Override
    protected void setup() {
        log.info("I was born {}", this.getLocalName());
        addBehaviour(new MyAuctionConductionFSMBehaviour());
    }
}
